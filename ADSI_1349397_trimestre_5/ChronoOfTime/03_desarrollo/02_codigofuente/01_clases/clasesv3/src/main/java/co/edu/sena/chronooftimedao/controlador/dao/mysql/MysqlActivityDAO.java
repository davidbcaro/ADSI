/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.ActivityDAO;
import co.edu.sena.chronooftimedao.controlador.dao.util.ResourceManager;
import co.edu.sena.chronooftimedao.modelo.dto.ActivityDTO;
import co.edu.sena.chronooftimedao.modelo.dto.ActivityPkDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class MysqlActivityDAO implements ActivityDAO {

    Connection conexion = null;

    @Override
    public int insert(ActivityDTO activitydto) {
        int cambios = 0;
        String sqlInsert2 = "INSERT INTO "+getTableName()
                + "(id_activity,\n"
                + "phase_name_phase,\n"
                + "phase_project_code,\n"
                + "name)\n"
                + "VALUES\n"
                + "(?,?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert2);
            sentencia.setInt(1, activitydto.getId_activity());
            sentencia.setString(2, activitydto.getPhase_name_phase());
            sentencia.setInt(3, activitydto.getPhase_project_code());
            sentencia.setString(4, activitydto.getName());
            
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
    public int update(ActivityDTO activity, ActivityPkDTO primaryKey) {
        int cambios = 0;
        String sqlUpdate2 = "UPDATE " + getTableName() + "  SET id_activity = ?, phase_name_phase = ?, phase_project_code = ? name = ? WHERE id_activity = ? AND phase_name_phase = ? AND phase_project_code = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate2);
            sentencia = conexion.prepareStatement(sqlUpdate2);
            sentencia.setInt(1, activity.getId_activity());
            sentencia.setString(2, activity.getPhase_name_phase());
            sentencia.setInt(3, activity.getPhase_project_code());
            sentencia.setString(4, activity.getName());
            sentencia.setInt(5, primaryKey.getId_activity());
            sentencia.setString(6, primaryKey.getPhase_name_phase());
            sentencia.setInt(7, primaryKey.getPhase_project_code());
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
    public int delete(ActivityPkDTO primaryKey) {
        int cambios = 0;
        String sqlDelete = "DELETE FROM " + getTableName() + " WHERE id_activity = ? AND phase_name_phase = ? AND phase_project_code = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlDelete);
            sentencia.setInt(1, primaryKey.getId_activity());
            sentencia.setString(2, primaryKey.getPhase_name_phase());
            sentencia.setInt(3, primaryKey.getPhase_project_code());

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
    public Collection<ActivityDTO> findAll() {
        String sql = "SELECT id_activity, phase_name_phase, phase_project_code, name FROM " + getTableName() + ";";
        List<ActivityDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    ActivityDTO pt = new ActivityDTO();
                    pt.setId_activity(rs.getInt(1));
                    pt.setPhase_name_phase(rs.getString(2));
                    pt.setPhase_project_code(rs.getInt(3));
                    pt.setName(rs.getString(4));
                    resultado.add(pt);
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
    public ActivityDTO findPk(ActivityPkDTO primaryKey) {
        String sql = "SELECT name_phase, project_code, state FROM " + getTableName() + " where name_phase=? and project_code=?";
        ActivityDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, primaryKey.getId_activity());
            sentencia.setString(2, primaryKey.getPhase_name_phase());
            sentencia.setInt(3, primaryKey.getPhase_project_code());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new ActivityDTO();
                    resultado.setId_activity(rs.getInt(1));
                    resultado.setPhase_name_phase(rs.getString(2));
                    resultado.setPhase_project_code(rs.getInt(3));

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
        return "activity";
    }

}
