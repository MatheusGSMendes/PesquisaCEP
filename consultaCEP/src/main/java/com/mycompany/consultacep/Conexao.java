/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultacep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 0074945
 */
public class Conexao {
    
    public static Connection obterConexao() throws SQLException {
        String URL = "jdbc:postgresql://10.90.54/aula";
        String USER = "aula";
        String PASS = "aula";
        return DriverManager.getConnection(URL, USER, PASS);
       
    }
}
