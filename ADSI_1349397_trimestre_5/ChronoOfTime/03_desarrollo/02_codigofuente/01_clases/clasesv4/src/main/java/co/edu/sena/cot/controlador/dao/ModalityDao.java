/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Modality;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface ModalityDao  <T extends Modality> extends InterfaceDao<T> {
    
    public List <T> findByNameModality (String name);
    public List <T> findByState (boolean state);
    public List <T> findByLikeNameModality (String name);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
