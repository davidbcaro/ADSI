/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.LearningResult;
import co.edu.sena.cot.modelo.dto.LearningResultPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface LearningResultDao <T extends LearningResult> extends InterfaceDao<T> {
    
     public List<T> findByCode (String code);
    public List<T> findByDescription (String description);
    public List<T> findByCodeCompetence(int codeCompetence);
    public List<T> findByCodeProgram ( int codeProgram);
    public List<T> findByEdition ( String edition);
   
     public List<T> findByLikeCode (String code);
    public List<T> findByLikeDescription (String description);
    public List<T> findByLikeCodeCompetence(String codeCompetence);
    public List<T> findByLikeCodeProgram ( String codeProgram);
    public List<T> findByLikeEdition ( String edition);
   
    public int updatePrimaryKey(LearningResultPK llaveNueva, LearningResultPK llaveVieja);
    
}
