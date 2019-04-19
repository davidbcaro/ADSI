/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.PhaseProject;
import co.edu.sena.model.jpa.entities.PhaseProjectPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface PhaseProjectDAO <T extends PhaseProject> extends InterfaceDao<T>{
    public List <PhaseProject> findByNamePhase   (String namePhase);
    public List <PhaseProject> findByStatusPhase (String statusPhase);
    public List <PhaseProject> findByProjectCode (String projectCode);
    public List <PhaseProject> findByLikeNamePhase (String namePhase);
    public List <PhaseProject> findByLikeStatusPhase (String statusPhase);
    public List <PhaseProject> findByLikeProjectCode (String projectCode);
    public int updatePrimaryKey (PhaseProjectPK llaveNueva, PhaseProjectPK llaveVieja);
    
    
    
}
