package co.edu.sena.eondao.controller.dao.mysql;



import co.edu.sena.eondao.controller.dao.PhaseDAO;
import co.edu.sena.eondao.controller.dao.util.ResourceManager;
import co.edu.sena.eondao.modelo.dto.PhaseDTO;
import co.edu.sena.eondao.modelo.dto.PhasePKDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlPhaseDAO implements PhaseDAO {

    Connection conexion = null;

    @Override
    public int insert(PhaseDTO phase) {
        int cambios = 0;
        String sql = "INSERT INTO " + getTableName() + " (name_phase ," + "State, " + " Code ) " + "VALUES " + "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, phase.getNamePhase());
            sentencia.setBoolean(2, phase.isState());
            sentencia.setString(3, phase.getProjectCode());
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
    public int update(PhaseDTO phase, PhasePKDTO llavePrimaria) {
        int cambios = 0;
        String sql = "UPDATE " + getTableName()
                + " SET name_phase = ?, State = ?, Code = ?  WHERE name_phase = ? AND Code = ? ";
        PreparedStatement sentencia = null;

        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, phase.getNamePhase());
            sentencia.setBoolean(2, phase.isState());
            sentencia.setString(3, phase.getProjectCode());
            sentencia.setString(4, llavePrimaria.getPhaseName());
            sentencia.setString(5, llavePrimaria.getProjectCode());
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
    public int delete(PhasePKDTO llave) {
        int cambios = 0;
        String sql = "DELETE FROM " + getTableName()
                + " WHERE name_phase = ? AND Code = ? ";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave.getPhaseName());
            sentencia.setString(2, llave.getProjectCode());
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
    public Collection<PhaseDTO> findAll() {
        String sql = "SELECT name_phase, State, Code FROM " + getTableName() + "";
        List<PhaseDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    PhaseDTO rd = new PhaseDTO();
                    rd.setNamePhase(rs.getString(1));
                    rd.setState(rs.getBoolean(2));
                    rd.setProjectCode(rs.getString(3));
                    resultado.add(rd);
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
    public PhaseDTO findPk(PhasePKDTO llave) {
        String sql = "SELECT name_phase, State, Code FROM " + getTableName() + " where name_phase = ? and Code = ?";
        PhaseDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave.getPhaseName());
            sentencia.setString(2, llave.getProjectCode());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new PhaseDTO();
                    resultado.setNamePhase(rs.getString(1));
                    resultado.setState(rs.getBoolean(2));
                    resultado.setProjectCode(rs.getString(3));

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
        return "phase ";
    }

}
