/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;
import co.edu.sena.controller.dao.InterfaceDao;
import co.edu.sena.controller.dao.InterfaceDao;
import co.edu.sena.model.jpa.entities.Role;
import java.util.List;

/**
 *
 * @author Usser
 */
public interface RoleDAO <T extends Role> extends InterfaceDao <T> {
    public List<Role> findByIdRole (String idRole);
    public List<Role> findByDescription (String description);
    public List <Role> findByStatus (boolean status);
    public List<Role> findByLikeIdRole (String idRolet);
    public List<Role> findByLikeDescription (String description);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
