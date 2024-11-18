package br.edu.entidade;

import java.sql.SQLException;

public class TesteCon {
    public static void main(String[] args) throws SQLException {
        DAO cx = new DAO();
        cx.abrirBanco();
    }
}
