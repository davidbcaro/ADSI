/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.StateGroup;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface StateGroupDao <T extends StateGroup> extends InterfaceDao<T>{
    public List<T> findByLikeNameState(String nameState);
    public List<T> findByNameState(String nameState);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String newKey, String oldKey);
    
}

