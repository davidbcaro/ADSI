/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.ProjectDAO;
import co.edu.sena.chronooftimedao.modelo.dto.ProjectDTO;
import co.edu.sena.chronooftimedao.controlador.dao.util.ResourceManager;
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
public class MysqlProjectDAO implements ProjectDAO {

    Connection conexion = null;

    @Override
    public int insert(ProjectDTO project) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName()
                + "(code,\n"
                + "name,\n"
                + "state\n" + ")\n"
                + "VALUES\n"
                + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setInt(1, project.getCode());
            sentencia.setString(2, project.getName());
            sentencia.setBoolean(3, project.getState());
            cambios = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    private String getTableName() {
        return "project";
    }

    @Override
    public int update(ProjectDTO project, int primariKey) {
        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName() + "  SET code = ?, name = ?, state = ? WHERE code = ?";
        PreparedStatement sentencia = null;
        try {
           conexion = ResourceManager.getConnection();
           sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setInt(1, project.getCode());
            sentencia.setString(2, project.getName());
            sentencia.setBoolean(3, project.getState());
            sentencia.setInt(4, project.getCode());
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
    public int delete(int primaryKey) {
        int cambios = 0;
        String sqlUpdate = "DELETE FROM " + getTableName() + " WHERE code = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setInt(1, primaryKey);

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
    public Collection<ProjectDTO> findAll() {
        int cambios = 0;
        String sql = "SELECT code, name, state FROM " + getTableName() + "";
        List<ProjectDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    ProjectDTO pt = new ProjectDTO();
                    pt.setCode(rs.getInt(1));
                    pt.setName(rs.getString(2));
                    pt.setState(rs.getBoolean(3));
                    resultado.add(pt);
                }
            }

            cambios = sentencia.executeUpdate();
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
    public ProjectDTO findPk(ProjectDTO primaryKey) {

        String sql = "SELECT code, name, state FROM " + getTableName() + " where code=?";
        ProjectDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, primaryKey.getCode());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new ProjectDTO();
                    resultado.setCode(rs.getShort(1));
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

}
