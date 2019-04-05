/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.TrimesterDAO;
import co.edu.sena.chronooftimedao.controlador.dao.util.ResourceManager;
import co.edu.sena.chronooftimedao.modelo.dto.TrimesterDTO;
import co.edu.sena.chronooftimedao.modelo.dto.TrimesterPkDTO;
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
public class MysqlTrimesterDAO implements TrimesterDAO {

    Connection conexion = null;

    @Override
    public int insert(TrimesterDTO trimesterDTO) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(initials, "
                + "number, "
                + "code) "
                + "VALUES "
                + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(2, trimesterDTO.getNumber());
            sentencia.setString(1, trimesterDTO.getInitials());
            sentencia.setString(3, trimesterDTO.getCode());

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
        return "trimester";
    }

    @Override
    public int update(TrimesterDTO trimesterDTO, TrimesterPkDTO primaryKey) {
        int cambios = 0;
        String sqlUpdate2 = "UPDATE " + getTableName() + "  SET number = ?, initials = ?, code = ? WHERE number = ? AND initials = ? AND code = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate2);
            sentencia.setInt(1, trimesterDTO.getNumber());
            sentencia.setString(2, trimesterDTO.getInitials());
            sentencia.setString(3, trimesterDTO.getCode());
            sentencia.setInt(4, primaryKey.getNumber());
            sentencia.setString(5, primaryKey.getInitials());
            sentencia.setString(6, primaryKey.getCode());

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
    public int delete(TrimesterPkDTO primaryKey) {
        int cambios = 0;
        String sqlDelete = "DELETE FROM " + getTableName() + " WHERE name_phase = ? AND project_code = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlDelete);
            sentencia.setInt(1, primaryKey.getNumber());
            sentencia.setString(2, primaryKey.getInitials());
            sentencia.setString(3, primaryKey.getCode());

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
    public TrimesterDTO findPk(TrimesterPkDTO primaryKey) {
        String sql = "SELECT name_phase, project_code, state FROM " + getTableName() + " where name_phase=? and project_code=?";
        TrimesterDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, primaryKey.getNumber());
            sentencia.setString(2, primaryKey.getInitials());
            sentencia.setString(3, primaryKey.getCode());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new TrimesterDTO();
                    resultado.setNumber(rs.getInt(1));
                    resultado.setInitials(rs.getString(2));
                    resultado.setCode(rs.getString(3));

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
    public Collection<TrimesterDTO> FindAll() {
    
        String sql = "SELECT name_phase, project_code, state FROM " + getTableName() + ";";
        List<TrimesterDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    TrimesterDTO pt = new TrimesterDTO();
                    pt.setNumber(rs.getInt(1));
                    pt.setInitials(rs.getString(2));
                    pt.setCode(rs.getString(3));
                    resultado.add(pt);
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
