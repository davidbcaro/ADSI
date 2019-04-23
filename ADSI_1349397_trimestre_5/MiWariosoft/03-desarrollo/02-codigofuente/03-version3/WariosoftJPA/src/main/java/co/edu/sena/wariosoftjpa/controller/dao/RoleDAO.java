/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Role;
import java.util.List;

/**
 *
 * @author Brayan
 */
public interface RoleDAO <T extends Role> extends InterfaceDAO<T>{
    public List<T> findByIdRole(String idRole);
    public List<T> findByDescriptionRole(String descriptionRole);
    public List<T> findByState(boolean state);
    public List<T> findByLikeIdRole(String idRole);
    public int updatePk(String llaveNueva, String llaveVieja);
    
}
