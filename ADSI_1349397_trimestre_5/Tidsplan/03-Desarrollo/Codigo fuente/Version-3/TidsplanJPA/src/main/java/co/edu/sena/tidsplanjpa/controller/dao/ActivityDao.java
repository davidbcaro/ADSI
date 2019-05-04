/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Activity;
import co.edu.sena.tidsplanjpa.model.jpa.entities.ActivityPK;

import java.util.List;

/**
 *
 * @author 1349397
 */
public interface ActivityDao <T extends Activity> extends InterfaceDao<T>{
    public List<T> findByLikeIdActivity(String idActivity);
    public List<T> findByLikeName(String name);
    public List<T> findByLikeNamePhase(String namePhase);
    public List<T> findByLikeProjectCode(String projectCode);
    public List<T> findByIdActivity(String idActivity);
    public List<T> findByName(String name);
    public List<T> findByNamePhase(String namePhase);
    public List<T> findByProjectCode(String projectCode);
    public int updatePrimaryKey(ActivityPK newKey, ActivityPK oldKey);
    
}
