package br.edu.modelo;

import java.time.LocalDate;

public class Cliente extends Usuario{
    private Conta conta;

    public Cliente(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String senha, Conta conta) {
        super(id, nome, cpf, dataNascimento, telefone, endereco, senha);
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return this.conta;
    }

    double consultarSaldo(Conta conta){
        return conta.getSaldo();
    }

    void depositar(Conta conta, double valor){
        conta.depositar(valor);
    }

    public boolean sacar(Conta conta, double valor) {
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso. Novo saldo: " + conta.getSaldo());
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    String consultarExtrato(){
        return null;
    }

    double consultarLimite(ContaCorrente contaCorrente){
        return contaCorrente.consultarLimite();
    }
}
