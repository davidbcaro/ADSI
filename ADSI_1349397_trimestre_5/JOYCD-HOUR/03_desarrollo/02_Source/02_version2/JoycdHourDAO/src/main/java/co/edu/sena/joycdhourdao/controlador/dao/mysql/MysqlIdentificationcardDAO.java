/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;
import co.edu.sena.joycdhourdao.controlador.dao.IdentificationcardDAO;
import co.edu.sena.joycdhourdao.modelo.dto.IdentificationcardDTO;
import co.edu.sena.joycdhourdao.controlador.dao.util.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Usser
 */
public class MysqlIdentificationcardDAO implements IdentificationcardDAO {
    Connection conexion = null;
    
     @Override
    public int insert(IdentificationcardDTO identificationcard ) {
        int cambios = 0;
        String sqlInsert = "INSERT INTO " + getTableName() + "(id_identification_card_number," + "name," + "status)" + "VALUES" + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, identificationcard.getIdindentificationcardnumber());
            sentencia.setString(2, identificationcard.getName());
            sentencia.setBoolean(3,identificationcard.isStatus());
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
    public int update(IdentificationcardDTO identificationcard, String key) {
        int cambios=0;
        String sqlUpdate = "UPDATE " + getTableName() + " SET id_identification_card_number = ?, name = ?, status = ? WHERE id_identification_card_number = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, identificationcard.getIdindentificationcardnumber());
            sentencia.setString(2, identificationcard.getName());
            sentencia.setBoolean(3, identificationcard.isStatus());
            sentencia.setString(4, key);          
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
    public int delete(String key) {
        int cambios = 0;
        String sql = "DELETE FROM " + getTableName() + " WHERE id_identification_card_number= ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key);
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
    public Collection<IdentificationcardDTO> findAll() {
        String sql = "SELECT id_identification_card_number, name ,status FROM " + getTableName() + "";
        List<IdentificationcardDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    IdentificationcardDTO ct = new IdentificationcardDTO();
                    ct.setIdindentificationcardnumber(rs.getString(1));
                    ct.setName(rs.getString(2));
                    ct.setStatus(rs.getBoolean(3));
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
        return resultado;
    }

    @Override
    public IdentificationcardDTO findPk(String key) {
        String sql = "SELECT id_identification_card_number, name ,status FROM " + getTableName() + " where id_identification_card_number=?";
        IdentificationcardDTO  resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, key);

            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new IdentificationcardDTO ();
                    resultado.setIdindentificationcardnumber(rs.getString(1));
                    resultado.setName(rs.getString(2));
                    resultado.setStatus(rs.getBoolean(3));

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
        return "identification_card";
    }
    
}
