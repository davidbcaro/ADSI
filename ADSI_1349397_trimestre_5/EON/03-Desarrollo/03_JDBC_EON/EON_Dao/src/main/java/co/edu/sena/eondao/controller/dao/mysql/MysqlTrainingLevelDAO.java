/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.util.ResourceManager;
import co.edu.sena.eondao.modelo.dto.TrainingLevelDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import co.edu.sena.eondao.controller.dao.TrainingLevelDAO;

/**
 *
 * @author LUISBERNARDO
 */
public class MysqlTrainingLevelDAO implements TrainingLevelDAO {

    private Connection conexion;

    private String getTableName() {
        return "training_Level ";
    }

    @Override
    public int insert(TrainingLevelDTO training) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName() + " (training_Level, State)" + " VALUES " + " (?,?) ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, training.getTraining_Level());
            sentencia.setBoolean(2, training.isState());
            cambios = sentencia.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public int update(TrainingLevelDTO training, String primaryKey) {
        int cambios = 0;
        String sql = "UPDATE " + getTableName()
                + "SET\n training_Level = ?,\n State = ?\n WHERE training_Level = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, training.getTraining_Level());
            sentencia.setBoolean(2, training.isState());
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
        String sql = "DELETE FROM " + getTableName()
                + "WHERE training_Level = ?";
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
    public Collection<TrainingLevelDTO> findAll() {
        String sql = "SELECT " + " training_Level," + "State" + " FROM " + getTableName() + " ";
        List<TrainingLevelDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    TrainingLevelDTO training = new TrainingLevelDTO();
                    training.setTraining_Level(rs.getString(1));
                    training.setState(rs.getBoolean(2));
                    resultado.add(training);
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
    public TrainingLevelDTO findPk(String primaryKey) {
        String sql = "SELECT " + " training_Level," + "State" + " FROM " + getTableName() + "WHERE training_Level = ? ";
        TrainingLevelDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new TrainingLevelDTO();
                while (rs.next()) {
                   resultado = new TrainingLevelDTO();
                   resultado.setTraining_Level(rs.getString(1));
                   resultado.setState(rs.getBoolean(2));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }
}
