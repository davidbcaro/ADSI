/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;
import co.edu.sena.joycdhourdao.controlador.dao.ProjectDAO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.ProjectDTO;
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
        String sqlInsert = "INSERT INTO " + getTableName() + "(code_project," + "name_project," + "status_project)" + "VALUES" + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, project.getCodeproject());
            sentencia.setString(2, project.getNameproject());
            sentencia.setBoolean(3, project.isStatusproject());
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
    public int update(ProjectDTO project, String key) {
        int cambios=0;
        String sqlUpdate = "UPDATE " + getTableName() + " SET code_project = ?, name_project = ?, status_project = ? WHERE code_project = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, project.getCodeproject());
            sentencia.setString(2, project.getNameproject());
            sentencia.setBoolean(3, project.isStatusproject());
            sentencia.setString(4, key);
           
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
    public int delete(String key) {
        int cambios = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE code_project= ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key);
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
        String sql = "SELECT code_project, name_project ,status_project FROM " + getTableName() + "";
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
                    ProjectDTO ct = new ProjectDTO();
                    ct.setCodeproject(rs.getString(1));
                    ct.setNameproject(rs.getString(2));
                    ct.setStatusproject(rs.getBoolean(3));
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
    public ProjectDTO findPk(String key) {
        String sql = "SELECT code_project, name_project ,status_project FROM " + getTableName() + " where code_project=?";
        ProjectDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new ProjectDTO();
                    resultado.setCodeproject(rs.getString(1));
                    resultado.setNameproject(rs.getString(2));
                    resultado.setStatusproject(rs.getBoolean(3));

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
        return "project";
    }

}
