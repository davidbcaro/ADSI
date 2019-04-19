/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.IdentificationCard;
import co.edu.sena.model.jpa.entities.LearningResult;
import co.edu.sena.model.jpa.entities.LearningResultPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LearningResultDAO <T extends LearningResult> extends InterfaceDao <T>{
    public List<LearningResult> findByLearningResultCode (String learningResultCode);
    public List<LearningResult> findByDescription (String description);
    public List <LearningResult> findByProgramCode (String programcode);
    public List <LearningResult> findByCompetenceCode (String competenceCode);
    public List <LearningResult> findByVersion (String version);
    
    public List <LearningResult> findByLikeLearningCode (String learningResultCode );
    public List <LearningResult> findByLikeDescription (String description);
    public List <LearningResult> findByLikeProgramCode (String programcode);
    public List <LearningResult> findByLikeCompetenceCode (String competenceCode);
    public List <LearningResult> findByLikeVersion (String version);
    public int updatePrimaryKey (LearningResultPK llaveNueva, LearningResultPK llaveVieja);
}
