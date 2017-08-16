/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.Interfaces.IGenericDao;
import static com.prueba.app.Utils.Constantes.InsertFuntionary;
import static com.prueba.app.Utils.Constantes.SelectFuntionary;
import static com.prueba.app.Utils.Constantes.SelectFuntionarys;
import static com.prueba.app.Utils.Constantes.UpdateFuntionary;
import com.prueba.app.modelo.vo.InfoFuncionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class FuncionarioDAO implements IGenericDao<InfoFuncionario> {

    Connection cnn;

    public FuncionarioDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void Insertar(InfoFuncionario T) throws SQLException {
        PreparedStatement sentencia = cnn.prepareCall(InsertFuntionary);
        sentencia.setString(1, T.getNombreCompleto());
        sentencia.setInt(2, T.getIdTipoDoc());
        sentencia.setString(3, T.getNumeroDocumento());
        sentencia.setDate(4, (Date) T.getFechaInicioContrato());
        sentencia.setDate(5, (Date) T.getFechaFinContrato());
        sentencia.setString(6, T.getCargo());
        sentencia.execute();
    }

    @Override
    public List<InfoFuncionario> Consultar(InfoFuncionario T) throws SQLException {

        ArrayList<InfoFuncionario> infofuncionariolist = new ArrayList<>();
        ResultSet result;

        if (T == null) {
            PreparedStatement sentences = cnn.prepareStatement(SelectFuntionarys);
            result = sentences.executeQuery();

        } else {
            PreparedStatement sentences = cnn.prepareStatement(SelectFuntionary);
            sentences.setInt(1, T.getId());
            result = sentences.executeQuery();

        }
        while (result.next()) {
            InfoFuncionario infofuncionario = new InfoFuncionario();
            infofuncionario.setId(result.getInt("Id"));
            infofuncionario.setNombreCompleto(result.getString("Nombre_Completo"));
            infofuncionario.setIdTipoDoc(result.getInt("Id_Tipo_Doc"));
            infofuncionario.setNumeroDocumento(result.getString("Numero_Documento"));
            infofuncionario.setFechaInicioContrato(result.getDate("Fecha_Inicio_Contrato"));
            infofuncionario.setFechaFinContrato(result.getDate("Fecha_Fin_Contrato"));
            infofuncionario.setCargo(result.getString("Cargo"));
            infofuncionariolist.add(infofuncionario);
        }

        return infofuncionariolist;
    }

    @Override
    public void Actualizar(InfoFuncionario T) throws SQLException {

        PreparedStatement sentencia = cnn.prepareCall(UpdateFuntionary);
        sentencia.setString(1, T.getNombreCompleto());
        sentencia.setInt(2, T.getIdTipoDoc());
        sentencia.setString(3, T.getNumeroDocumento());
        sentencia.setDate(4, (Date) T.getFechaInicioContrato());
        sentencia.setDate(5, (Date) T.getFechaFinContrato());
        sentencia.setString(6, T.getCargo());
        sentencia.setInt(7, T.getId());
        sentencia.execute();
    }

    @Override
    public void Eliminar(InfoFuncionario T) throws SQLException {
        
        PreparedStatement sentencia = cnn.prepareCall(UpdateFuntionary);
        sentencia.setInt(1, T.getId());
        sentencia.execute();
    }
}
