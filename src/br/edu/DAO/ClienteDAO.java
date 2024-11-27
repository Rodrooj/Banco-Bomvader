package br.edu.DAO;

import br.edu.modelo.Cliente;

import java.sql.PreparedStatement;

public class ClienteDAO extends ConexaoBanco{
    private void inserirCliente(Cliente cliente){
        try {
            abrirBanco();
            String inserir = "INSERT INTO usuario (id_usuario, nome, cpf, data_nascimento, telefone, tipo_usuario, senha) " +
                    "VALUES (null,?, ?, ?, ?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(inserir);
            pst.setInt(1, cliente.getIdUsuario());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, String.valueOf(cliente.getDataNascimento()));
            pst.setString(5, cliente.getTelefone());
            pst.setString(6, cliente.getTipoUsuario());
            pst.setString(7, cliente.getSenha());
            pst.executeUpdate();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

//    private void alterarCliente(Cliente cliente){
//        try{
//            abrirBanco();
//            String alterar = "UPDATE usuario set (nome, cpf, data_nascimento, telefone, senha) WHERE id_usuario "
//                    + "VALUES(?,?,?,?,?)";
//            pst = (PreparedStatement) con.prepareStatement(alterar);
//            pst.setString(1, cliente.getNome());
//            pst.setString(2, cliente.getCpf());
//            pst.setString(3, String.valueOf(cliente.getDataNascimento()));
//            pst.setString(4, cliente.getTelefone());
//            pst.setString(5, cliente.getSenha());
//
//        } catch (Exception e) {
//            System.out.println("Erro " + e.getMessage());
//        }
//    }
}
