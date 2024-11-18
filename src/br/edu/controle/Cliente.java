package br.edu.controle;

public class Cliente extends Usuario{
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    double consultarSaldo(){
        return 0;
    }

    void depositar(double valor){

    }

    boolean sacar(double valor){
        return false;
    }

    String consultarExtrato(){
        return null;
    }

    double consultarLimite(){
        return 0;
    }
}
