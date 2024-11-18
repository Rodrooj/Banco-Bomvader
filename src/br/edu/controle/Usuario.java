package br.edu.controle;

import java.time.LocalDate;
import br.edu.controle.Endereco;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return toString();
    }

    public void setEndereco(String endereco) {
        this.endereco = toString();
    }

    boolean login(String senha){
        return false;
    }

    void logout(){

    }

    String consultarDados(){
        return null;
    }
}
