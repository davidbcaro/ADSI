/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.WorkingDay;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface WorkingDayDAO<T extends WorkingDay> extends InterfaceDAO<T> {

    public List<T> findByInitialsWorkingDay(String initialsworkingday);

    public List<T> findByName(String name);

    public List<T> findByDescription(String description);

    public List<T> findByState(boolean state);

    public List<T> findByLikeInitialsWorkingDay(String initialsworkingday);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
