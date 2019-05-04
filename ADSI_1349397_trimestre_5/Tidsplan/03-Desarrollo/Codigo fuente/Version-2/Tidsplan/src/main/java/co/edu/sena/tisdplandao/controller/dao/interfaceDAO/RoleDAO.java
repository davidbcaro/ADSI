package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.RoleDTO;

import java.util.Collection;

public interface RoleDAO {
    public int insert(RoleDTO role);
    public int update(RoleDTO role, String primaryKey);
    public int delete(String primaryKey);
    public Collection<RoleDTO> findAll();
    public RoleDTO findPk(String primaryKey);

}
