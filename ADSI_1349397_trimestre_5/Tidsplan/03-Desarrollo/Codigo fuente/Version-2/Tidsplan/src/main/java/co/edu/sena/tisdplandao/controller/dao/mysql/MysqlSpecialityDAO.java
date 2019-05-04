package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.SpecialityDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.SpecialityDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlSpecialityDAO implements SpecialityDAO {

    Connection connection = null;

    @Override
    public int insert(SpecialityDTO speciality) {
        int changes = 0;
        String sql = "INSERT INTO " + getTableName() +
                "(name_speciality,\n" +
                "photo,\n" +
                "status)\n" +
                "VALUES\n" +
                "(?,?,?);";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, speciality.getNameSpeciality());
            sentence.setBytes(2, speciality.getPhoto());
            sentence.setBoolean(3, speciality.isStatus());
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
    public int update(SpecialityDTO specialityDTO, String primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET name_speciality = ?, photo = ?, status = ? WHERE name_speciality = ?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, specialityDTO.getNameSpeciality());
            sentence.setBytes(2, specialityDTO.getPhoto());
            sentence.setBoolean(3, specialityDTO.isStatus());
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

    private String getTableName() {
        return "speciality";
    }


    @Override
    public int delete(String primaryKey) {

        int changes = 0;
        String sql = "DELETE FROM  " + getTableName() + " WHERE name_speciality =?";
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
    public Collection<SpecialityDTO> findAll() {
        String sql = "SELECT name_speciality, photo, status FROM " + getTableName() + "";
        List<SpecialityDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList();
                while (rs.next()) {
                    SpecialityDTO p = new SpecialityDTO();
                    p.setNameSpeciality(rs.getString(1));
                    p.setPhoto(rs.getBytes(2));
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
    public SpecialityDTO findPk(String primaryKey) {
        String sql = "SELECT name_speciality, photo, status FROM " + getTableName() + " WHERE name_speciality = ? ;";
        SpecialityDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primaryKey);
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new SpecialityDTO();
                    result.setNameSpeciality(rs.getString(1));
                    result.setPhoto(rs.getBytes(2));
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
