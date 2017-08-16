/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prueba.app.Utils.ProjectException;
import com.prueba.app.controlador.Funcionario;
import com.prueba.app.modelo.vo.InfoFuncionario;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncionarioView", urlPatterns = {"/funcionario/insertar", "/funcionario/eliminar", "/funcionario/actualizar", "/funcionario/consultar"})
public class FuncionarioView extends GenericServlet {

    @Override
    public void Process(HttpServletRequest request, HttpServletResponse response, PrintWriter out, Connection cnn) throws ProjectException, NamingException, SQLException {
        String data = null;
        String Mensaje = null;
        Funcionario controlfuncionario = new Funcionario(cnn);
        InfoFuncionario infofuncionario;
        data = request.getParameter("data");
        Gson gson = new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy").create();
        infofuncionario = gson.fromJson(data, InfoFuncionario.class);

        switch (request.getServletPath()) {
            case "/funcionario/insertar":
                 if (infofuncionario == null) {
                    throw new ProjectException(500, "No se encontro Objeto");
                }
                controlfuncionario.Insertar(infofuncionario);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            case "/funcionario/eliminar":
                if (infofuncionario == null) {
                    throw new ProjectException(500, "No se encontro Objeto");
                }
                controlfuncionario.Eliminar(infofuncionario);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            case "/funcionario/actualizar":
                if (infofuncionario == null) {
                    throw new ProjectException(500, "No se encontro Objeto");
                }
                controlfuncionario.Actualizar(infofuncionario);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;
            case "/funcionario/consultar":
                List<InfoFuncionario> infofuncionariolist;
                infofuncionariolist = controlfuncionario.Consultar(infofuncionario);
                if (infofuncionariolist == null) {
                    throw new ProjectException(500, "No se encontraron resultados");
                }
                Mensaje = new Gson().toJson(infofuncionariolist);
                super.mensaje = "operacion exitosa";
                super.code = 200;
                break;

            default:
                throw new ProjectException(500, "No soportado");
        }
        out.print(Mensaje);
    }
}
