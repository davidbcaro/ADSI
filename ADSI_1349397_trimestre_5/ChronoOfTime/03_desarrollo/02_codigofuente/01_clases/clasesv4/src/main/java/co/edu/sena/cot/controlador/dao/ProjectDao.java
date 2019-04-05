/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Project;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface ProjectDao<T extends Project> extends InterfaceDao<T>{
    
    public List<T> findByName(String name);
    public List<T> findByCode (int code);
    public List<T> findByState (boolean state);
    public List<T> findByLikeName (String name);
    public List<T> findByLikeCode (String code);
    public int updatePrimaryKey(Integer llaveNueva, Integer llaveVieja);
    
    
}
