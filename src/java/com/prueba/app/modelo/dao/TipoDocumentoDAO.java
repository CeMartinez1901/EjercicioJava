/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.Interfaces.IGenericDao;
import com.prueba.app.modelo.vo.InfoTipoDocumento;
import static com.prueba.app.Utils.Constantes.DeleteFuntionary;
import static com.prueba.app.Utils.Constantes.InsertTypeDocument;
import static com.prueba.app.Utils.Constantes.SelectTypeDocument;
import static com.prueba.app.Utils.Constantes.SelectTypeDocuments;
import static com.prueba.app.Utils.Constantes.UpdateTypeDocument;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class TipoDocumentoDAO implements IGenericDao<InfoTipoDocumento> {

    Connection cnn;

    public TipoDocumentoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void Insertar(InfoTipoDocumento T) throws SQLException {
        PreparedStatement sentencia = cnn.prepareCall(InsertTypeDocument);
        sentencia.setString(1, T.getAbreviatura());
        sentencia.setString(2, T.getDescripcion());
        sentencia.execute();
    }

    @Override
    public List<InfoTipoDocumento> Consultar(InfoTipoDocumento T) throws SQLException {
        ArrayList<InfoTipoDocumento> tipodocumentolist = new ArrayList<>();
        ResultSet result;

        if (T == null) {
            PreparedStatement sentences = cnn.prepareStatement(SelectTypeDocuments);
            result = sentences.executeQuery();

        } else {
            PreparedStatement sentences = cnn.prepareStatement(SelectTypeDocument);
            sentences.setInt(1, T.getId());
            result = sentences.executeQuery();

        }
        while (result.next()) {
            InfoTipoDocumento tipodocumento = new InfoTipoDocumento();
            tipodocumento.setId(result.getInt("Id"));
            tipodocumento.setAbreviatura(result.getString("Abreviatura"));
            tipodocumento.setDescripcion(result.getString("Descripcion"));
            tipodocumentolist.add(tipodocumento);
        }

        return tipodocumentolist;
    }

    @Override
    public void Actualizar(InfoTipoDocumento T) throws SQLException {
        PreparedStatement sentencia = cnn.prepareCall(UpdateTypeDocument);
        sentencia.setString(1, T.getAbreviatura());
        sentencia.setString(2, T.getDescripcion());
        sentencia.setInt(3, T.getId());
        sentencia.execute();
    }

    @Override
    public void Eliminar(InfoTipoDocumento T) throws SQLException {
        PreparedStatement sentencia = cnn.prepareCall(DeleteFuntionary);
        sentencia.setInt(1, T.getId());
        sentencia.execute();
    }
}
