/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Day;
import java.util.List;

/**
 *
 * @author Telegrafia01
 */
public interface DayDao <D extends Day> extends InterfaceDao<D>{
    public List<D>findByNameDay(String name);
    public List<D>findByLikeNameDay(String name);
    public List<D>findByState(Boolean state);
    public List<D>findByLikeState(Boolean state);
    public int UpdatePk(String llaveNueva ,String llaveVieja);
}
