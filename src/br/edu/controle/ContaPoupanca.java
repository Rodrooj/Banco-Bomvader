package br.edu.controle;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    double calculaRendimento(){
        return 0;
    }
}
