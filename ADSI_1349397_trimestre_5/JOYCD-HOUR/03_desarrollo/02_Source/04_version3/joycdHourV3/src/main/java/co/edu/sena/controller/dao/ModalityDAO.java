/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Modality;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface ModalityDAO <T extends Modality> extends InterfaceDao<T>{
    
    
    public List<Modality> findByNameModality(String nameModality);
    public List<Modality> findByStatus(boolean status);
    public List<Modality> findByLikeNameModality(String nameModality);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
    
    
}
