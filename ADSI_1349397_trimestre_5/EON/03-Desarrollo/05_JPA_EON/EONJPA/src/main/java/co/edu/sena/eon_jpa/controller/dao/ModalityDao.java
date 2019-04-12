/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Modality;
import java.util.List;

/**
 *
 * @author Telegrafia01
 */
public interface ModalityDao <M extends Modality>extends InterfaceDao<M>{
    public List<M>findByNameModality(String name);
    public List<M>findByLikeNameModality(String name);
    public List<M>findByState(Boolean state);
    public int updatePrimaryKey(String nuevoModality ,String viejoModality);
    
}
