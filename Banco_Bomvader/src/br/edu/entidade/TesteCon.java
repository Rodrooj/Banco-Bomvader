/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.entidade;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo.bpereira
 */
public class TesteCon {
    public static void main(String[] argvs) throws SQLException {
        DAO cx = new DAO();
        cx.abrirBanco();
    }
}
