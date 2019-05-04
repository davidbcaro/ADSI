/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Trimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface TrimesterDao <T extends Trimester> extends InterfaceDao<T>{
    public List<T> findByLikeNameTrimester(String nameTrimester);
    public List<T> findByLikeWorkingDayInitials(String workingDayInitials);
    public List<T> findByLikeLevelFormation(String levelFormation);
    public List<T> findByNameTrimester(String nameTrimester);
    public List<T> findByWorkingDayInitials(String workingDayInitials);
    public List<T> findByLevelFormation(String levelFormation);
    public int updatePrimaryKey(TrimesterPK newKey, TrimesterPK oldKey);
    
}
