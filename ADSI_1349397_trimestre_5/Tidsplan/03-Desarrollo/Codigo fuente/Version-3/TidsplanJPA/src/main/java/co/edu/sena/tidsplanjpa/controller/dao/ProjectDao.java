/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Project;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface ProjectDao <T extends Project> extends InterfaceDao<T>{
    public List<T> findByCode(String code);
    public List<T> findByLikeCode(String code);
    public List<T> findByName(String name);
    public List<T> findByLikeName(String name);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String newKey, String oldKey);
    
}
