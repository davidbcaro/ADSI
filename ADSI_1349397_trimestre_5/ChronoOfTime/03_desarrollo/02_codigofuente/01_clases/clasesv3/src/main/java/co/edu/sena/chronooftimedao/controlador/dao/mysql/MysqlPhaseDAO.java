/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.PhaseDAO;
import co.edu.sena.chronooftimedao.controlador.dao.util.ResourceManager;
import co.edu.sena.chronooftimedao.modelo.dto.PhaseDTO;
import co.edu.sena.chronooftimedao.modelo.dto.PhasePkDTO;
import co.edu.sena.chronooftimedao.modelo.dto.ProjectDTO;
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
public class MysqlPhaseDAO implements PhaseDAO {
    Connection conexion = null;
    

    @Override
    public int insert(PhaseDTO phase) {
         int cambios = 0;
        String sqlInsert2 = "INSERT INTO " + getTableName()
                + "(name_phase,\n"
                + "project_code,\n"
                + "state\n" + ")\n"
                + "VALUES\n"
                + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert2);
            sentencia.setString(1, phase.getNamePhase());
            sentencia.setInt(2, phase.getProjectCode());
            sentencia.setBoolean(3, phase.isState());
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
    public int update(PhaseDTO phase, PhasePkDTO primaryKey) {
        int cambios = 0;
        String sqlUpdate2 = "UPDATE " + getTableName() + "  SET name_phase = ?, project_code = ?, state = ? WHERE name_phase = ? AND project_code = ?";
        PreparedStatement sentencia = null;
        try {
           conexion = ResourceManager.getConnection();
           sentencia = conexion.prepareStatement(sqlUpdate2);
            sentencia.setString(1, phase.getNamePhase());
            sentencia.setInt(2, phase.getProjectCode());
            sentencia.setBoolean(3, phase.isState());
            sentencia.setString(4, primaryKey.getNamePhase());
            sentencia.setInt(5, primaryKey.getProjectCode());
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
    public int delete(PhasePkDTO primaryKey) {
            int cambios = 0;
        String sqlDelete = "DELETE FROM " + getTableName() + " WHERE name_phase = ? AND project_code = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlDelete);
            sentencia.setString(1, primaryKey.getNamePhase());
            sentencia.setInt(2, primaryKey.getProjectCode());

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
    public PhaseDTO findPk(PhasePkDTO primaryKey) {
        String sql = "SELECT name_phase, project_code, state FROM " + getTableName() + " where name_phase=? and project_code=?";
        PhaseDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey.getNamePhase());
            sentencia.setInt(2, primaryKey.getProjectCode());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new PhaseDTO();
                    resultado.setNamePhase(rs.getString(1));
                    resultado.setProjectCode(rs.getShort(2));
                    resultado.setState(rs.getBoolean(3));
                    

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
        return "phase_p";
    }

    @Override
    public Collection<PhaseDTO> findAll() {
        
        String sql = "SELECT name_phase, project_code, state FROM " + getTableName() + "";
        List<PhaseDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    PhaseDTO pt = new PhaseDTO();
                    pt.setNamePhase(rs.getString(1));
                    pt.setProjectCode(rs.getInt(2));
                    pt.setState(rs.getBoolean(3));
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

   
}
