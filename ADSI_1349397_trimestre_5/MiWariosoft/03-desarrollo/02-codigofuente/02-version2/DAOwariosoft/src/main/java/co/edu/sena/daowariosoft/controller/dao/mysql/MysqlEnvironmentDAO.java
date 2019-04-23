/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.EnvironmentDAO;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import co.edu.sena.daowariosoft.model.dto.EnvironmentDTO;
import co.edu.sena.daowariosoft.model.dto.EnvironmentPkDTO;
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
public class MysqlEnvironmentDAO implements EnvironmentDAO  {
    
    Connection conexion = null;

    @Override
    public int insert(EnvironmentDTO environment) {
     int cambios=0;
    String sqlInsert = "INSERT INTO " + getTableName() 
                + "(number_Environment,\n"
                + "description,\n"
                + "state,\n"
                + "name_Headquarters)"
                + "VALUES\n"
                + "(?,?,?,?);";
    
    PreparedStatement sentencia = null;
    
    try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, environment.getNumberEnvironment());
            sentencia.setString(2, environment.getDescription());
            sentencia.setBoolean(3, environment.isState());
             sentencia.setString(4, environment.getNameHeadquarters());
             
            cambios= sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    
    
    }

    @Override
    public int update(EnvironmentDTO Environment, EnvironmentPkDTO llavePrimaria) {

        int cambios=0;
     String sqlUpdate = "UPDATE " + getTableName() +
     "SET number_Environment=?,description=?,state=?, name_Headquarters=? WHERE number_Environment=? AND name_Headquarters=?;";
     PreparedStatement sentencia = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, Environment.getNumberEnvironment());
            sentencia.setString(2, Environment.getDescription());
            sentencia.setBoolean(3, Environment.isState());
            sentencia.setString(4, Environment.getNameHeadquarters());
            sentencia.setString(5, llavePrimaria.getNumberEnvironment());
            sentencia.setString(6, llavePrimaria.getNameHeadquarters());
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
    public int delete(EnvironmentPkDTO llavePrimaria) {
    int cambios=0;
     String sql = "DELETE FROM " + getTableName() + " WHERE number_Environment = ? AND Name_Headquarters =?;";
     PreparedStatement sentencia = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria.getNumberEnvironment());
            sentencia.setString(2, llavePrimaria.getNameHeadquarters());
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
    public Collection<EnvironmentDTO> findAll() {
     String sql = "SELECT number_Environment, description, state,name_Headquarters  FROM " + getTableName() + "";
       List<EnvironmentDTO> resultado = null;
       PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    EnvironmentDTO ct = new EnvironmentDTO();
                     ct.setNumberEnvironment(rs.getString(1));
                    ct.setDescription(rs.getString(2));
                    ct.setState(rs.getBoolean(3));
                    ct.setNameHeadquarters(rs.getString(4));
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
    public EnvironmentDTO findPk(EnvironmentPkDTO llavePrimaria) {
      String sql = "SELECT number_Environment, description, state,name_Headquarters  FROM " +  getTableName() + "  WHERE number_Environment=? AND name_Headquarters=?";
     EnvironmentDTO resultado = null;
     PreparedStatement sentencia = null;
     ResultSet rs = null;
      try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria.getNumberEnvironment());
            sentencia.setString(2, llavePrimaria.getNameHeadquarters());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new EnvironmentDTO();
                    resultado.setNumberEnvironment(rs.getString(1));
                    resultado.setDescription(rs.getString(2));
                    resultado.setState(rs.getBoolean(3));
                    resultado.setNameHeadquarters(rs.getString(4));

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
    return "environment ";    
    }
    
}
