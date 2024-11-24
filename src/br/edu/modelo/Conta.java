package br.edu.modelo;

public class Conta {
    private int numero;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, String agencia, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() { // Função para consultar o saldo
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        } else {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do saque deve ser positivo.");
            return false;
        } else if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente.");
            return false;
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
