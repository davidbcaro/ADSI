/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.PhaseProjectDAO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import co.edu.sena.joycdhourdao.modelo.dto.PhaseProjectDTO;
import co.edu.sena.joycdhourdao.modelo.dto.PhaseProjectPkDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author SENA
 */
public class MysqlPhaseProjectDAO implements PhaseProjectDAO {
   Connection conexion = null;
    @Override
    public int insert(PhaseProjectDTO phase) {
       int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName() + "(name_phase," + "status_phase,"+"project_code)" + "VALUES" + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, phase.getNamephase());
            sentencia.setString (2, phase.getStatusphase());
            sentencia.setString(3, phase.getProjectcode());
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
    public int update(PhaseProjectDTO phase, PhaseProjectPkDTO keyPrimaria) {
        int cambios = 0;
        String sqlUpdate = "UPDATE " + getTableName() + " SET name_phase = ?, status_phase = ?, project_code = ? WHERE name_phase=? AND project_code=?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, phase.getNamephase());
            sentencia.setString (2, phase.getStatusphase());
            sentencia.setString(3, phase.getProjectcode());
            sentencia.setString(4, keyPrimaria.getNamephase());
            sentencia.setString(5, keyPrimaria.getProjectcode());
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
    public int delete(PhaseProjectPkDTO key) {
        int cambios = 0;
        String sqlUpdate = "DELETE FROM " + getTableName() + " WHERE name_phase = ? AND project_code=?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, key.getNamephase());
            sentencia.setString(2, key.getProjectcode());
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
    public Collection<PhaseProjectDTO> findAll() {
    String sql = "SELECT name_phase, status_phase ,project_code FROM " + getTableName() + "";
        List<PhaseProjectDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {

                resultado = new ArrayList<>();
                while (rs.next()) {
                    PhaseProjectDTO ct = new PhaseProjectDTO();
                    ct.setNamephase(rs.getString(1));
                    ct.setProjectcode(rs.getString(2));
                    ct.setStatusphase(rs.getString(3));
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
    public PhaseProjectDTO findPk(PhaseProjectPkDTO key) {
         
        String sql = "SELECT name_phase, status_phase,project_code FROM " + getTableName() +  " WHERE name_phase = ? AND project_code=?";
        PhaseProjectDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key.getNamephase());
            sentencia.setString(2, key.getProjectcode());

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new PhaseProjectDTO();
                    resultado.setNamephase(rs.getString(1));
                    resultado.setStatusphase(rs.getString(2));
                    resultado.setProjectcode(rs.getString(3));

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
     return "phase_project";   
    }
    
}
