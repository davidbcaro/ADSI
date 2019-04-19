/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Environment;
import co.edu.sena.model.jpa.entities.EnvironmentPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface EnvironmentDAO <T extends Environment> extends InterfaceDao<T> {

    public List<Environment> findByNumberEnvironment(String numberEnvironment);
    public List<Environment> findByDescription(String description);
    public List<Environment> findByStatus(boolean status);
    public List<Environment> findByHeadQuartersName(String headQuartersName);
    
    public List<Environment> findByLikeNumberEnvironment(String numberEnvironment);
    public List<Environment> findByLikeDescription(String description);
    public List<Environment> findByLikeHeadQuartersName(String headQuartersName);
    
     public int updatePrimaryKey (EnvironmentPK llaveNueva, EnvironmentPK llaveVieja);
    

}
