/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.SpecialityDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.String;
import co.edu.sena.joycdhourdao.controlador.dao.SpecialityDAO;

/**
 *
 * @author 1349397
 */
public class MysqlSpecialityDAO implements SpecialityDAO {

    Connection conexion = null;

    @Override
    public int insert(SpecialityDTO speciality) {

        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(name_speciality, "
                + "status) "
                + "VALUES "
                + "(?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, speciality.getNameSpeciality());
            sentencia.setBoolean(2, speciality.isStatus());

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
    public int update(SpecialityDTO speciality, String primaryKey) {

        int cambios = 0;
        String sql = "UPDATE " + getTableName() + " SET name_speciality = ?, status = ? WHERE name_speciality = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, speciality.getNameSpeciality());
            sentencia.setBoolean(2,speciality.isStatus());
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
                + " WHERE name_speciality = ?";
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
    public Collection<SpecialityDTO> findAll() {
         String sql = "SELECT name_speciality," +
                "    status "+
                "FROM "+getTableName()+";";

        List<SpecialityDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    SpecialityDTO xd = new SpecialityDTO();
                    xd.setNameSpeciality(rs.getString(1));
                    xd.setStatus(rs.getBoolean(2));
                    resultado.add(xd);
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
        return "speciality";
    }

    @Override
    public SpecialityDTO findPk(String primaryKey) {
        String sql = "SELECT name_speciality,"
                + "    status "
                + "FROM " + getTableName() + " WHERE name_speciality = ?";

        SpecialityDTO resul = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            rs = sentencia.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    resul  = new SpecialityDTO();
                    resul.setNameSpeciality(rs.getString(1));
                    resul.setStatus(rs.getBoolean(2));
 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resul;

    }
}
