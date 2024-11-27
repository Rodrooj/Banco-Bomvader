package br.edu.DAO;

import java.sql.SQLException;

public class TesteCon {
    public static void main(String[] args) throws SQLException {
        ConexaoBanco cb = new ConexaoBanco();
        cb.abrirBanco();
    }
}
