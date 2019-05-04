package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.ProjectPhaseDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.ProjectPhaseDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.ProjectPhasePkDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlProjectPhaseDAO implements ProjectPhaseDAO {

    Connection connection;

    @Override
    public int insert(ProjectPhaseDTO projectPhase) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(name_phase,\n" +
                "status,\n" +
                "project_code)\n" +
                "VALUES\n" +
                "(?,?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, projectPhase.getNamePhase());
            sentence.setBoolean(2, projectPhase.isStatus());
            sentence.setString(3, projectPhase.getProjectCode());
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
    public int update(ProjectPhaseDTO projectPhase, ProjectPhasePkDTO primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET name_phase = ?, status = ?, project_code = ? WHERE name_phase=? AND project_code= ?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, projectPhase.getNamePhase());
            sentence.setBoolean(2, projectPhase.isStatus());
            sentence.setString(3, projectPhase.getProjectCode());
            sentence.setString(4, primaryKey.getNamePhase());
            sentence.setString(5, primaryKey.getProjectCode());


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
    public int delete(ProjectPhasePkDTO primarykey) {
        int changes = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE name_phase = ? AND project_code=?" ;
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1,primarykey.getNamePhase());
            sentence.setString(2,primarykey.getProjectCode());
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
    public Collection<ProjectPhaseDTO> findAll() {
        String sql = "SELECT name_Phase, status, project_Code FROM " + getTableName() + "";
        List<ProjectPhaseDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList<>();
                while (rs.next()) {
                    ProjectPhaseDTO p = new ProjectPhaseDTO();
                    p.setNamePhase(rs.getString(1));
                    p.setStatus(rs.getBoolean(2));
                    p.setProjectCode(rs.getString(3));

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
    public ProjectPhaseDTO findPk(ProjectPhasePkDTO primarykey) {
        String sql = "SELECT name_Phase, status, project_Code FROM " + getTableName() + " where name_Phase=? AND project_Code=? ";
        ProjectPhaseDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primarykey.getNamePhase());
            sentence.setString(2, primarykey.getProjectCode());
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new ProjectPhaseDTO();
                    result.setNamePhase(rs.getString(1));
                    result.setStatus(rs.getBoolean(2));
                    result.setProjectCode(rs.getString(3));
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
        return "project_phase";
    }
}
