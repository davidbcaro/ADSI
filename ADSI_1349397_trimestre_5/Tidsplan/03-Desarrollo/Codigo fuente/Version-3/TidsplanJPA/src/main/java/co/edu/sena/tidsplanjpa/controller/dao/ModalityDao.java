/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Modality;
import java.util.List;

/**
 *
 * @author JulianC
 * @param <T>
 */
public interface ModalityDao <T extends Modality> extends InterfaceDao<T>{
    public List<T> findByStatus(boolean status);
    public List<T> findByNameModality(String nameModality);
    public List<T> findByLikeNameModality(String nameModality);
    public int updatePrimaryKey (String newKey, String oldKey);
}
