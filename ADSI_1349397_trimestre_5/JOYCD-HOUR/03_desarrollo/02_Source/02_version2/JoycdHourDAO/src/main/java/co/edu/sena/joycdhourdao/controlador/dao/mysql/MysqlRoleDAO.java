/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;


import co.edu.sena.joycdhourdao.controlador.dao.RoleDAO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.RoleDTO;
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
public class MysqlRoleDAO implements RoleDAO{
    
     Connection conexion = null;
     
      @Override
    public int insert(RoleDTO role) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName() + "(id_role," + "description," + "status)" + "VALUES" + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, role.getIdrol());
            sentencia.setString(2, role.getDescription());
            sentencia.setBoolean(3, role.isStatus());
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
    public int update(RoleDTO role ,String key) {

        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName() + " SET id_role = ?, description = ?, status = ? WHERE id_role = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, role.getIdrol());
            sentencia.setString(2, role.getDescription());
            sentencia.setBoolean(3, role.isStatus());
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
        String sql = "DELETE FROM " + getTableName() + " WHERE id_role= ?";
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
    public Collection<RoleDTO> findAll() {
        String sql = "SELECT id_role, description ,status FROM " + getTableName() + "";
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
                    RoleDTO ct = new RoleDTO();
                    ct.setIdrol(rs.getString(1));
                    ct.setDescription(rs.getString(2));
                    ct.setStatus(rs.getBoolean(3));
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
    public RoleDTO findPk(String key) {
        String sql = "SELECT id_role, description ,status FROM " + getTableName() + " where id_ROLE=?";
        RoleDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new RoleDTO();
                    resultado.setIdrol(rs.getString(1));
                    resultado.setDescription(rs.getString(2));
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

    private String getTableName() {
        return "role";
    }

}


