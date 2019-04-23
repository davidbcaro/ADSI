/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Day;
import java.util.List;

/**
 *
 * @author Brayan
 */
public interface DayDAO <T extends Day> extends InterfaceDAO<T>{
    public List<T> findByNameDay(String nameDay);
    public List<T> findByState(boolean state);
    public List<T> findByLikeNameDay(String nameDay);
    public int updatePk(String llaveNueva, String llaveVieja);
    
}
