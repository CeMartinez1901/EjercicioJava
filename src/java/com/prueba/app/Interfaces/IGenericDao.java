/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.Interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 * @param <T>
 */
public interface IGenericDao< T extends IGenericVo> {

    public void Insertar(T T) throws SQLException;

    public List<T> Consultar(T T) throws SQLException;

    public void Actualizar(T T) throws SQLException;

    public void Eliminar(T T) throws SQLException;

}
