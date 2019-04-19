/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;


import co.edu.sena.joycd.modelo.DTO.LevelFormationDTO;
import co.edu.sena.joycdhourdao.controlador.dao.LevelFormationDAO;
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
 * @author 1349397
 */
public class MysqlLevelFormationDAO implements LevelFormationDAO {

    Connection conexion = null;

    @Override
    public int insert(LevelFormationDTO levelFormation) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO "+ getTableName()
                + "(level_formation, "
                + "status) "
                + "VALUES "
                + "(?,?)";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, levelFormation.getLevelFormation());
            sentencia.setBoolean(2, levelFormation.isStatus());
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
    public int update(LevelFormationDTO levelFormation, String key) {
        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName() + " SET level_formation = ?, status = ? WHERE level_formation = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, levelFormation.getLevelFormation());
            sentencia.setBoolean(2, levelFormation.isStatus());
            sentencia.setString(3, key);

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
        String sql = "DELETE FROM " + getTableName() + " WHERE level_formation = ?";
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
    public Collection<LevelFormationDTO> findAll() {
        String sql = "SELECT level_formation,status FROM " + getTableName() + ";";
        List<LevelFormationDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    LevelFormationDTO ct = new LevelFormationDTO();
                    ct.setLevelFormation(rs.getString(1));
                    ct.setStatus(rs.getBoolean(2));
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
    public LevelFormationDTO findPk(String key) {
        String sql = "SELECT level_formation,status FROM " + getTableName() + " where level_formation=?";
        LevelFormationDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new LevelFormationDTO();
                    resultado.setLevelFormation(rs.getString(1));
                    resultado.setStatus(rs.getBoolean(2));
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
        return "level_formation";
    }

}
