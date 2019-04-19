/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.StatusGroupNumberDAO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.StatusGroupNumberDTO;
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
public class MysqlStatusGroupNumber implements StatusGroupNumberDAO{
    
    Connection conexion = null;
    
      @Override
    public int insert(StatusGroupNumberDTO statusgroup) {

        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(status_name,\n"
                + "status)\n"
                + "VALUES\n"
                + "(?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, statusgroup.getStatusname());
            sentencia.setBoolean(2, statusgroup.isStatus());

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
    public int update(StatusGroupNumberDTO statusgroup, String primaryKey) {

        int cambios = 0;
        String sql = " UPDATE " + getTableName() + " SET status_name= ?, status = ? WHERE status_name = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, statusgroup.getStatusname());
            sentencia.setBoolean(2, statusgroup.isStatus());
            sentencia.setString(3,primaryKey);
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
    public int delete(String primaryKey) {

        int cambios = 0;
        String sql = " DELETE FROM " + getTableName()
                + " WHERE status_name= ?";
        PreparedStatement sentencia = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
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
    public Collection<StatusGroupNumberDTO> findAll() {
         String sql = " SELECT status_name," +
                "    status "+
                " FROM "+getTableName()+";";

        List<StatusGroupNumberDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    StatusGroupNumberDTO dd = new StatusGroupNumberDTO();
                    dd.setStatusname(rs.getString(1));
                    dd.setStatus(rs.getBoolean(2));
                    resultado.add(dd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

    private String getTableName() {
        return "status_group_number ";
    }

    @Override
    public StatusGroupNumberDTO findPk(String primaryKey) {
        String sql = " SELECT status_name,"
                + "    status "
                + " FROM " + getTableName() + " WHERE status_name = ?";

        StatusGroupNumberDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            rs = sentencia.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    resultado  = new StatusGroupNumberDTO();
                    resultado.setStatusname(rs.getString(1));
                    resultado.setStatus(rs.getBoolean(2));
                    
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
    
    
    
}
