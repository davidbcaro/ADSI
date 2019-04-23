/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.CurrentQuarterDAO;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import co.edu.sena.daowariosoft.model.dto.CurrentQuarterDTO;
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
public class MysqlCurrentQuarterDAO implements CurrentQuarterDAO {

    Connection conexion = null;

    @Override
    public int insert(CurrentQuarterDTO currentQuarter) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "( \n"
                + "id_Current_Quarter,\n"
                + "start_Date,\n"
                + "end_Date)\n"
                + "VALUES\n"
                + "(?,?,?)";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, currentQuarter.getIdCurrentQuarter());
            sentencia.setDate(2, currentQuarter.getStartDate());
            sentencia.setDate(3, currentQuarter.getEndDate());
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
    public int update(CurrentQuarterDTO currentQuarter, String llave) {
        int cambios = 0;
        String sqlUpdate = " UPDATE " + getTableName()
                + " SET id_Current_Quarter = ?, start_Date = ?, end_Date = ? WHERE id_Current_Quarter = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, currentQuarter.getIdCurrentQuarter());
            sentencia.setDate(2, currentQuarter.getStartDate());
            sentencia.setDate(3, currentQuarter.getEndDate());
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
        String sql = " DELETE FROM " + getTableName() + "WHERE id_Current_Quarter = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
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
    public Collection<CurrentQuarterDTO> findAll() {
        String sql = "SELECT id_Current_Quarter,start_Date,end_Date FROM " + getTableName() + "";
        List<CurrentQuarterDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    CurrentQuarterDTO cq = new CurrentQuarterDTO();
                    cq.setIdCurrentQuarter(rs.getString(1));
                    cq.setStartDate(rs.getDate(2));
                    cq.setEndDate(rs.getDate(3));
                    resultado.add(cq);
                }
            }
        } catch (SQLException e) {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);

        }
        return resultado;
    }

    @Override
    public CurrentQuarterDTO findPk(String llave) {
        String sql = " SELECT id_Current_Quarter = ? FROM " + getTableName() + "where id_Current_Quarter ";
        CurrentQuarterDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave);
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new CurrentQuarterDTO();
                    resultado.setIdCurrentQuarter(rs.getString(1));
                    resultado.setStartDate(rs.getDate(2));
                    resultado.setEndDate(rs.getDate(3));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
            
        }
        return resultado;
    }
    
    
    private String getTableName() {
        return "current_quarter ";
    }
}
