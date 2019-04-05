/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Program;
import co.edu.sena.cot.modelo.dto.ProgramPK;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface ProgramDao <T extends Program> extends InterfaceDao<T> {
    
    public List<T> findByCodeProgram (int codeProgram);
    public List<T> findByNameProgram (String nameProgram);
    public List<T> findByEdition ( String edition);
    public List<T> findByInitials (String initials);
    public List<T> findByState (String state);
    public List<T> findByLevelTraCode (String levelTraCode);
    public List<T> findByLikeCodeProgram (String codeProgram);
    public List<T> findByLikeNameProgram (String nameProgram);
    public List<T> finfByLikeEdition (String edition);
    public List<T> findByLikeInitials (String initials);
    public List<T> findByLikeLevelTraCode (String levelTraCode);
    public int updatePrimaryKey(ProgramPK llaveNueva, ProgramPK llaveVieja);
    
}
