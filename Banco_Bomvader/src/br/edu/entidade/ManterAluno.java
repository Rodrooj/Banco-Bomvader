/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.entidade;
import java.sql.PreparedStatement;
import br.edu.controle.Aluno;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo.bpereira
 */
public class ManterAluno extends DAO {
    public void inserir (Aluno a) throws SQLException{
        try{
            abrirBanco();
            String query = "INSERT INTO alunos (codigo,nome,email)" + "values(null,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, a.getNome());
            pst.setString(2, a.getEmail());
            pst.execute();
            fecharBanco();
        } catch (Exception e){
            System.out.println("Erro "+ e.getMessage());
        }
    }
}
