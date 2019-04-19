/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Speciality;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface SpecialityDAO <T extends Speciality> extends InterfaceDao <T>{
    public List<Speciality> findByNameSpeciality(String nameSpeciality);
    public List<Speciality> findByStatus(boolean status);
    public List<Speciality> findByLikeNameSpeciality(String nameSpeciality);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);  
}
