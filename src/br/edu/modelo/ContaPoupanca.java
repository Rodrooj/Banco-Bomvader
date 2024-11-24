package br.edu.modelo;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public ContaPoupanca(int numero, String agencia, double saldo, double taxaRendimento) {
        super(numero, agencia, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    double calculaRendimento(){
        return getSaldo() * taxaRendimento;
    }
}
