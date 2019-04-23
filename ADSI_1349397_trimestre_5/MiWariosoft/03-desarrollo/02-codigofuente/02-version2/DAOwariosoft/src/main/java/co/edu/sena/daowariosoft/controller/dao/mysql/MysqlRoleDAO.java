/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.RoleDAO;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import co.edu.sena.daowariosoft.model.dto.RoleDTO;
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
public class MysqlRoleDAO implements RoleDAO {

    Connection conexion = null;

    @Override
    public int insert(RoleDTO role) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName()
                + "( \n"
                + "id_Role,\n"
                + "description_Role,\n"
                + "state)\n"
                + "VALUES\n"
                + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, role.getIdRole());
            sentencia.setString(2, role.getDescription());
            sentencia.setBoolean(3, role.getState());
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
    public int update(RoleDTO role, String llave) {
        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName()
                + " SET id_Role = ?, description_Role = ?, state = ? WHERE id_Role = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, role.getIdRole());
            sentencia.setString(2, role.getDescription());
            sentencia.setBoolean(3, role.getState());
            sentencia.setString(4, llave);
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
    public int delete(String llave) {
        int cambios = 0;
        String sqlDelete = "DELETE FROM " + getTableName()
                + " WHERE id_Role = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlDelete);
            sentencia.setString(1, llave);
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
    public Collection<RoleDTO> findAll() {
        String sql = "SELECT id_Role, description_Role, state FROM " + getTableName() + "";
        List<RoleDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    RoleDTO rt = new RoleDTO();
                    rt.setIdRole(rs.getString(1));
                    rt.setDescription(rs.getString(2));
                    rt.setState(rs.getBoolean(3));
                    resultado.add(rt);
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
    public RoleDTO findPk(String llave) {
        String sql = "SELECT id_Role, description_Role, state FROM " + getTableName() + " WHERE id_Role = ?";
        RoleDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new RoleDTO();
                    resultado.setIdRole(rs.getString(1));
                    resultado.setDescription(rs.getString(2));
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
        return "Role";
    }

}
