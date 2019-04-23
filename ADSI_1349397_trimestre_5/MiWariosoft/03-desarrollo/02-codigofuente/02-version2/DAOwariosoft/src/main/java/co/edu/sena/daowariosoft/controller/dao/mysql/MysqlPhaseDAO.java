/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import co.edu.sena.daowariosoft.controller.dao.PhaseDAO;
import co.edu.sena.daowariosoft.model.dto.PhaseDTO;
import co.edu.sena.daowariosoft.model.dto.PhasePkDTO;


/**
 *
 * @author SENA
 */
public class MysqlPhaseDAO implements PhaseDAO {
    
       Connection conexion = null;


    @Override
    public int insert(PhaseDTO phase) {
    int cambios=0;
    String sqlInsert = "INSERT INTO " + getTableName() 
                + "(name_Phase,\n"
                + "project_Code,\n"
                + "state)"
                + "VALUES\n"
                + "(?,?,?);";
    
    PreparedStatement sentencia = null;
    
    try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, phase.getNamePhase());
            sentencia.setString(2, phase.getProjectCode());
            sentencia.setBoolean(3, phase.isState());
            
            cambios= sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    
    
    }

    @Override
    public int update(PhaseDTO phase, PhasePkDTO llavePrimaria) {
    int cambios=0;
     String sqlUpdate = "UPDATE " + getTableName() +
     "SET name_Phase=?,project_Code=?,state=? WHERE name_Phase=? AND project_Code=?;";
     PreparedStatement sentencia = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, phase.getNamePhase());
            sentencia.setString(2, phase.getProjectCode());
            sentencia.setBoolean(3, phase.isState());
            sentencia.setString(4, llavePrimaria.getNamePhase());
            sentencia.setString(5, llavePrimaria.getProjectCode());
            cambios=sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public int delete(PhasePkDTO llavePrimaria) {
     int cambios=0;
     String sql = "DELETE FROM " + getTableName() + " WHERE name_Phase = ? AND project_Code = ? ";
     PreparedStatement sentencia = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria.getNamePhase());
            sentencia.setString(2, llavePrimaria.getProjectCode());
            cambios=sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public Collection<PhaseDTO> findAll() {
       String sql = "SELECT name_Phase, project_Code, state FROM " + getTableName() + "";
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
                    PhaseDTO ct = new PhaseDTO();
                    ct.setNamePhase(rs.getString(1));
                    ct.setProjectCode(rs.getString(2));
                    ct.setState(rs.getBoolean(3));
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
    public PhaseDTO findPk(PhasePkDTO llavePrimaria) {
     String sql = "SELECT name_Phase, project_Code , state FROM " +  getTableName() + "  WHERE name_Phase=? AND project_Code=?";
     PhaseDTO resultado = null;
     PreparedStatement sentencia = null;
     ResultSet rs = null;
      try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria.getNamePhase());
            sentencia.setString(2, llavePrimaria.getProjectCode());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new PhaseDTO();
                    resultado.setNamePhase(rs.getString(1));
                    resultado.setProjectCode(rs.getString(2));
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
    return "phase ";
    }

   
    
}
