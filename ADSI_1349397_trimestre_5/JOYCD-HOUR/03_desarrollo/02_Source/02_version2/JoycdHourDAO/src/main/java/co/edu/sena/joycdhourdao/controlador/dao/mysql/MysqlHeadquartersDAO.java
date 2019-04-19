/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.HeadquartersDAO;
import co.edu.sena.joycdhourdao.modelo.dto.HeadquartersDTO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public class MysqlHeadquartersDAO implements HeadquartersDAO {

    Connection conexion = null;

    //sentencia insertar
    @Override
    public int insert(HeadquartersDTO head) {

        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(name_headquarters, "
                + "direction, "
                + "status) "
                + "VALUES "
                + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, head.getNameHeadquarters());
            sentencia.setString(2, head.getDirection());
            sentencia.setBoolean(3, head.isStatus());

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
    public int update(HeadquartersDTO head, String primaryKey) {

        int cambios = 0;
        String sql = "UPDATE " + getTableName() + " headquarters "
                + "SET "
                + "name_headquarters = ?, "
                + "direction = ?, "
                + "status = ? "
                + "WHERE name_headquarters = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, head.getNameHeadquarters());
            sentencia.setString(2, head.getDirection());
            sentencia.setBoolean(3, head.isStatus());
            sentencia.setString(4, primaryKey);
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
        String sql = "DELETE FROM " + getTableName() + " WHERE name_headquarters = ?;";
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
    public Collection<HeadquartersDTO> findAll() {
        String sql = "SELECT name_headquarters, direction, "
                + "    status "
                + "FROM " + getTableName() + ";";

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
                    HeadquartersDTO hd = new HeadquartersDTO();
                    hd.setNameHeadquarters(rs.getString(1));
                    hd.setDirection(rs.getString(2));
                    hd.setStatus(rs.getBoolean(3));
                    resultado.add(hd);
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
    public HeadquartersDTO findPk(String primaryKey) {
        String sql = "SELECT name_headquarters, direction, "
                + "    status "
                + "FROM " + getTableName() + " WHERE name_headquarters = ?";

        HeadquartersDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            rs = sentencia.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    resultado = new HeadquartersDTO();
                    resultado.setNameHeadquarters(rs.getString(1));
                    resultado.setDirection(rs.getString(2));
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
        return "headquarters";
    }

}
