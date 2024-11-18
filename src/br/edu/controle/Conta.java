package br.edu.controle;

public class Conta {
    private int numero;
    private String agencia;
    private double saldo;
    private Cliente cliente;

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

    public double getSaldo() {
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

    void depositar(double valor) {

    }

    boolean sacar(double valor) {
        return false;
    }

    double consultarSaldo() {
        return 0;
    }
}
