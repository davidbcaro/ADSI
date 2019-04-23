/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Modality;
import java.util.List;

/**
 *
 * @author Brayan
 */
public interface ModalityDAO <T extends Modality> extends InterfaceDAO<T>{
    public List<T> findByNameModality(String nameModality);
    public List<T> findByState(boolean state);
    public List<T> findByLikeNameModality(String nameModality);
    public int updatePk(String llaveNueva, String llaveVieja);
    
}
