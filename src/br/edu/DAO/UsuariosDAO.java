package br.edu.DAO;

import br.edu.modelo.Cliente;
import br.edu.modelo.Endereco;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuariosDAO extends DAO {
    public void salvar(Cliente cliente, int tipoConta) throws Exception{
        String conta = null;
        if (tipoConta == 1){
            conta = "Funcionario";
        } else if (tipoConta == 2){
            conta = "Cliente";
        }
        try {
            abrirBanco();
            String inserir = "INSERT INTO usuario(id_usuario, nome, cpf, data_nascimento, " +
                    "telefone, tipo_usuario, senha)"
                    + " VALUES (null,?,?,?,?,?)";

            pst = (PreparedStatement) con.prepareStatement(inserir);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, String.valueOf(cliente.getDataNascimento()));
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, conta);
            pst.setString(6, cliente.getSenha());
            pst.executeUpdate();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    private void salvarEndereco(int idUsuario, Endereco endereco) throws SQLException {
        try {
            abrirBanco();
            String inserir_endereco = "INSERT INTO endereco (id_endereco, cep, logradouro, numero_casa," +
                    " bairro, cidade, estado, id_usuario) " +
                    "VALUES (null, ?, ?, ?, ?, ?, ?, null)";
            pst = (PreparedStatement) con.prepareStatement(inserir_endereco);
            pst.setInt(1, idUsuario);
            pst.setString(2, endereco.getCep());
            pst.setString(3, endereco.getLogradouro());
            pst.setInt(4, endereco.getNumeroCasa());
            pst.setString(5, endereco.getBairro());
            pst.setString(6, endereco.getCidade());
            pst.setString(7, endereco.getEstado());
            pst.setInt(8, idUsuario);
            pst.executeUpdate();
            fecharBanco();
            } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public ArrayList<Cliente> buscarPorId(int id) throws Exception{
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            abrirBanco();
            String pesquisar_por_id = "SELECT * FROM usuario WHERE id_usuario = ? AND tipo_usuario = 'CLIENTE' ";
            pst = (PreparedStatement) con.prepareStatement(pesquisar_por_id);
            ResultSet tr = pst.executeQuery();
            Cliente cliente = null;
            while (tr.next()) {
                cliente.setId(tr.getInt("id_usuario"));
                cliente.setNome(tr.getString("nome"));
                cliente.setCpf(tr.getString("cpf"));
                cliente.setDataNascimento(LocalDate.parse(tr.getString("data de nascimento")));
                cliente.setTelefone(tr.getString("telefone"));
                clientes.add(cliente);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Cliente cliente) {
        try {
            abrirBanco();
            String atualizar = "UPDATE usuario SET telefone = ?, senha = ? WHERE cpf = ?";
            pst = (PreparedStatement) con.prepareStatement(atualizar);
            pst.setString(1, cliente.getTelefone());
            pst.setString(2, cliente.getSenha());
            pst.setInt(3, cliente.getId());
            pst.executeUpdate();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void deletarCliente(Cliente cliente) throws Exception{
        abrirBanco();
        String query = "delete from cliente where id_usuario=?";
        pst=(PreparedStatement) con.prepareStatement(query);
        pst.setInt(1, cliente.getId());
        pst.execute();
        System.out.println("Cliente deletado com sucesso!");
        fecharBanco();
    }
}
