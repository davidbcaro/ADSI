 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcome;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcomePK;
import java.util.List;

/**
 *
 * @author Sebastian
 * @param 
 */
public interface LearningOutcomeDAO <T extends LearningOutcome> extends InterfaceDAO<T>{
    public List<T> findByLearningOutcome (String learningoutcomecode);
    public List<T> findByDescription (String description);
    public List<T> findByLikeLearningOutcome (String learningoutcomecode );
    public List<T> findByCompetitionCode (String competitioncode);
    public List<T> findByLikeCompetitionCode (String competitioncode) ;
    public List<T> findByProgramCode (String programcode);
    public List<T> findByLikeProgramCode (String programcode);
    public List<T> findByVersion (String version);
    public List<T> findByLikeVersion (String version);
    public int updatePrimaryKey (LearningOutcomePK llaveNueva, LearningOutcomePK llaveVieja);
    
}
