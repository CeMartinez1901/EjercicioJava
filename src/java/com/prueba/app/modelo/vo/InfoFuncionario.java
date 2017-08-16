/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.vo;

import com.prueba.app.Interfaces.IGenericVo;
import java.util.Date;


/**
 *
 * @author Administrador
 */
public class InfoFuncionario implements IGenericVo{
    private Integer Id;
    private String NombreCompleto;
    private Integer IdTipoDoc;
    private String NumeroDocumento;
    private Date FechaInicioContrato;
    private Date FechaFinContrato;
    private String Cargo;

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the NombreCompleto
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    /**
     * @param NombreCompleto the NombreCompleto to set
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    /**
     * @return the IdTipoDoc
     */
    public Integer getIdTipoDoc() {
        return IdTipoDoc;
    }

    /**
     * @param IdTipoDoc the IdTipoDoc to set
     */
    public void setIdTipoDoc(Integer IdTipoDoc) {
        this.IdTipoDoc = IdTipoDoc;
    }

    /**
     * @return the NumeroDocumento
     */
    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    /**
     * @param NumeroDocumento the NumeroDocumento to set
     */
    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    /**
     * @return the FechaInicioContrato
     */
    public Date getFechaInicioContrato() {
        return FechaInicioContrato;
    }

    /**
     * @param FechaInicioContrato the FechaInicioContrato to set
     */
    public void setFechaInicioContrato(Date FechaInicioContrato) {
        this.FechaInicioContrato = FechaInicioContrato;
    }

    /**
     * @return the FechaFinContrato
     */
    public Date getFechaFinContrato() {
        return FechaFinContrato;
    }

    /**
     * @param FechaFinContrato the FechaFinContrato to set
     */
    public void setFechaFinContrato(Date FechaFinContrato) {
        this.FechaFinContrato = FechaFinContrato;
    }

    /**
     * @return the Cargo
     */
    public String getCargo() {
        return Cargo;
    }

    /**
     * @param Cargo the Cargo to set
     */
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    
}
