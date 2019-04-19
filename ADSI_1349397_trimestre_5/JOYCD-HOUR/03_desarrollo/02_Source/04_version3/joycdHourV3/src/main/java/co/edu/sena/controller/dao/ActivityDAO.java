/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Activity;
import co.edu.sena.model.jpa.entities.ActivityPK;
import java.util.List;

/**
 *
 * @author Chritian
 */
public interface ActivityDAO <T extends Activity> extends InterfaceDao<T>{
    
    public List <Activity> findByIdActivity   (String idActivity);
    public List <Activity> finByNameActivity (String nameActivity);
    public List <Activity> findByNamePhase (String namePhase);
    public List <Activity> findByProjectCode (String projectCode);
    
    public List <Activity> findByLikeIdActivity (String idActivity);
    public List <Activity> finByLikeNameActivity (String nameActivity);
    public List <Activity> findByLikeNamePhase (String namePhase);
    public List <Activity> findByLikeProjectCode (String projectCode);
    
    public int updatePrimaryKey (ActivityPK llaveNueva, ActivityPK llaveVieja);

    
    


    
    
   
            
}
