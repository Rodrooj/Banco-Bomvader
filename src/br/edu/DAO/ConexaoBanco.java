package br.edu.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBanco {
    Connection con;// criação do objeto conexao
    PreparedStatement pst;//criação do objeto preparação de ambiente
    ResultSet rs;// criação do objeto que recebe resultados


    public void abrirBanco() throws SQLException {// criando metodo para acessar o banco
        try {
            Class.forName("com.mysql.jdbc.Driver");//classe para utilização do arquivo com configurções do serivdor mysql
            String url = "jdbc:mysql://localhost/banco_bomvader";// drive servidor e banco de dados a serem utilizados e indicação do banco a ser utilizado
            String user ="root";// usuario do banco de dados
            String senha ="";//senha do usuario do banco de dados
            con=(Connection) DriverManager.getConnection(url,user,senha);//metodo que usa os parametros para conectar com o banco
            System.out.println("Conectado ao banco de dados ");
        } catch (ClassNotFoundException ex) {//tratamento de erro de drive
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {//tratamento de erro de SQL
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void fecharBanco() throws Exception{//criando metodo que fechao conexão com o banco
        if (pst!= null) { //limpando os dados de conexão
            pst.close();//fechando o ambiente de conexão
            System.out.println("Execuçao da Query fechada\n");
        }
    }
}
