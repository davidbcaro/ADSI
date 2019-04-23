/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.HeadquartersDAO;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import co.edu.sena.daowariosoft.model.dto.HeadquartersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author WINDOWS 8
 */
public class MysqlHeadquartersDAO  implements HeadquartersDAO {

    Connection conexion = null;
    
    @Override
    public int insert(HeadquartersDTO headquarters) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName()
                + "(Name_Headquarters,\n"
                + "address,\n"
                + "state)"
                + "VALUES\n"
                + "(?,?,?);";

        PreparedStatement sentencia = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, headquarters.getNameHeadquarters());
            sentencia.setString(2, headquarters.getAddress());
            sentencia.setBoolean(3, headquarters.isState());

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
    public int update(HeadquartersDTO headquarters, String llavePrimaria) {
int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName()
                + "SET Name_Headquarters =?, address = ?, state= ? WHERE Name_Headquarters = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, headquarters.getNameHeadquarters());
            sentencia.setString(2, headquarters.getAddress());
            sentencia.setBoolean(3, headquarters.isState());
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
        String sql = "DELETE FROM " + getTableName() + " WHERE Name_Headquarters = ?";
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
    public Collection<HeadquartersDTO> findAll() {
    String sql = "SELECT Name_Headquarters,address,state FROM " + getTableName() + "";
        List<HeadquartersDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    HeadquartersDTO ct = new HeadquartersDTO();
                    ct.setNameHeadquarters(rs.getString(1));
                    ct.setAddress(rs.getString(2));
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
    public HeadquartersDTO findPk(String llavePrimaria) {
      String sql = "SELECT Name_Headquarters,address,state FROM  " + getTableName() + " where Name_Headquarters=?";
        HeadquartersDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new HeadquartersDTO();
                    resultado.setNameHeadquarters(rs.getString(1));
                    resultado.setAddress(rs.getString(2));
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

    return "headquarters ";
    }
    
}
