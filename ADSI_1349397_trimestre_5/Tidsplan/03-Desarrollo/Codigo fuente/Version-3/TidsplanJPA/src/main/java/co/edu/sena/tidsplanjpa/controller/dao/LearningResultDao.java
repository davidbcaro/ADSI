/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;



import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult;
import co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResultPK;

import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LearningResultDao <T extends LearningResult> extends InterfaceDao<T>{
    public List<T> findByLikeIdCode(String idCode);
    public List<T> findByIdCode(String idCode);
    public List<T> findByLikeDescription(String description);
    public List<T> findByDescription(String description);
    public List<T> findByProgramCode(String programCode);
    public List<T> findByLikeProgramCode(String programCode);
    public List<T> findByLikeCompetitionCode(String competitionCode);
    public List<T> findByCompetitionCode(String competitionCode);
    public List<T> findByProgramVersion(String programVersion);
    public List<T> findByLikeProgramVersion(String programVersion);
    public int updatePrimaryKey(LearningResultPK newKey, LearningResultPK oldKey);
    
}
