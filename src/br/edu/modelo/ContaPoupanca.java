package br.edu.modelo;

public class ContaPoupanca extends Conta{
    private double taxaRendimento = 0.05;

    public ContaPoupanca(int numero, String agencia, double saldo, Cliente cliente, double taxaRendimento) {
        super(numero, agencia, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public double calculaTaxaRendimento(){
        return super.getSaldo() * taxaRendimento;
    }
}
