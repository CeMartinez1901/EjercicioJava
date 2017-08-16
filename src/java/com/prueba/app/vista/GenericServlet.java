/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import com.google.gson.Gson;
import com.prueba.app.Utils.ProjectException;
import com.prueba.app.modelo.dao.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrador
 */
public abstract class GenericServlet extends HttpServlet {
    
    public int code = 0;
    public String mensaje = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType(MediaType.APPLICATION_JSON);
        Connection cnn = ConexionBD.getConexionBD();
        PrintWriter out = response.getWriter();
        
        try {
            Process(request, response, out, cnn);
        } catch (NamingException | SQLException ex) {
            mensaje = ex.getMessage();
            Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.reservarBD(cnn);
        } catch (ProjectException ex) {
            code = ex.getCode();
            mensaje = ex.getMessage();
            Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.reservarBD(cnn);
        }
        ConexionBD.desconectarBD(cnn);
        Gson gson = new Gson();
        mensaje = gson.toJson(mensaje);
        out.print(mensaje);
    }
    
    public abstract void Process(HttpServletRequest request, HttpServletResponse response, PrintWriter out, Connection cnn) throws ProjectException, NamingException, SQLException;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenericServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
