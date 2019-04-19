/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;
import co.edu.sena.model.jpa.entities.Day;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface DayDAO <T extends Day> extends InterfaceDao<T>{
    
    public List<Day> findByNameDay(String nameDay);
    public List<Day> findByStatus(boolean status);
    public List<Day> findByLikeNameDay(String nameDay);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
