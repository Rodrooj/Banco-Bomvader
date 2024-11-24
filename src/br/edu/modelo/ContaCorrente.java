package br.edu.modelo;

import java.time.LocalDate;

public class ContaCorrente extends Conta{
    private double limite;
    private LocalDate dataVencimento;

    public ContaCorrente(int numero, String agencia, double saldo, double limite, LocalDate dataVencimento) {
        super(numero, agencia, saldo);
        this.limite = limite;
        this.dataVencimento = dataVencimento;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    double consultarLimite(){
        return limite;
    }
}
