/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Competence;
import co.edu.sena.cot.modelo.dto.CompetencePK;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface CompetenceDao <T extends Competence> extends InterfaceDao<T> {
    
    public List<T> findByCodeCompetence (int codeCompetence);
    public List<T> findByDescription (String description);
    public List<T> findByCodeProgram (int codeProgram);
    public List<T> findByEdition (String edition);
    public List<T> findByLikeCodeComptence (String codeCompetence);
    public List<T> findByLikeDescription (String description);
    public List<T> findByLikeCodeProgram (String codeProgram);
    public List<T> findByLikeEdition (String edition);
    public int updatePrimaryKey(CompetencePK llaveNueva, CompetencePK llaveVieja);
    
}
