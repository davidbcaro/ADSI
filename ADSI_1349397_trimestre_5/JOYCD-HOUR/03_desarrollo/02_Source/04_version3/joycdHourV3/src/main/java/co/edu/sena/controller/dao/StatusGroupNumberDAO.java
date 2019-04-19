/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.StatusGroupNumber;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface StatusGroupNumberDAO <T extends StatusGroupNumber> extends InterfaceDao<T>{
    public List<StatusGroupNumber> findByStatusName(String statusName);
    public List<StatusGroupNumber> findByStatus (boolean status);
    public List <StatusGroupNumber> findByLikeStatusName (String statusName);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
    
}
