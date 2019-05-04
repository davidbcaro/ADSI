package co.edu.sena.tisdplandao.controller.dao.mysql;

import co.edu.sena.tisdplandao.controller.dao.interfaceDAO.CustomerDAO;
import co.edu.sena.tisdplandao.controller.dao.util.ResourceManager;
import co.edu.sena.tisdplandao.model.dto.CustomerDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.CustomerPkDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlCustomerDAO implements CustomerDAO {

    Connection connection = null;


    @Override
    public int insert(CustomerDTO customer) {
        int changes = 0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(document,\n" +
                "document_number,\n" +
                "first_name,\n" +
                "second_name,\n" +
                "surname,\n" +
                "second_surname,\n" +
                "photo)\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?,?);";

        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlInsert);
            sentence.setString(1, customer.getDocument());
            sentence.setString(2, customer.getDocumentNumber());
            sentence.setString(3, customer.getFirtsName());
            sentence.setString(4, customer.getSecondName());
            sentence.setString(5, customer.getSurname());
            sentence.setString(6, customer.getSecondSurname());
            sentence.setBytes(7, customer.getPhoto());

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
        return "customer";
    }

    @Override
    public int update(CustomerDTO customer, CustomerPkDTO primaryKey) {
        int changes = 0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET document = ?, document_number = ?, first_name = ?, second_name = ?, surname=?, second_surname= ?, photo = ? WHERE document = ? AND document_number =?";
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sqlUpdate);
            sentence.setString(1, customer.getDocument());
            sentence.setString(2, customer.getDocumentNumber());
            sentence.setString(3, customer.getFirtsName());
            sentence.setString(4, customer.getSecondName());
            sentence.setString(5, customer.getSurname());
            sentence.setString(6, customer.getSecondSurname());
            sentence.setBytes(7, customer.getPhoto());
            sentence.setString(8, primaryKey.getDocument());
            sentence.setString(9, primaryKey.getDocumentNumber());
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
    public int delete(CustomerPkDTO primaryKey) {
        int changes = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE document = ? AND document_number=?" ;
        PreparedStatement sentence = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1,primaryKey.getDocument());
            sentence.setString(2,primaryKey.getDocumentNumber());
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
    public Collection<CustomerDTO> findAll() {
        String sql = "SELECT document, document_number, first_name, second_name, surname, second_surname, photo FROM " + getTableName() + "";
        List<CustomerDTO> result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            rs = sentence.executeQuery();
            if (rs != null) {
                result = new ArrayList<>();
                while (rs.next()) {
                    CustomerDTO p = new CustomerDTO();
                    p.setDocument(rs.getString(1));
                    p.setDocumentNumber(rs.getString(2));
                    p.setFirtsName(rs.getString(3));
                    p.setSecondName(rs.getString(4));
                    p.setSurname(rs.getString(5));
                    p.setSecondSurname(rs.getString(6));
                    p.setPhoto(rs.getBytes(7));

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
    public CustomerDTO findPk(CustomerPkDTO primaryKey) {
        String sql = "SELECT document, document_number, first_name, second_name, surname, second_surname, photo FROM " + getTableName() + " where document=? and document_number=?";
        CustomerDTO result = null;
        PreparedStatement sentence = null;
        ResultSet rs = null;
        try {
            connection = ResourceManager.getConnection();
            sentence = connection.prepareStatement(sql);
            sentence.setString(1, primaryKey.getDocument());
            sentence.setString(2, primaryKey.getDocumentNumber());
            rs = sentence.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    result = new CustomerDTO();
                    result.setDocument(rs.getString(1));
                    result.setDocumentNumber(rs.getString(2));
                    result.setFirtsName(rs.getString(3));
                    result.setSecondName(rs.getString(4));
                    result.setSurname(rs.getString(5));
                    result.setSecondSurname(rs.getString(6));
                    result.setPhoto(rs.getBytes(7));

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
