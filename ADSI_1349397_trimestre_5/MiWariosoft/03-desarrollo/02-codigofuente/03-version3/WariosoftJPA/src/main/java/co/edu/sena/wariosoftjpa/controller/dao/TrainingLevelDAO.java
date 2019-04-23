/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.TrainingLevel;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface TrainingLevelDAO<T extends TrainingLevel> extends InterfaceDAO<T>{
    public List<T> findByTrainingLevel(String traininglevel);
    public List<T> findByState(Boolean state);
    public List<T> findByLikeTrainingLevel(String traininglevel);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
