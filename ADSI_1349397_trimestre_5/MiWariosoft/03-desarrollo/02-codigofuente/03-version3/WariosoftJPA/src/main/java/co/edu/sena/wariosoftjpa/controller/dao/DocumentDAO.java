/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Document;
import java.util.List;

/**
 *
 * @author WINDOWS 8
 */
public interface DocumentDAO <T extends Document> extends InterfaceDAO<T>{
    public List<T> findByIdDocument(String idDocument);
    public List<T> findByName(String name);
    public List<T> findByState(boolean state);
    public List<T> findByLikeIdDocument(String idDocument);
    public int updatePk(String llaveNueva, String llaveVieja); 
    
}
