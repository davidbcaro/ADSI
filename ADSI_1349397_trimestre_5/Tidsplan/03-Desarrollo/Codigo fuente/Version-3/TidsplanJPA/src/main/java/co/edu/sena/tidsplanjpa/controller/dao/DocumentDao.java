/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Document;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface DocumentDao <T extends Document> extends  InterfaceDao<T>{
    public List<T> findByIdDocument(String idDocument);
    public List<T> findByTypeDocument(String typeDocument);
    public List<T> findByStatus(boolean status);
    public List<T> findByLikeIdDocument(String idDocument);
    public List<T> findByLikeTypeDocument(String typeDocument);
    public int updatePrimaryKey(String newKey, String oldKey);
}
