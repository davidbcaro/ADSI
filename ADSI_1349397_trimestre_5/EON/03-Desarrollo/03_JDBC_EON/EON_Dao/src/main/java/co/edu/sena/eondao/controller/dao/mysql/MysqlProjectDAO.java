package co.edu.sena.eondao.controller.dao.mysql;



import co.edu.sena.eondao.controller.dao.ProjectDAO;
import co.edu.sena.eondao.controller.dao.util.ResourceManager;
import co.edu.sena.eondao.modelo.dto.ProjectDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlProjectDAO implements ProjectDAO {

    Connection conexion = null;

    @Override
    public int insert(ProjectDTO project) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName() + 
        "(Code,\n" +
        "Name,\n" +
        "State)\n" +
        "VALUES\n" +
        "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, project.getCode());
            sentencia.setString(2, project.getName());
            sentencia.setBoolean(3, project.isState());
            cambios = sentencia.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public int update(ProjectDTO projectDTO, String llavePrimaria) {
        int cambios = 0;
        String sql = "UPDATE\n " +  getTableName() +
        " SET\n Code = ?,\n Name = ?,\n State = ?\n WHERE Code = ?; " ;
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, projectDTO.getCode());
            sentencia.setString(2, projectDTO.getName());
            sentencia.setBoolean(3, projectDTO.isState());
            sentencia.setString(4, llavePrimaria);
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
        String sql = "DELETE FROM " + getTableName() + " WHERE Code = ? ;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);
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
    public Collection<ProjectDTO> findAll() {
        String sql = "SELECT " + "Code, " +  "Name," +  "State "  + " FROM " + getTableName() + "";
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
                    ProjectDTO dt = new ProjectDTO();
                    dt.setCode(rs.getString(1));
                    dt.setName(rs.getString(2));
                    dt.setState(rs.getBoolean(3));
                    resultado.add(dt);
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
    public ProjectDTO findPK(String llavePrimaria) {
        String sql = "SELECT " + "Code, " +  "Name, " +  "State "  + " FROM " + getTableName() + "WHERE Code = ? ";
        ProjectDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llavePrimaria);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ProjectDTO();
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
