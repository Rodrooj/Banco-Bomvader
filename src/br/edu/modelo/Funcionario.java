package br.edu.modelo;

import java.time.LocalDate;
import java.util.Scanner;

public class Funcionario extends Usuario{
    private String codigoFuncionario;
    private String cargo;

    public Funcionario(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String senha, String codigoFuncionario, String cargo) {
        super(id, nome, cpf, dataNascimento, telefone, endereco, senha);
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void abrirConta(Cliente cliente, Scanner scanner) {
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o número da agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Conta novaConta = null;

        if (tipoConta == 1) {
            System.out.print("Defina o limite da conta corrente: ");
            double limite = scanner.nextDouble();

            System.out.print("Defina a data de vencimento (yyyy-mm-dd): ");
            scanner.nextLine(); // Limpa o buffer
            LocalDate dataVencimento = LocalDate.parse(scanner.nextLine());

            novaConta = new ContaCorrente(numero, agencia, 0.00, 0.00, LocalDate dataVencimento);
            System.out.println("Conta Corrente criada com sucesso!");
        } else if (tipoConta == 2) {
            System.out.print("Defina a taxa de rendimento: ");
            double taxaRendimento = scanner.nextDouble();

            novaConta = new ContaPoupanca(numero, agencia, 0.00, taxaRendimento);
            System.out.println("Conta Poupança criada com sucesso!");
        } else {
            System.out.println("Opção inválida. Abertura de conta cancelada.");
            return;
        }

        cliente.setConta(novaConta); // Associa a conta ao cliente
        System.out.println("Conta associada ao cliente " + cliente.getNome() + " com sucesso.");
    }

    void encerrarConta(Conta conta){

    }

    Conta consultarDadosConta(int numeroConta){
        return null;
    }

    Cliente consultarDadosCliente(int idCliente){
        return null;
    }

    void alterarDadosConta(Conta conta){

    }

    void alterarDadosCliente(Cliente cliente){

    }

    void cadastrarFuncionario(Funcionario funcionario){

    }

    void gerarRelatorioMovimentacao(){

    }
}
