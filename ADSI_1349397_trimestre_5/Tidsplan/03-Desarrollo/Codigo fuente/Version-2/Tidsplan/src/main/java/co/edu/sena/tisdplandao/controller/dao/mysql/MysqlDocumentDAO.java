package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.DocumentDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.DocumentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlDocumentDAO implements DocumentDAO {

    Connection connection = null;

    @Override
    public int insert(DocumentDTO document) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(id_document,\n" +
                "type_document,\n" +
                "status)\n" +
                "VALUES\n" +
                "(?,?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, document.getIdDocument());
            sentence.setString(2, document.getTypeDocument());
            sentence.setBoolean(3, document.isStatus());
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
    public int update(DocumentDTO document, String primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET id_document = ?, type_document = ?, status = ? WHERE id_document = ?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, document.getIdDocument());
            sentence.setString(2, document.getTypeDocument());
            sentence.setBoolean(3, document.isStatus());
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
        String sql = "DELETE FROM  " + getTableName() + " WHERE id_document =?";
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
    public Collection<DocumentDTO> findAll() {
        String sql = "SELECT id_document, type_document, status FROM " + getTableName() + "";
        List<DocumentDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList();
                while (rs.next()) {
                    DocumentDTO p = new DocumentDTO();
                    p.setIdDocument(rs.getString(1));
                    p.setTypeDocument(rs.getString(2));
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
    public DocumentDTO findPk(String primaryKey) {
        String sql = "SELECT id_document, type_document, status FROM " + getTableName() + " WHERE id_document = ? ;";
        DocumentDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primaryKey);
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new DocumentDTO();
                    result.setIdDocument(rs.getString(1));
                    result.setTypeDocument(rs.getString(2));
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
        return "document";
    }

}
