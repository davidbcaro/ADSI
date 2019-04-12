/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.TrainingLevel;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 * @param <t>
 */
public interface TrainingLevelDao <t extends TrainingLevel> extends InterfaceDao<t>{
public List<t> findByTrainingLevel(String training_Level);
public List<t> findByState(boolean State);
public List<t> findByLikeTrainingLevel(String training_Level);
public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
