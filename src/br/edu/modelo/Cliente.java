package br.edu.modelo;

import java.time.LocalDate;

public class Cliente extends Usuario{
    public Cliente(int idUsuario, String nome, String cpf, LocalDate dataNascimento, String telefone, String tipoUsuario, String senha) {
        super(idUsuario, nome, cpf, dataNascimento, telefone, tipoUsuario, senha);
    }
}
