/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.WorkingDayDAO;
import co.edu.sena.chronooftimedao.controlador.dao.util.ResourceManager;
import co.edu.sena.chronooftimedao.modelo.dto.LevelTrainingDTO;
import co.edu.sena.chronooftimedao.modelo.dto.WorkingDayDTO;
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
public class MysqlWorkingDayDAO implements WorkingDayDAO {

    private Connection conexion;

    @Override
    public int insert(WorkingDayDTO workingDayDTO) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName()
                + "(initials,\n"
                + "name,\n"
                + "description)\n"
                + "VALUES\n"
                + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, workingDayDTO.getInitials());
            sentencia.setString(2, workingDayDTO.getName());
            sentencia.setString(3, workingDayDTO.getDescription());

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
    public int update(WorkingDayDTO workingDayDTO, String primaryKey) {
        int cambios = 0;
        String sql = "UPDATE " + getTableName()
                + " SET "
                + "initials = ?, "
                + "name = ?, "
                + "description = ? "
                + "WHERE initials = ?;";

        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, workingDayDTO.getInitials());
            sentencia.setString(2, workingDayDTO.getName());
            sentencia.setString(3, workingDayDTO.getDescription());
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
        String sql = "DELETE FROM " + getTableName() + " WHERE initials =?;";
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
    public Collection<WorkingDayDTO> FindAll() {
        String sql = "SELECT initials,\n"
                + "    name,\n"
                + "    description\n"
                + "FROM " + getTableName() + ";";

        List<WorkingDayDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet ps = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            ps = sentencia.executeQuery();
            if (ps != null) {
                resultado = new ArrayList<>();
                while (ps.next()) {
                    WorkingDayDTO li = new WorkingDayDTO();
                    li.setInitials(ps.getString(1));
                    li.setName(ps.getString(2));
                    li.setDescription(ps.getString(3));
                    resultado.add(li);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(ps);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

    @Override
    public WorkingDayDTO findPk(WorkingDayDTO primaryKey) {
        String sql = "SELECT initials,\n"
                + "    name,\n"
                + "    description\n"
                + "FROM " + getTableName() + " where initials = ? ;";
        WorkingDayDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet ps = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey.getInitials());
            ps = sentencia.executeQuery();
            if (ps != null) {

                while (ps.next()) {
                    resultado = new WorkingDayDTO();
                    resultado.setInitials(ps.getString(1));
                    resultado.setName(ps.getString(2));
                    resultado.setDescription(ps.getString(3));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(ps);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;

    }

    private String getTableName() {
        return "working_Day";
    }

}
