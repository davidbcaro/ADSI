/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.DayDAO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.DayDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.String;

/**
 *
 * @author 1349397
 */
public class MysqlDayDAO implements DayDAO {

    Connection conexion = null;

    @Override
    public int insert(DayDTO day) {

        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(name_day,\n"
                + "status)\n"
                + "VALUES\n"
                + "(?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, day.getNameDay());
            sentencia.setBoolean(2, day.isStatus());

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
    public int update(DayDTO day, String primaryKey) {

        int cambios = 0;
        String sql = "UPDATE " + getTableName() + "SET name_day = ?, status = ? WHERE name_day = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, day.getNameDay());
            sentencia.setBoolean(2,day.isStatus());
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
        String sql = "DELETE FROM " + getTableName()
                + "WHERE name_day= ?";
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
    public Collection<DayDTO> findAll() {
         String sql = "SELECT name_day," +
                "    status "+
                "FROM "+getTableName()+";";

        List<DayDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    DayDTO dd = new DayDTO();
                    dd.setNameDay(rs.getString(1));
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
        return "day ";
    }

    @Override
    public DayDTO findPk(String primaryKey) {
        String sql = "SELECT name_day,"
                + "    status "
                + "FROM " + getTableName() + " WHERE name_day = ?";

        DayDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            rs = sentencia.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    resultado  = new DayDTO();
                    resultado.setNameDay(rs.getString(1));
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
