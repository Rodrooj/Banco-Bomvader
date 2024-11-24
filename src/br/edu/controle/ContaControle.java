package br.edu.controle;

import br.edu.DAO.ContasDAO;
import br.edu.modelo.Cliente;
import br.edu.modelo.Conta;
import br.edu.modelo.ContaCorrente;
import br.edu.modelo.ContaPoupanca;

import java.time.LocalDate;

public class ContaControle {
    private ContasDAO contasDAO;

    public ContaControle(ContasDAO contasDAO) {
        this.contasDAO = contasDAO;
    }

    // Abertura de Conta
    public void abrirConta(String tipo, String agencia, Cliente cliente, double saldoInicial, double limite, LocalDate dataVencimento, double taxaRendimento) throws Exception {
        Conta novaConta;

        if ("CORRENTE".equalsIgnoreCase(tipo)) {
            novaConta = new ContaCorrente(0, agencia, saldoInicial, limite, dataVencimento);
        } else if ("POUPANCA".equalsIgnoreCase(tipo)) {
            novaConta = new ContaPoupanca(0, agencia, saldoInicial, taxaRendimento);
        } else {
            System.out.println("Erro: Tipo de conta inválido!");
            return;
        }

        novaConta.setCliente(cliente);
        contasDAO.salvar(novaConta);
        System.out.println("Conta " + tipo + " criada com sucesso para o cliente " + cliente.getNome() + "!");
    }

    // Encerramento de Conta
    public void encerrarConta(int numeroConta) {
        Conta conta = contasDAO.buscarPorNumero(numeroConta);
        if (conta != null) {
            contasDAO.excluir(numeroConta);
            System.out.println("Conta encerrada com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Depósito
    public void depositar(int numeroConta, double valor) {
        Conta conta = contasDAO.buscarPorNumero(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            contasDAO.atualizarSaldo(conta);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Saque
    public void sacar(int numeroConta, double valor) {
        Conta conta = contasDAO.buscarPorNumero(numeroConta);
        if (conta != null) {
            if (conta.sacar(valor)) {
                contasDAO.atualizarSaldo(conta);
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Consultar Saldo
    public double consultarSaldo(int numeroConta) {
        Conta conta = contasDAO.buscarPorNumero(numeroConta);
        if (conta != null) {
            return conta.getSaldo();
        } else {
            System.out.println("Conta não encontrada.");
            return 0.0;
        }
    }

    // Consultar Limite (para Conta Corrente)
    public double consultarLimite(int numeroConta) {
        Conta conta = contasDAO.buscarPorNumero(numeroConta);
        if (conta instanceof ContaCorrente) {
            return ((ContaCorrente) conta).getLimite();
        } else {
            System.out.println("Conta Corrente não encontrada.");
            return 0.0;
        }
    }

    // Consultar Extrato
    public void consultarExtrato(int numeroConta) {
        Conta conta = contasDAO.buscarPorNumero(numeroConta);
        if (conta != null) {
            System.out.println("Extrato da Conta " + numeroConta + ":");
            System.out.println("Saldo atual: R$" + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
