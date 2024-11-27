package br.edu.modelo;

import java.time.LocalDate;

public class Funcionario extends Usuario{
    private String codigoFuncionario;
    private String cargo;

    public Funcionario(int idUsuario, String nome, String cpf, LocalDate dataNascimento, String telefone, String tipoUsuario, String senha, String codigoFuncionario, String cargo) {
        super(idUsuario, nome, cpf, dataNascimento, telefone, tipoUsuario, senha);
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
    }

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
}
