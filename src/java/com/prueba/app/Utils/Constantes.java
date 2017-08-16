/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.Utils;

/**
 *
 * @author ASUS
 */
public class Constantes {

    //Usuario
    public static final String InsertTypeDocument = "INSERT INTO tipo_documento (Abreviatura,Descripcion) VALUES (?,?);";
    public static final String UpdateTypeDocument = "UPDATE tipo_documento SET Abreviatura = ?, Descripcion = ? WHERE id = ?";
    public static final String SelectTypeDocuments = "SELECT * FROM tipo_documento";
    public static final String SelectTypeDocument = "SELECT * FROM tipo_documento where Id = ?";
    public static final String DeleteTypeDocument = "DELETE FROM tipo_documento WHERE id = ?";

    //Restaurante
    public static final String InsertFuntionary = "INSERT INTO funcionario (Nombre_Completo, Id_Tipo_Doc, Numero_Documento, Fecha_Inicio_Contrato, Fecha_Fin_Contrato, Cargo) VALUES (?,?,?,?,?,?);";
    public static final String UpdateFuntionary = "UPDATE funcionario SET Nombre_Completo = ?,Id_Tipo_Doc = ?,Numero_Documento = ?,Fecha_Inicio_Contrato = ?,Fecha_Fin_Contrato = ?,Cargo = ? WHERE id = ?";
    public static final String SelectFuntionarys = "SELECT * FROM funcionario";
    public static final String SelectFuntionary = "SELECT * FROM funcionario where id = ?";
    public static final String DeleteFuntionary = "DELETE FROM funcionario WHERE id = ?";

}
