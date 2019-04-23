/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface StateNumberGroupDAO <T extends StateNumberGroup> extends InterfaceDAO<T>{
    public List<T> findByNameState(String nameState);
    public List<T> findByState(boolean state);
    public List<T> findByLikeNameState(String nameState);
    public int updatePk(String llaveNueva, String llaveVieja);
}
