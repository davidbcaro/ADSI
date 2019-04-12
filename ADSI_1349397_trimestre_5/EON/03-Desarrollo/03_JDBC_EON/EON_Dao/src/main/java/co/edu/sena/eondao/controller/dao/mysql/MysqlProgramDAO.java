/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.ProgramDAO;
import co.edu.sena.eondao.controller.dao.util.ResourceManager;
import co.edu.sena.eondao.modelo.dto.ProgramDTO;
import co.edu.sena.eondao.modelo.dto.ProgramPkDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 */
public class MysqlProgramDAO implements ProgramDAO {

    Connection conexion = null;

    private String getTableName() {
        return "program ";
    }

    @Override
    public int insert(ProgramDTO program) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName() + "(Program_Code, " + "Version, " + "Name, " + "Initials, " + "State, " + "training_Level) " + " VALUES "+ " (?,?,?,?,?,?) ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, program.getCode());
            sentencia.setString(2, program.getVersion());
            sentencia.setString(3, program.getName());
            sentencia.setString(4, program.getInitials());
            sentencia.setBoolean(5, program.isState());
            sentencia.setString(6, program.getTraining_Level());
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
    public int update(ProgramDTO program, String llavePrimaria) {
        int cambios = 0;
        String sql = "UPDATE " + getTableName() + 
                " SET\n Program_Code = ?,\n Version = ?,\n Name = ?,\n Initials = ?,\n State = ?,\n training_Level = ?\n WHERE Program_Code = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, program.getCode());
            sentencia.setString(2, program.getVersion());
            sentencia.setString(3, program.getName());
            sentencia.setString(4, program.getInitials());
            sentencia.setBoolean(5, program.isState());
            sentencia.setString(6, program.getTraining_Level());
            sentencia.setString(7, llavePrimaria);
            cambios = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    public int delete(ProgramPkDTO llave) {
        int cambios = 0;
        String sql = "DELETE FROM " + getTableName()
                + " WHERE Program_Code = ? AND Version = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave.getCode());
            sentencia.setString(2, llave.getVersion());
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
    public Collection<ProgramDTO> findAll() {
        String sql = "SELECT " + " Program_Code, " + "Version, " + " Name, " + " Initials, " + " State, " + " training_Level " + " FROM " + getTableName() + " ";
        List<ProgramDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    ProgramDTO pdto = new ProgramDTO();
                    pdto.setCode(rs.getString(1));
                    pdto.setVersion(rs.getString(2));
                    pdto.setName(rs.getString(3));
                    pdto.setInitials(rs.getString(4));
                    pdto.setState(rs.getBoolean(5));
                    pdto.setTraining_Level(rs.getString(6));
                    resultado.add(pdto);
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
    public ProgramDTO findPk(String llavePk) {
        String sql = "SELECT " + " Program_Code," + " Version," + " Name," + " Initials," + " State," + " training_Level " + " FROM " + getTableName() + " WHERE Program_Code = ?;";
        ProgramDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePk);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ProgramDTO();
                while (rs.next()) {
                    resultado = new ProgramDTO();
                    resultado.setCode(rs.getString(1));
                    resultado.setVersion(rs.getString(2));
                    resultado.setName(rs.getString(3));
                    resultado.setInitials(rs.getString(4));
                    resultado.setState(rs.getBoolean(5));
                    resultado.setTraining_Level(rs.getString(6));
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