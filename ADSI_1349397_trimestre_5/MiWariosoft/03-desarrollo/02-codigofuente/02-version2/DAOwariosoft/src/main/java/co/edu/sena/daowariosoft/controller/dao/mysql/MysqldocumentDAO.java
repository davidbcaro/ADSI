/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import co.edu.sena.daowariosoft.controller.dao.DocumentDAO;
import co.edu.sena.daowariosoft.model.dto.DocumentDTO;

/**
 *
 * @author 1349397
 */
public class MysqldocumentDAO implements DocumentDAO {

    Connection conexion = null;

    @Override
    public int insert(DocumentDTO document) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName()
                + "(id_Document,\n"
                + "name,\n"
                + "state)"
                + "VALUES\n"
                + "(?,?,?);";

        PreparedStatement sentencia = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, document.getIdDocument());
            sentencia.setString(2, document.getName());
            sentencia.setBoolean(3, document.isState());

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
    public int update(DocumentDTO document, String llavePrimaria) {

        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName()
                + "SET id_Document =?, name = ?, state= ? WHERE id_Document = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, document.getIdDocument());
            sentencia.setString(2, document.getName());
            sentencia.setBoolean(3, document.isState());
            sentencia.setString(4, llavePrimaria);

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
    public int delete(String llavePrimaria) {
        int cambios = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE id_Document = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);

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
        String sql = "SELECT id_Document,name,state FROM " + getTableName() + "";
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
                    DocumentDTO ct = new DocumentDTO();
                    ct.setIdDocument(rs.getString(1));
                    ct.setName(rs.getString(2));
                    ct.setState(rs.getBoolean(3));

                    resultado.add(ct);
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
    public DocumentDTO findPk(String llavePrimaria) {
        String sql = "SELECT id_Document, name, state FROM " + getTableName() + " where id_Document=?";
        DocumentDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new DocumentDTO();
                    resultado.setIdDocument(rs.getString(1));
                    resultado.setName(rs.getString(2));
                    resultado.setState(rs.getBoolean(3));

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

    private String getTableName() {
        return "document ";
    }

}
