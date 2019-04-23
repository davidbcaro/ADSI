/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;


import co.edu.sena.daowariosoft.controller.dao.ProjectDAO;
import co.edu.sena.daowariosoft.controller.dao.util.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import co.edu.sena.daowariosoft.model.dto.ProjectDTO;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author SENA
 */
public class MysqlProjectDAO implements ProjectDAO {

    Connection conexion = null;

    @Override
    public int insert(ProjectDTO project) {
 int cambios = 0;
        String sqlInsert = "INSERT INTO "+ getTableName()
               + "(project_Code,\n"
                + "name_project,\n"
                + "state)"
                + "VALUES\n"
                + "(?,?,?);";

        PreparedStatement sentencia = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, project.getCode());
            sentencia.setString(2, project.getName());
            sentencia.setBoolean(3, project.isState());

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
    public int update(ProjectDTO project, String llavePrimaria) {
    int cambios = 0;
        String sqlUpdate = " UPDATE " + getTableName()
                + "SET " + "project_Code= ?,  name_project = ?, state  = ? WHERE project_Code = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, project.getCode());
            sentencia.setString(2, project.getName());
            sentencia.setBoolean(3, project.isState());
            
            sentencia.setString(4,llavePrimaria);
            
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
    public int delete(String llavePrimaria) {
int cambios = 0;
    String sql= "DELETE FROM " + getTableName()+" WHERE project_Code = ?";
    PreparedStatement sentencia = null;
    try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);
           
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
    public Collection<ProjectDTO> findAll() {

        String sql = "SELECT project_Code, name_project ,state FROM " + getTableName()+"";
    List<ProjectDTO> resultado = null;
    PreparedStatement sentencia = null;
    ResultSet rs = null;
     try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    ProjectDTO ct = new ProjectDTO();
                    ct.setCode(rs.getString(1));
                    ct.setName(rs.getString(2));
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
        return resultado;    }

    @Override
    public ProjectDTO findPk(String llavePrimaria) {
    String sql = "SELECT project_Code, name_project , state FROM " + getTableName()+ " where project_Code= ? ;";
    ProjectDTO resultado = null;
    PreparedStatement sentencia = null;
        ResultSet rs = null;
         try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new ProjectDTO();
                    resultado.setCode(rs.getString(1));
                    resultado.setName(rs.getString(2));
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
       return "project ";
   
    }
    
    
}
