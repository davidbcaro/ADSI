/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Phase;
import co.edu.sena.cot.modelo.dto.PhasePK;
import java.util.List;

/**
 *
 * @author Camargo
 * @param <T>
 */
public interface PhaseDao <T extends Phase> extends InterfaceDao<T> {
    
    
    public List<T> findByState (boolean state);
    public List<T> findByName (String namePhase);
    public List<T> findByCode ( int codeProject);
    public List<T> findByLikeName (String namePhase);
    public List<T> findByLikeCode (String codeProject);
    public int updatePrimaryKey(PhasePK llaveNueva, PhasePK llaveVieja);
    
}
