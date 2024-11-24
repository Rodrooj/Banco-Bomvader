package br.edu.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void abrirBanco() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/banco_bomvader";
            String user ="root";
            String senha ="";
            con=(Connection) DriverManager.getConnection(url,user,senha);
            System.out.println("Conectado ao banco de dados ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void fecharBanco() throws Exception{
        if (pst!= null) {
            pst.close();
            System.out.println("Execuçao da Query fechada\n");
        }
    }
}
