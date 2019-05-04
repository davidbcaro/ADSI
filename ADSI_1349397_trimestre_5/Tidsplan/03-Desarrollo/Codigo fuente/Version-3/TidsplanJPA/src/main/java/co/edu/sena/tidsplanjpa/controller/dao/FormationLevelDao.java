/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.FormationLevel;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface FormationLevelDao <T extends FormationLevel> extends InterfaceDao<T>{
    public List<T> findByLikeLevelFormation(String levelFormation);
    public List<T> findByLevelFormation(String levelFormation);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(String newKey, String oldKey);
    
}
