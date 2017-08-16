/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.controlador;

import com.prueba.app.Interfaces.IGenericDao;
import com.prueba.app.Interfaces.IGenericVo;
import com.prueba.app.Utils.ProjectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class ControlGeneric<T extends IGenericVo , V extends IGenericDao> {

    V dao;
    Connection cnn;

    public void Insertar(T t) throws SQLException, ProjectException {
        Validar(t, 1);
        dao.Insertar(t);
    }

    public List<T> Consultar(T t) throws SQLException {
        List<T> list = dao.Consultar(t);
        return list;
    }

    public void Actualizar(T t) throws SQLException, ProjectException {
        Validar(t, 3);
        dao.Actualizar(t);
    }

    public void Eliminar(T t) throws SQLException, ProjectException {
        Validar(t, 4);
        dao.Eliminar(t);
    }

    public abstract void Validar(T t, int Accion) throws ProjectException;
}
