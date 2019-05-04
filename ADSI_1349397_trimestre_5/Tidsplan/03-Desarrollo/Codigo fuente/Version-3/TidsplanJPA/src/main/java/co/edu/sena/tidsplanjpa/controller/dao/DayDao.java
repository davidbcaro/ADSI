/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Day;
import java.util.List;

/**
 *
 * @author MIHOGAR
 * @param <T>
 */
public interface DayDao <T extends Day> extends  InterfaceDao<T>{
     public List<T> findByNameDay(String nameDay);
     public List<T> findByLikeNameDay(String nameDay);
     public List<T> findByStatus(Boolean status);
     public int updatePrimaryKey(String newKey, String oldKey);
     
   
}
