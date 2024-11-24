package br.edu.controle;

import br.edu.DAO.UsuariosDAO;
import br.edu.modelo.Cliente;
import br.edu.modelo.Conta;
import br.edu.modelo.Endereco;

import java.time.LocalDate;

public class ClienteControle {
    private final UsuariosDAO usuariosDAO;

    public ClienteControle() {
        this.usuariosDAO = new UsuariosDAO();
    }

    public ClienteControle(UsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    // Cadastrar novo cliente
    public void cadastrarCliente(String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String senha, Conta conta) throws Exception {
        Cliente novoCliente = new Cliente(0, nome, cpf, dataNascimento, telefone, endereco, senha, conta);
        usuariosDAO.salvar(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Consultar cliente pelo ID
    public Cliente consultarCliente(int idCliente) {
        Cliente cliente = usuariosDAO.buscarPorId(idCliente);
        if (cliente != null) {
            System.out.println("Cliente encontrado: ");
            System.out.println(cliente.consultarDados());
        } else {
            System.out.println("Cliente com ID " + idCliente + " não encontrado.");
        }
        return cliente;
    }

    // Atualizar dados de um cliente
    public void atualizarCliente(int idCliente, String telefone, Endereco endereco, String senha) {
        Cliente cliente = usuariosDAO.buscarPorId(idCliente);
        if (cliente != null) {
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            cliente.setSenha(senha);
            usuariosDAO.atualizar(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente com ID " + idCliente + " não encontrado.");
        }
    }

    // Excluir cliente pelo ID
    public void excluirCliente(int idCliente) {
        Cliente cliente = usuariosDAO.buscarPorId(idCliente);
        if (cliente != null) {
            usuariosDAO.excluir(idCliente);
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Cliente com ID " + idCliente + " não encontrado.");
        }
    }

    // Consultar todas as contas de um cliente
    public void consultarContasCliente(int idCliente) {
        Cliente cliente = usuariosDAO.buscarPorId(idCliente);
        if (cliente != null) {
            Conta conta = cliente.getConta();
            if (conta == null) {
                System.out.println("O cliente não possui conta cadastrada.");
            } else {
                System.out.println("Conta associada ao cliente " + cliente.getNome() + ":");
                System.out.println("Conta " + conta.getNumero());
            }
        } else {
            System.out.println("Cliente com ID " + idCliente + " não encontrado.");
        }
    }
}
