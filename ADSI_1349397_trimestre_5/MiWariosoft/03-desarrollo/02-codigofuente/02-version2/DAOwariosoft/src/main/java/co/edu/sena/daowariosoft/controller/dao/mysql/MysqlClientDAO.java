/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.ClientDAO;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import co.edu.sena.daowariosoft.model.dto.ClientDTO;
import co.edu.sena.daowariosoft.model.dto.ClientPkDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class MysqlClientDAO implements ClientDAO {

    Connection conexion = null;

    @Override
    public int insert(ClientDTO client) {
        int cambios = 0;
         String sqlInsert = "INSERT INTO " + getTableName()
                + "(document_Number,\n"
                + "id_Document,\n"
                 + "first_Name,\n"
                 + "second_Name,\n"
                 + "first_Lastname,\n"
                 + "second_Lastname)"
                + "VALUES\n"
                + "(?,?,?,?,?,?);";

        PreparedStatement sentencia = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, client.getDocumentNumber());
            sentencia.setString(2, client.getIdDocument());
            sentencia.setString(3, client.getFirstName());
            sentencia.setString(4, client.getSecondName());
            sentencia.setString(5, client.getFirstLastname());
            sentencia.setString(6, client.getSecondLastname());

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
    public int update(ClientDTO client, ClientPkDTO llavePrimaria) {
        int cambios=0;
     String sqlUpdate = 

             " UPDATE " + getTableName() 
             + "SET document_Number=?, id_Document=?, first_Name=?, second_Name=?, first_Lastname=?, second_Lastname=? WHERE document_Number=? AND id_Document=?;";
     PreparedStatement sentencia = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia.setString(1, client.getDocumentNumber());
            sentencia.setString(2, client.getIdDocument());
            sentencia.setString(3, client.getFirstName());
            sentencia.setString(4, client.getSecondName());
            sentencia.setString(5, client.getFirstLastname());
            sentencia.setString(6, client.getSecondLastname());
            sentencia.setString(7, llavePrimaria.getDocumentNumber());
            sentencia.setString(8, llavePrimaria.getIdDocument());
            cambios=sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public int delete(ClientDTO llavePrimaria) {
        int cambios=0;
     String sql = " DELETE FROM " + getTableName()
            + " WHERE document_Number=? AND id_Document=?;";
     PreparedStatement sentencia = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria.getDocumentNumber());
            sentencia.setString(2, llavePrimaria.getIdDocument());
            cambios=sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public Collection<ClientDTO> findAll() {
        String sql = "SELECT document_Number, first_Name, second_Name, first_Lastname, second_Lastname, id_Document FROM " + getTableName() + "";
       List<ClientDTO> resultado = null;
       PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    ClientDTO ct = new ClientDTO();
                    ct.setDocumentNumber(rs.getString(1));
                    ct.setFirstName(rs.getString(2));
                    ct.setSecondName(rs.getString(3));
                    ct.setFirstLastname(rs.getString(4));
                    ct.setSecondLastname(rs.getString(5));
                    ct.setIdDocument(rs.getString(6));
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
    public ClientDTO findPk(ClientPkDTO llavePrimaria) {
        String sql = "SELECT document_Number, first_Name, second_Name, first_Lastname, second_Lastname, id_Document FROM " +  getTableName() + " WHERE document_Number=? AND id_Document=?;";
     ClientDTO resultado = null;
     PreparedStatement sentencia = null;
     ResultSet rs = null;
      try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria.getDocumentNumber());
            sentencia.setString(2, llavePrimaria.getIdDocument());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new ClientDTO();
                    resultado.setDocumentNumber(rs.getString(1));
                    resultado.setFirstName(rs.getString(2));
                    resultado.setSecondName(rs.getString(3));
                    resultado.setFirstLastname(rs.getString(4));
                    resultado.setSecondLastname(rs.getString(5));
                    resultado.setIdDocument(rs.getString(6));
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
        return "client ";
    }
}
