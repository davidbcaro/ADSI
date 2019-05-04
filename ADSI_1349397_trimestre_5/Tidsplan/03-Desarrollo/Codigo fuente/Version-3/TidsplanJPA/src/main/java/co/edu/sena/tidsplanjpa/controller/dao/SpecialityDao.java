/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Speciality;
import java.util.List;


/**
 *
 * @author MIHOGAR
 */
public interface SpecialityDao  <T extends Speciality> extends InterfaceDao<T>{
    public List<T> findByNameSpeciality(String nameSpeciality);
    public List<T> findByLikeNameSpeciality(String nameSpeciality);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String newKey, String oldKey);
}
