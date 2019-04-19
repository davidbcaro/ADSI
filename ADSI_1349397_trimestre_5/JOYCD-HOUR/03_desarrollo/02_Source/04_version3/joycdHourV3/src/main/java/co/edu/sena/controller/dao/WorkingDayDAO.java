/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Bonding;
import co.edu.sena.model.jpa.entities.WorkingDay;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface WorkingDayDAO<T extends WorkingDay> extends InterfaceDao<T> {

    public List<WorkingDay> findByName(String name);
    public List<WorkingDay> findByDescription(String description);
    public List<WorkingDay> findByPicture(byte picture);
    public List<WorkingDay> findByStatus(boolean status);
    public List<WorkingDay> findByInitials(String intials);
    public List<WorkingDay> findByLikeInitials(String intials);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);

}
