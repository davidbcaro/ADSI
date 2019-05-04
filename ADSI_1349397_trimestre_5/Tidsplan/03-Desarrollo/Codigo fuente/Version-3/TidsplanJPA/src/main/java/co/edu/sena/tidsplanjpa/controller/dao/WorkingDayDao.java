/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.WorkingDay;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface WorkingDayDao <T extends WorkingDay> extends InterfaceDao<T>{
    public List<T> findByLikeInitials(String initials);
    public List<T> findByInitials(String initials);
    public List<T> findByLikeName(String name);
    public List<T> findByName(String name);
    public List<T> findByLikeDescription(String description);
    public List<T> findByDescription(String description);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String newKey, String oldKey);
    
}
