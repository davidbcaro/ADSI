/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimesterPK;

import java.util.List;

/**
 *
 * @author 1349397
 */
public interface GroupHasTrimesterDao <T extends GroupHasTrimester> extends InterfaceDao<T>{
    public List<T> findByLikeNumberGroup(String numberGroup);
    public List<T> findByLikeNameTrimester(String nameTrimester);
    public List<T> findByLikeWorkingDayInitials(String workingDayInitials);
    public List<T> findByLikeLevelFormation(String levelFormation);
    public List<T> findByNumberGroup(String numberGroup);
    public List<T> findByNameTrimester(String nameTrimester);
    public List<T> findByWorkingDayInitials(String workingDayInitials);
    public List<T> findByLevelFormation(String levelFormation);
    public int updatePrimaryKey(GroupHasTrimesterPK newKey, GroupHasTrimesterPK oldKey);
    
}
