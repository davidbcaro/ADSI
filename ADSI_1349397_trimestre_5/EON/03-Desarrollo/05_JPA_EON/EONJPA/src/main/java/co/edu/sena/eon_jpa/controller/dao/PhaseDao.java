/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Phase;
import co.edu.sena.eon_jpa.model.jpa.entities.PhasePK;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <p>
 * 
 */
public interface PhaseDao <p extends Phase> extends InterfaceDao<p>{
    public List<p> findByNamePhase(String name_Phase);
    public List<p> findByState(boolean State);
    public List<p> findByCode(String Code);
    public List<p> findByLikeNamePhase(String name_Phase);
    public List<p> findByLikeCode(String Code);
    public int updatePrimaryKey(PhasePK llaveNueva, PhasePK llaveVieja);
}