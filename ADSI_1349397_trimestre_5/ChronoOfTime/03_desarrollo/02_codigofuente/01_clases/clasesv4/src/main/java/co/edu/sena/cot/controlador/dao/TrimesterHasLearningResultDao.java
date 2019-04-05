/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.TrimesterHasLearningResult;
import co.edu.sena.cot.modelo.dto.TrimesterHasLearningResultPK;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface TrimesterHasLearningResultDao <T extends TrimesterHasLearningResult> extends InterfaceDao<T>  {
    public List<T> findByTrimesterNumber (int trimesterNumber);
    public List<T> findByTriWorkInitials (String triWorkInitials);
    public List<T> findByLeveltCode (String leveltCode);
    public List<T> findByLearningrCode (String learningrCode);
    public List<T> findByCompetenceCode(int competenceCode);
    public List<T> findByProgramCode ( int programCode);
    public List<T> findByLearningEdition ( String learningEdition);
    
    public List<T> findByLikeTrimesterNumber (String trimesterNumber);
    public List<T> findByLikeTriWorkInitials (String triWorkInitials);
    public List<T> findByLikeLeveltCode (String leveltCode);
    public List<T> findByLikeLearningrCode (String learningrCode);
    public List<T> findByLikeCompetenceCode(String CompetenceCode);
    public List<T> findByLikeProgramCode (String ProgramCode);
    public List<T> findByLikeLearningEdition ( String learningEdition);
    public int updatePK(TrimesterHasLearningResultPK llaveNueva, TrimesterHasLearningResultPK llaveVieja);
}
