package br.edu.controle;

import java.time.LocalDate;

public class ContaCorrente extends Conta{
    private double limite;
    private LocalDate dataVencimento;

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
        return 0;
    }
}
