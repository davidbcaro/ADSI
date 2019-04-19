/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.EnvironmentDAO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.EnvironmentDTO;
import co.edu.sena.joycdhourdao.modelo.dto.EnvironmentPKDTO;
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
public class MysqlEnvironmentDAO implements EnvironmentDAO {

    Connection conexion = null;

    @Override
    public int insert(EnvironmentDTO environment) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO" + getTableName()
                + " (number_environment, "
                + "description, "
                + "status, "
                + "headquarters_name) "
                + "VALUES "
                + "(?,?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setInt(1, environment.getNumberEnvironment());
            sentencia.setString(2, environment.getDescription());
            sentencia.setBoolean(3, environment.isStatus());
            sentencia.setString(4, environment.getHeadquartersName());
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
    public int update(EnvironmentDTO environment, EnvironmentPKDTO llave) {
        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName()
                + " SET "
                + "number_environment = ?, "
                + "description = ?, "
                + "status = ?, "
                + "headquarters_name = ? "
                + "WHERE number_environment = ? AND headquarters_name = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setInt(1, environment.getNumberEnvironment());
            sentencia.setString(2, environment.getDescription());
            sentencia.setBoolean(3, environment.isStatus());
            sentencia.setString(4, environment.getHeadquartersName());
            sentencia.setInt(5, llave.getNumberEnvironment());
            sentencia.setString(6, llave.getHeadquartersName());
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
    public int delete(EnvironmentPKDTO llave) {

        int cambios = 0;
        String sql = "DELETE FROM " + getTableName() + "WHERE number_environment = ? AND headquarters_name = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, llave.getNumberEnvironment());
            sentencia.setString(2, llave.getHeadquartersName());

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
    public Collection<EnvironmentDTO> findAll() {
                String sql = "SELECT number_environment, "
                + "    description, "
                + "    status, "
                + "    headquarters_name "
                + "FROM " + getTableName()+" ;";
        List<EnvironmentDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                   EnvironmentDTO env  = new EnvironmentDTO();
                    env.setNumberEnvironment(rs.getInt(1));
                    env.setDescription(rs.getString(2));
                    env.setStatus(rs.getBoolean(3));
                    env.setHeadquartersName(rs.getString(4));
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
    public EnvironmentDTO findPk(EnvironmentPKDTO llave) {

        String sql = "SELECT number_environment, "
                + "    description, "
                + "    status, "
                + "    headquarters_name "
                + "FROM " + getTableName()+" WHERE number_environment = ? AND headquarters_name = ?;";
        EnvironmentDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, llave.getNumberEnvironment());
            sentencia.setString(2, llave.getHeadquartersName());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new EnvironmentDTO();
                    resultado.setNumberEnvironment(rs.getInt(1));
                    resultado.setDescription(rs.getString(2));
                    resultado.setStatus(rs.getBoolean(3));
                    resultado.setHeadquartersName(rs.getString(4));

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
        return " environment ";
    }

}
