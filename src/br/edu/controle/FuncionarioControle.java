package br.edu.controle;

import br.edu.modelo.Cliente;
import br.edu.modelo.Funcionario;

import java.time.LocalDate;

public class FuncionarioControle {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioControle(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    // Cadastrar um novo funcionário
    public void cadastrarFuncionario(String nome, String cpf, LocalDate dataNascimento, String telefone, String senha, String codigoFuncionario, String cargo) {
        Funcionario funcionario = new Funcionario(0, nome, cpf, dataNascimento, telefone, null, senha, codigoFuncionario, cargo);
        funcionarioDAO.salvar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Consultar funcionário pelo ID
    public Funcionario consultarFuncionario(int idFuncionario) {
        Funcionario funcionario = funcionarioDAO.buscarPorId(idFuncionario);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println(funcionario.consultarDados());
        } else {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
        return funcionario;
    }

    // Atualizar dados de um funcionário
    public void atualizarFuncionario(int idFuncionario, String telefone, String cargo, String senha) {
        Funcionario funcionario = funcionarioDAO.buscarPorId(idFuncionario);
        if (funcionario != null) {
            funcionario.setTelefone(telefone);
            funcionario.setCargo(cargo);
            funcionario.setSenha(senha);
            funcionarioDAO.atualizar(funcionario);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }

    // Excluir funcionário pelo ID
    public void excluirFuncionario(int idFuncionario) {
        Funcionario funcionario = funcionarioDAO.buscarPorId(idFuncionario);
        if (funcionario != null) {
            funcionarioDAO.excluir(idFuncionario);
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }

    // Abertura de conta para um cliente
    public void abrirConta(String tipo, String agencia, Cliente cliente, double saldoInicial, double limite, LocalDate dataVencimento, double taxaRendimento) {
        ContaControle contaController = new ContaControle();
        contaController.abrirConta(tipo, agencia, cliente, saldoInicial, limite, dataVencimento, taxaRendimento);
    }

    // Encerramento de conta
    public void encerrarConta(int numeroConta) {
        ContaControle contaController = new ContaControle();
        contaController.encerrarConta(numeroConta);
    }

    // Gerar relatório de movimentações financeiras
    public void gerarRelatorio() {
        // Este metodo deve ser implementado para exportar um relatório detalhado das movimentações financeiras
        // Você pode usar bibliotecas como Apache POI ou outras para exportar para Excel
        System.out.println("Relatório de movimentações financeiras gerado!");
    }
}
