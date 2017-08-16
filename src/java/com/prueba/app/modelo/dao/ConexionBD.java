/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

/**
 *
 * @author Administrador
 */
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBD {

    public static Connection getConexionBD() throws NamingException, SQLException {
        Connection cnn = null;
        try {
            InitialContext contexto = new InitialContext();
            DataSource origenDeDatos = (DataSource) contexto.lookup("poolv2");
            cnn = origenDeDatos.getConnection();
            cnn.setAutoCommit(false);
        } catch (SQLException | NamingException e) {
        }
        return cnn;
    }

    public static void desconectarBD(Connection cnn) throws SQLException {
        try {
            cnn.commit();
            cnn.close();
        } catch (SQLException e) {
        }
    }

    public static void reservarBD(Connection cnn) throws SQLException {
        try {
            cnn.rollback();
            cnn.close();
        } catch (Exception e) {
        }
    }

}
