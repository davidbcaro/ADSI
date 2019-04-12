/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Availability;
import co.edu.sena.eon_jpa.model.jpa.entities.AvailabilityPK;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface AvailabilityDao <T extends Availability> extends InterfaceDao<T> {
    
    public List<T> findByStartTime(Date startTime);
    public List<T> findByEndTime(Date endTime);
    public List<T> findByIdDocument(String idDocument);
    public List<T> findByDocumentNumber(String documentNumber);
    public List<T> findByAcronymsWorkingDay(String acronymsWorkingDay);
    public List<T> findByNameDay(String nameDay);
    public List<T> findByLikeStartTime(Date startTime);
    public List<T> findByLikeEndTime(Date endTime);
    public List<T> findByLikeIdDocument(String idDocument);
    public List<T> findBylikeDocumentNumber(String documentNumber);
    public List<T> findByLikeAcronymsWorkingDay(String acronymsWorkingDay);
    public List<T> findByLikeNameDay(String nameDay);
    public int UpdatePrimaryKey(AvailabilityPK newKey , AvailabilityPK oldKey);
    
    
}
