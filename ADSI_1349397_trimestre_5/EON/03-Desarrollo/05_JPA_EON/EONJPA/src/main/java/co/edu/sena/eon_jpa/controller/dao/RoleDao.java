package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Role;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1349397
 * @param <r>
 */
public interface RoleDao <r extends Role> extends InterfaceDao<r>{
    public List<r> findBylikeIdRole(String idRole);
    public List<r> findBylikeDescription(String description);
    public List<r> findByStatus(boolean status);
    public List<r> findByIdRole(String idRole );
    public List<r> findByDescription(String description);
    public int updatePrimaryKey(String idRoleNuevo, String idRoleViejo);
}

