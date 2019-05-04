package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ProjectDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.ProjectDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlProjectDAO implements ProjectDAO {

    Connection connection = null;

    @Override
    public int insert(ProjectDTO project) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(code,\n" +
                "name,\n" +
                "status)\n" +
                "VALUES\n" +
                "(?,?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, project.getCode());
            sentence.setString(2, project.getName());
            sentence.setBoolean(3, project.isStatus());
            changes = sentence.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentence);
            ResourceManager.close(connection);
        }
        return changes;
    }


    @Override
    public int update(ProjectDTO project, String key) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET code = ?, name = ?, status = ? WHERE code = ?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, project.getCode());
            sentence.setString(2, project.getName());
            sentence.setBoolean(3, project.isStatus());
            sentence.setString(4, key);

            changes = sentence.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentence);
            ResourceManager.close(connection);
        }
        return changes;
    }


    @Override
    public int delete(String key) {
        int changes = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE code = ?" ;
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, key);
            changes = sentence.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentence);
            ResourceManager.close(connection);
        }
        return changes;
    }

    @Override
    public Collection<ProjectDTO> findAll() {
        String sql = "SELECT code, name, status FROM " + getTableName() + "";
        List<ProjectDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList<>();
                while (rs.next()) {
                    ProjectDTO p = new ProjectDTO();
                    p.setCode(rs.getString(1));
                    p.setName(rs.getString(2));
                    p.setStatus(rs.getBoolean(3));
                    result.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentence);
            ResourceManager.close(connection);
        }
        return result;
    }

    @Override
    public ProjectDTO findPk(String key) {
        String sql = "SELECT code, name, status FROM " + getTableName() + " where code=? ";
        ProjectDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, key);
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new ProjectDTO();
                    result.setCode(rs.getString(1));
                    result.setName(rs.getString(2));
                    result.setStatus(rs.getBoolean(3));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentence);
            ResourceManager.close(connection);
        }
        return result;
    }

    private String getTableName() {
        return "project";
    }


}
