/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Linking;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LinkingDAO <T extends Linking> extends InterfaceDAO<T>{
    public List<T> findByTypeLinking(String typeLinking);
    public List<T> findByHours(int hours);
    public List<T> findByState(boolean state);
    public List<T> findByLikeTypeLinking(String typeLinking);
    public int updatePk(String llaveNueva, String llaveVieja);
    
}
