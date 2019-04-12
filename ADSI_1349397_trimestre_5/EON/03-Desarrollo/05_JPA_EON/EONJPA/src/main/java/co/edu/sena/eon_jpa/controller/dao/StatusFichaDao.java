/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.StatusFicha;
import java.util.List;

/**
 *
 * @author SOPORTE
 * @param <S>
 */
public interface StatusFichaDao<S extends StatusFicha> extends InterfaceDao<S> {

    public List<S> findByNameState(String nameState);
    
    public List<S> findByState(boolean State);

    public List<S> findByLikeNameState(String nameState);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);

}
