/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultacep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 0074945
 */
public class ServicosCEP {

    //ALTERAR AQUI*
    public ModeloCEP consultaPorCEP(String CEP) throws SQLException {
        ModeloCEP retorno = new ModeloCEP();
        Connection c = Conexao.obterConexao();
        String SQL = "SELECT * FROM CONSULTACEP.address_searchs WHERE postal_code = ?";
        PreparedStatement p = c.prepareStatement(SQL);
        p.setString(1, CEP);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            retorno.setCity_id(r.getString("city_id"));
            retorno.setestado(r.getString("ddd"));
            retorno.setEndereco(r.getString("address"));
            retorno.setId(r.getString("id"));
            retorno.setPostal_code(r.getString("postal_code"));
        } else {
            return null;
        }
        c.close();
        return retorno;
    }
    
    
    public String Cidade(String id) throws SQLException {
        String nome = "";
        //ModeloCEP retorno = new ModeloCEP();
        Connection c = Conexao.obterConexao();
        String SQL = "SELECT * FROM CONSULTACEP.cities WHERE id = " + id;
        PreparedStatement p = c.prepareStatement(SQL);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            nome = r.getString("name");
        } else {
            return null;
        }
        c.close();
        
        return nome;
    }
    
    public String EstadoID(String id) throws SQLException {
        String stateid = "";
        //ModeloCEP retorno = new ModeloCEP();
        Connection c = Conexao.obterConexao();
        String SQL = "SELECT * FROM CONSULTACEP.cities WHERE id = " + id;
        PreparedStatement p = c.prepareStatement(SQL);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            stateid = r.getString("state_id");
        } else {
            return null;
        }
        c.close();
        
        return Estado(stateid);
    }

    public String Estado(String stateid) throws SQLException {
        String nome = "";
        //ModeloCEP retorno = new ModeloCEP();
        Connection c = Conexao.obterConexao();
        String SQL = "SELECT * FROM CONSULTACEP.states WHERE id = " + stateid;
        PreparedStatement p = c.prepareStatement(SQL);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            nome = r.getString("name");
        } else {
            return null;
        }
        c.close();
        
        return nome;
    }
    
}
