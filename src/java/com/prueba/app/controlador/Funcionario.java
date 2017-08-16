/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.controlador;

import com.prueba.app.Utils.ProjectException;
import com.prueba.app.modelo.dao.FuncionarioDAO;
import java.sql.Connection;
import com.prueba.app.modelo.vo.InfoFuncionario;

/**
 *
 * @author Administrador
 */
public class Funcionario extends ControlGeneric<InfoFuncionario, FuncionarioDAO> {

    public Funcionario(Connection cnn) {
        super.cnn = cnn;
        super.dao = new FuncionarioDAO(cnn);
    }

    @Override
    public void Validar(InfoFuncionario infofuncionario, int Accion) throws ProjectException {
        //Agregar Validaciones para el DTO
    }
}
