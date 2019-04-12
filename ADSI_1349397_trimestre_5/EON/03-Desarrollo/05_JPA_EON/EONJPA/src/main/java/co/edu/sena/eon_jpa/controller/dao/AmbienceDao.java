/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Ambience;
import co.edu.sena.eon_jpa.model.jpa.entities.AmbiencePK;
import java.util.List;


/**
 *
 * @author SOPORTE
 * @param <C>
 */
public interface AmbienceDao <C extends Ambience>extends InterfaceDao<C>{
     List <C>findByDescription(String description);
    List <C>findByStatus(boolean status);
    List <C>findByNumberAmbience(String numberAmbience);
    List <C>findByNameHeadquarters(String nameHeadquarters);
    List <C>findByLikeDescription(String description);
    List <C>findByLikeNumberAmbience(String numberAmbience);
    List <C>findByLikeNameHeadquarters(String nameHeadquarters);
    public int updatePrimaryKey(AmbiencePK nuevoAmbience , AmbiencePK viejoAmbience);

    
}
