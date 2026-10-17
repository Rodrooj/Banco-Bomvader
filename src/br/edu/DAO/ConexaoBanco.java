package br.edu.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBanco {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private static final String ENV_URL = "BOMVADER_DB_URL";
    private static final String ENV_USER = "BOMVADER_DB_USER";
    private static final String ENV_PASSWORD = "BOMVADER_DB_PASSWORD";

    public void abrirBanco() throws SQLException {
        String url = System.getenv(ENV_URL);
        String user = System.getenv(ENV_USER);
        String password = System.getenv(ENV_PASSWORD);

        if (url == null || url.trim().isEmpty()
                || user == null || user.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            throw new SQLException(
                    "Configure BOMVADER_DB_URL, BOMVADER_DB_USER e BOMVADER_DB_PASSWORD antes de conectar."
            );
        }

        try {
            // Mantido o driver compatível com a biblioteca JDBC atualmente versionada.
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                    "Driver JDBC do MySQL não encontrado. Verifique se a biblioteca está no classpath."
            );
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            // Registra apenas metadados não sensíveis; não imprime a URL nem as credenciais.
            System.err.printf(
                    "Falha na conexão MySQL (SQLState=%s, código=%d).%n",
                    e.getSQLState(),
                    e.getErrorCode()
            );
            throw new SQLException(
                    "Não foi possível conectar ao MySQL. Verifique as variáveis BOMVADER_DB_* e a disponibilidade do servidor."
            );
        }
    }

    public void fecharBanco() throws SQLException {
        SQLException closeFailure = null;

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                closeFailure = e;
            } finally {
                rs = null;
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                if (closeFailure == null) {
                    closeFailure = e;
                }
            } finally {
                pst = null;
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                if (closeFailure == null) {
                    closeFailure = e;
                }
            } finally {
                con = null;
            }
        }

        if (closeFailure != null) {
            throw new SQLException("Não foi possível fechar todos os recursos JDBC.");
        }
    }
}
