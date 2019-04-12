/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.DocumentDAO;
import co.edu.sena.eondao.modelo.dto.DocumentDTO;
import co.edu.sena.eondao.controller.dao.util.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author 1349397
 */
public class MysqlDocumentDAO implements DocumentDAO {

    Connection conexion = null;
    
    private String getTableName() {
        return "document ";
    }

    @Override
    public int insert(DocumentDTO document) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName() + 
        "(id_Document,\n" +
        "Name,\n" +
        "Status)\n" +
        "VALUES\n" +
        "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, document.getIdDocumento());
            sentencia.setString(2, document.getName());
            sentencia.setBoolean(3, document.isStatus());
            cambios = sentencia.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }
    
    @Override
    public DocumentDTO findPk(String primaryKey) {
        String sql = "SELECT " + "id_Document, " + "Name, " + "Status " + " FROM " + getTableName() + "WHERE id_Document =?;";
        DocumentDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new DocumentDTO();
                while (rs.next()) {
                    resultado = new DocumentDTO();
                    resultado.setIdDocumento(rs.getString(1));
                    resultado.setName(rs.getString(2));
                    resultado.setStatus(rs.getBoolean(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;

    }

    @Override
    public int update(DocumentDTO documento, String primaryKey) {
        int cambios = 0;
        String sql = "UPDATE\n " +  getTableName() +
        " SET\n id_Document = ?,\n Name = ?,\n Status = ?\n WHERE id_Document = ?; " ;
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, documento.getIdDocumento());
            sentencia.setString(2, documento.getName());
            sentencia.setBoolean(3, documento.isStatus());
            sentencia.setString(4, primaryKey);
            cambios = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public int delete(String primaryKey) {
        int cambios = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE id_Document =?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            cambios = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }
    

    @Override
    public Collection<DocumentDTO> findAll() {
        String sql = "SELECT " + "id_Document, " + " Name," + " Status "  + " FROM " + getTableName() + " ";
        List<DocumentDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    DocumentDTO dt = new DocumentDTO();
                    dt.setIdDocumento(rs.getString(1));
                    dt.setName(rs.getString(2));
                    dt.setStatus(rs.getBoolean(3));
                    resultado.add(dt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

   

 
   


  

}
