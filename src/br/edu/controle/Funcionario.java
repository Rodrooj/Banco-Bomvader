package br.edu.controle;

public class Funcionario extends Usuario{
    private String codigoFuncionario;
    private String cargo;
    private String senha;

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    void abrirConta(Conta conta){

    }

    void encerrarConta(Conta conta){

    }

    Conta consultarDadosConta(int numeroConta){
        return null;
    }

    Cliente consultarDadosCliente(int idCliente){
        return null;
    }

    void alterarDadosConta(Conta conta){

    }

    void alterarDadosCliente(Cliente cliente){

    }

    void cadastrarFuncionario(Funcionario funcionario){

    }

    void gerarRelatorioMovimentacao(){

    }
}
