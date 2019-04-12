/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Project;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <p>
 * 
 */
public interface ProjectDao <p extends Project> extends InterfaceDao<p>{
    public List<p> findByCode(String Code);
    public List<p> findByName(String Name);
    public List<p> findByState(boolean State);
    public List<p> findByLikeCode(String Code);
    public List<p> findByLikeName(String Name);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
