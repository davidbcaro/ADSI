/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Speciality;
import java.util.List;

/**
 *
 * @author Liliana Narvaez
 * @param <T>
 */
public interface SpecialityDao <T extends Speciality> extends InterfaceDao<T>{
    
    
    public List<T> findByspecialityName(String specialityName );
    public List<T> findByStatus(boolean status);
    public List<T> findBylikespecialityName(String specialityName);
      
    public int updatePrimaryKey(String specialityNuevo, String specialityViejo);
}
