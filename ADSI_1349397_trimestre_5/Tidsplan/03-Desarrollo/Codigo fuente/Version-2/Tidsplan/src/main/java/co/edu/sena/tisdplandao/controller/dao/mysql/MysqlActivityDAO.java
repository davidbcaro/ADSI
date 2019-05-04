package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ActivityDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.ActivityDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ActivityPkDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlActivityDAO implements ActivityDAO {

    Connection connection;

    @Override
    public int insert(ActivityDTO activity) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(id_activity,\n" +
                "name,\n" +
                "name_phase,\n" +
                "project_code)\n"+
                "VALUES\n" +
                "(?,?,?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, activity.getIdActivity());
            sentence.setString(2, activity.getName());
            sentence.setString(3, activity.getNamePhase());
            sentence.setString(4, activity.getProjectCode());
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
    public int update(ActivityDTO activity, ActivityPkDTO primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET id_activity = ?, name = ?, name_phase = ?, project_code = ? WHERE id_activity = ? AND name_phase =? AND project_code=?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, activity.getIdActivity());
            sentence.setString(2, activity.getName());
            sentence.setString(3, activity.getNamePhase());
            sentence.setString(4, activity.getProjectCode());
            sentence.setString(5, primaryKey.getIdActivity());
            sentence.setString(6, primaryKey.getNamePhase());
            sentence.setString(7, primaryKey.getProjectCode());
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
    public int delete(ActivityPkDTO primarykey) {
        int changes = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE id_activity = ? AND name_phase=? AND project_code=?" ;
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1,primarykey.getIdActivity());
            sentence.setString(2,primarykey.getNamePhase());
            sentence.setString(3,primarykey.getProjectCode());
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
    public Collection<ActivityDTO> findAll() {
        String sql = "SELECT id_activity, name, name_phase ,project_Code FROM " + getTableName() + "";
        List<ActivityDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList<>();
                while (rs.next()) {
                    ActivityDTO p = new ActivityDTO();
                    p.setIdActivity(rs.getString(1));
                    p.setName(rs.getString(2));
                    p.setNamePhase(rs.getString(3));
                    p.setProjectCode(rs.getString(4));

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
    public ActivityDTO findPk(ActivityPkDTO primarykey) {
        String sql = "SELECT id_activity, name, name_phase ,project_Code FROM " + getTableName() + " WHERE id_activity = ? AND name_phase=? AND project_code=?";
        ActivityDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primarykey.getIdActivity());
            sentence.setString(2, primarykey.getNamePhase());
            sentence.setString(3, primarykey.getProjectCode());
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new ActivityDTO();
                    result.setIdActivity(rs.getString(1));
                    result.setName(rs.getString(2));
                    result.setNamePhase(rs.getString(3));
                    result.setProjectCode(rs.getString(4));
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
        return "activity";
    }
}
