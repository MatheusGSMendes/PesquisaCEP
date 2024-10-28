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

    public ModeloCEP consultaPorCEP(String CEP) throws SQLException {
        ModeloCEP retorno = new ModeloCEP();
        Connection c = Conexao.obterConexao();
        String SQL = "SELECT * FROM CONSULTACEP.address_searchs WHERE postal_code = ?";
        PreparedStatement p = c.prepareStatement(SQL);
        p.setString(1, CEP);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            retorno.setCity_id(r.getString("city_id"));
            retorno.setDdd(r.getString("ddd"));
            retorno.setEndereco(r.getString("address"));
            retorno.setId(r.getString("id"));
            retorno.setPostal_code(r.getString("postal_code"));
        } else {
            return null;
        }
        c.close();
        return retorno;
    }

}
