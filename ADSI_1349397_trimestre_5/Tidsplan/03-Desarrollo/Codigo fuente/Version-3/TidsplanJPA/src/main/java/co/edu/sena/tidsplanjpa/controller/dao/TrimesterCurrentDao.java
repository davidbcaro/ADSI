/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterCurrent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface TrimesterCurrentDao <T extends TrimesterCurrent> extends InterfaceDao<T> {
   public List<T> findByIdTrimester(String idTrimester);
   public List<T> findByLikeIdTrimester(String idTrimester);
   public List<T> findByStartDate(Date startDate);  
   public List<T> findByLikeStartDate(Date startDate);  
   public List<T> findByEndDate(Date endDate);  
   public List<T> findByLikeEndDate(Date endDate);  
   public int updatePrimaryKey(String newKey, String oldKey);

}
