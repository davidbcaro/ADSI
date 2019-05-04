/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Role;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface RoleDao <T extends Role> extends InterfaceDao<T>{
      
    public List<T> findByIdRol(String idRol);
    public List<T> findByDescription(String description);
    public List<T> findByLikeIdRol(String idRol);
    public List<T> findByLikeDescription(String description);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String newKey, String oldKey);
}
