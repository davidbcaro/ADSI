/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Environment;
import co.edu.sena.tidsplanjpa.model.jpa.entities.EnvironmentPK;
import java.util.List;

/**
 *
 * @author JulianC
 * @param <T>
 */
public interface EnvironmentDao <T extends Environment> extends InterfaceDao<T> {
    
    public List<T> findByNumberEnvironment(String numberEnvironment);
    public List<T> findByLikeNumberEnvironment(String numberEnvironment);
    public List<T> findByDescription(String description);
    public List<T> findByLikeDescription(String description);
    public List<T> findByStatus(boolean status);
    public List<T> findByNameHeadquartes(String nameHeadquartes);
    public List<T> findByLikeNameHeadquartes(String nameHeadquartes);
    public int updatePrimaryKey(EnvironmentPK newKey, EnvironmentPK oldKey);
    
}
