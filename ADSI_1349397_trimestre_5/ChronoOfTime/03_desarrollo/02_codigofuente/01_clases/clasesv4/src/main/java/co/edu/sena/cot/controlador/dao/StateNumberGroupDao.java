/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.StateNumberGroup;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface StateNumberGroupDao<T extends StateNumberGroup> extends InterfaceDao<T> {
    
    
    public List<T> findByState (boolean state);
    public int updatePrimaryKey(boolean llaveNueva, boolean llaveVieja);
    
}
