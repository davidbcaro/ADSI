package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.RoleDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.DocumentDTO;
import co.edu.sena.tisdplandao.model.dto.RoleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlRoleDAO implements RoleDAO {

    Connection connection = null;
    @Override
    public int insert(RoleDTO role) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(id_rol,\n" +
                "description,\n" +
                "status)\n" +
                "VALUES\n" +
                "(?,?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, role.getIdRol());
            sentence.setString(2, role.getDescription());
            sentence.setBoolean(3, role.isStatus());
            changes = sentence.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentence);
            ResourceManager.close(connection);
        }
        return changes;
    }

    private String getTableName() {
        return "role";
    }

    @Override
    public int update(RoleDTO role, String primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET id_rol = ?, description = ?, status = ? WHERE id_rol = ?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, role.getIdRol());
            sentence.setString(2, role.getDescription());
            sentence.setBoolean(3, role.isStatus());
            sentence.setString(4, primaryKey);
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
    public int delete(String primaryKey) {
        int changes = 0;
        String sql = "DELETE FROM  " + getTableName() + " WHERE id_rol =?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primaryKey);
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
    public Collection<RoleDTO> findAll() {
        String sql = "SELECT id_rol, description, status FROM " + getTableName() + "";
        List<RoleDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList<>();
                while (rs.next()) {
                    RoleDTO p = new RoleDTO();
                    p.setIdRol(rs.getString(1));
                    p.setDescription(rs.getString(2));
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
    public RoleDTO findPk(String primaryKey) {
        String sql = "SELECT id_rol, description, status FROM " + getTableName() + " WHERE id_rol = ? ;";
        RoleDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primaryKey);
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new RoleDTO();
                    result.setIdRol(rs.getString(1));
                    result.setDescription(rs.getString(2));
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
}
