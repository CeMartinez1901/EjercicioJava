/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import com.google.gson.Gson;
import com.prueba.app.Utils.ProjectException;
import com.prueba.app.controlador.TipoDocumento;
import com.prueba.app.modelo.vo.InfoTipoDocumento;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "TipoDocumentoView", urlPatterns = {"/tipodocumento/insertar", "/tipodocumento/eliminar", "/tipodocumento/actualizar", "/tipodocumento/consultar"})
public class TipoDocumentoView extends GenericServlet {

    @Override
    public void Process(HttpServletRequest request, HttpServletResponse response, PrintWriter out, Connection cnn) throws ProjectException, NamingException, SQLException {

        String data = null;
        String Mensaje = null;
        TipoDocumento controltipodocumento = new TipoDocumento(cnn);
        InfoTipoDocumento infofuncionario;
        data = request.getParameter("data");
        infofuncionario = new Gson().fromJson(data, InfoTipoDocumento.class);
        switch (request.getServletPath()) {
            case "/tipodocumento/insertar":
                if (infofuncionario == null) {
                    throw new ProjectException(500, "No se encontro Objeto");
                }
                controltipodocumento.Insertar(infofuncionario);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            case "/tipodocumento/eliminar":
                if (infofuncionario == null) {
                    throw new ProjectException(500, "No se encontro Objeto");
                }
                controltipodocumento.Eliminar(infofuncionario);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            case "/tipodocumento/actualizar":
                if (infofuncionario == null) {
                    throw new ProjectException(500, "No se encontro Objeto");
                }
                controltipodocumento.Actualizar(infofuncionario);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            case "/tipodocumento/consultar":
                List<InfoTipoDocumento> infotipodocumentolist;
                infotipodocumentolist = controltipodocumento.Consultar(infofuncionario);
                if (infotipodocumentolist == null) {
                    throw new ProjectException(500, "No se encontraron resultados");
                }
                Mensaje = new Gson().toJson(infotipodocumentolist);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            default:
                throw new ProjectException(500, "No soportado");
        }
        out.print(Mensaje);
    }
}
