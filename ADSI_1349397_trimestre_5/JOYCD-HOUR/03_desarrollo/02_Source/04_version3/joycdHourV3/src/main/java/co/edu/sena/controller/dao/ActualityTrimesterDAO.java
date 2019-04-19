/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.ActualityTrimester;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 * @param 
 */
public interface ActualityTrimesterDAO <T extends ActualityTrimester> extends InterfaceDao<T> {
    // campos de la tabla 

    public List<T> findByActualityTrimester(String ActualityTrimester);
    public List<T> findByStartDate(Date startDate);
    public List<T> findByFinishDate(Date finishDate);
    public List<T> findByLikeActualityTrimester(String ActualityTrimester);
    public int updatePk(String llaveNueva, String llaveVieja);
}
