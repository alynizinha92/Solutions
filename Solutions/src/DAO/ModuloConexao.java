/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class ModuloConexao {
    public static Connection conector(){
     Connection conexao = null;
     String driver = "com.mysql.jdbc.Driver";
     String url = "jdbc:mysql://localhost:3333/solutions";
     String user = "root";
     String password = "admin";
     //Tratamento de erros
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro! O Banco de dados não está conectado ao sistema!");
            return null;
        }
     
    }
}
