package co.edu.sena.tisdplandao.controller.dao.mysql;


import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.FormationLevelDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;

import co.edu.sena.tisdplandao.model.dto.FormationLevelDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlFormationLevelDAO implements FormationLevelDAO {

    Connection connection;

    @Override
    public int insert(FormationLevelDTO formationlevel) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(level_formation,\n" +
                "status)\n"+
                "VALUES\n" +
                "(?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, formationlevel.getLevelformation());
            sentence.setBoolean(2, formationlevel.isStatus());

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
    public int update(FormationLevelDTO formationlevel, String primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET level_formation = ?, status = ? WHERE level_formation = ? ";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, formationlevel.getLevelformation());
            sentence.setBoolean(2, formationlevel.isStatus());
            sentence.setString(3, primaryKey);

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
    public int delete (String primarykey) {
        int changes = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE level_formation = ?" ;
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1,primarykey);

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
    public Collection<FormationLevelDTO> findAll() {
        String sql = "SELECT level_formation, status FROM " + getTableName() + "";
        List<FormationLevelDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList<>();
                while (rs.next()) {
                    FormationLevelDTO p = new FormationLevelDTO();
                    p.setLevelformation(rs.getString(1));
                    p.setStatus(rs.getBoolean(2));

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
    public FormationLevelDTO findPk(String primarykey) {
        String sql = "SELECT level_formation, status FROM " + getTableName() + " WHERE level_formation = ? ";
        FormationLevelDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primarykey);

            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new FormationLevelDTO();
                    result.setLevelformation(rs.getString(1));
                    result.setStatus(rs.getBoolean(2));
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
        return "formation_level";
    }
}
