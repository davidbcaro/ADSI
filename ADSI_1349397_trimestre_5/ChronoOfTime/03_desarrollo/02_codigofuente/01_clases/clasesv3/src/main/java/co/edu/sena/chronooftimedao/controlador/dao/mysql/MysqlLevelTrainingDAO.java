/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.LevelTrainingDAO;
import co.edu.sena.chronooftimedao.controlador.dao.util.ResourceManager;
import co.edu.sena.chronooftimedao.modelo.dto.LevelTrainingDTO;
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
public class MysqlLevelTrainingDAO implements LevelTrainingDAO {

    private Connection conexion;

    @Override
    public int insert(LevelTrainingDTO levelTrainingDTO) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(code,\n"
                + "state)\n"
                + "VALUES\n"
                + "(?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, levelTrainingDTO.getCode());
            sentencia.setBoolean(2, levelTrainingDTO.isState());

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
    public int update(LevelTrainingDTO levelTrainingDTO, String primaryKey) {
        int cambios = 0;
        String sql = "UPDATE " + getTableName()
                + " SET "
                + "code = ?, "
                + "state = ? "
                + "WHERE code = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, levelTrainingDTO.getCode());
            sentencia.setBoolean(2, levelTrainingDTO.isState());
            sentencia.setString(3, primaryKey);
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
        String sql = "DELETE FROM " + getTableName()+ " WHERE code=?;";
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
    public Collection<LevelTrainingDTO> FindAll() {
        String sql = "SELECT code,\n"
                + " state\n"
                + "FROM " + getTableName() + ";";

        List<LevelTrainingDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    LevelTrainingDTO lt = new LevelTrainingDTO();
                    lt.setCode(rs.getString(1));
                    lt.setState(rs.getBoolean(2));
                    resultado.add(lt);
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
    public LevelTrainingDTO findPk(LevelTrainingDTO primaryKey) {
        String sql = "SELECT Code,State FROM " + getTableName() + " where Code=?";
        LevelTrainingDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey.getCode());

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new LevelTrainingDTO();
                    resultado.setCode(rs.getString(1));
                    resultado.setState(rs.getBoolean(2));

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
        return "level_trainig";
    }
}
