/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgram;
import co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgramPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface TrainingProgramDao <T extends TrainingProgram> extends InterfaceDao<T>{
    public List<T> findByIdCode(String idCode);
    public List<T> findByLikeIdCode(String idCode);
    public List<T> findByName(String name);
    public List<T> findByLikeName(String name);
    public List<T> findByVersion(String version);
    public List<T> findByLikeVersion(String version);
    public List<T> findByInitials(String initials);
    public List<T> findByLikeInitials(String initials);
    public List<T> findByStatus(boolean status);
    public List<T> findByLevelFormation(String levelFormation);
    public List<T> findByLikeLevelFormation(String levelFormation);
    public int updatePrimaryKey(TrainingProgramPK newKey, TrainingProgramPK oldKey);
    
}
