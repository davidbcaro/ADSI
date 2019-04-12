/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.mysql;

import co.edu.sena.eondao.controller.dao.RoleDAO;
import co.edu.sena.eondao.controller.dao.util.ResourceManager;
import co.edu.sena.eondao.modelo.dto.RoleDTO;

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

public class MysqlRoleDAO implements RoleDAO {

    Connection conexion = null;
    
    private String getTableName(){
        return "role";
    }
    

    @Override
    public int insert(RoleDTO role) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName() + 
        "(id_Role,\n" +
        "Description,\n" +
        "Status)\n" +
        "VALUES\n" +
        "(?,?,?);";
        PreparedStatement sentencia = null;
        
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, role.getId_Role());
            sentencia.setString(2, role.getDescription());
            sentencia.setBoolean(3, role.isStatus());
            cambios = sentencia.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }
    
    @Override
        public int update(RoleDTO role, String arreglo){
        int cambios=0;
        String sql = "UPDATE\n " +  getTableName() +
        " SET\n id_Role = ?,\n Description = ?,\n Status = ?\n WHERE id_Role = ?; " ;
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, role.getId_Role());
            sentencia.setString(2, role.getDescription());
            sentencia.setBoolean(3, role.isStatus());
            sentencia.setString(4, arreglo);
            cambios = sentencia.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }
    
    @Override
    public int delete(String role){
        int cambios=0;
        String sql = "DELETE FROM " + getTableName() + 
        " WHERE id_Role =?" ; 
        PreparedStatement sentencia = null;
        try { 
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, role);
            cambios = sentencia.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }
    
    @Override
    public Collection<RoleDTO> findAll(){
        String sql = "SELECT " + "id_Role, " + " Description," + " Status "  + " FROM " + getTableName() + " ";
        List<RoleDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql); 
            rs = sentencia.executeQuery();
            if(rs != null){
              resultado = new ArrayList<>();
                while(rs.next()){                    
                    RoleDTO rd = new RoleDTO();
                    rd.setId_Role(rs.getString(1));
                    rd.setDescription(rs.getString(2));
                    rd.setStatus(rs.getBoolean(3));
                    resultado.add(rd);
                }
            }        
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }
    
    @Override
    public RoleDTO findPk(String llave1){
        String sql = "SELECT " + " id_Role, " + " Description, " + " Status " + " FROM " + getTableName() + " WHERE id_Role =? ";
        RoleDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave1);
            rs = sentencia.executeQuery();
            if(rs != null){
              resultado = new RoleDTO();
                while(rs.next()){                    
                    resultado = new RoleDTO();
                    resultado.setId_Role(rs.getString(1));
                    resultado.setDescription(rs.getString(2));
                    resultado.setStatus(rs.getBoolean(3));
                }
            }        
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }
}
