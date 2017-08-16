/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.controlador;

import com.prueba.app.Utils.ProjectException;
import com.prueba.app.modelo.dao.FuncionarioDAO;
import com.prueba.app.modelo.dao.TipoDocumentoDAO;
import java.net.ConnectException;
import com.prueba.app.modelo.vo.InfoTipoDocumento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class TipoDocumento extends ControlGeneric<InfoTipoDocumento, TipoDocumentoDAO> {

    public TipoDocumento(Connection cnn) {
        super.cnn = cnn;
        super.dao = new TipoDocumentoDAO(cnn);
    }

    @Override
    public void Validar(InfoTipoDocumento infotipodocumento, int Accion) throws ProjectException {
        boolean validarid = (Accion != 1);

        if (infotipodocumento.getAbreviatura().length() > 0) {
            throw new ProjectException(500, "Abreviatura invalida");
        }

        if (infotipodocumento.getDescripcion().length() > 0) {
            throw new ProjectException(500, "Descripciòn invalida");
        }

        if (infotipodocumento.getId() > 0 && validarid) {
            throw new ProjectException(500, "Objeto invalido");
        }
    }
}
