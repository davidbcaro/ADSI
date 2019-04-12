/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Client;
import co.edu.sena.eon_jpa.model.jpa.entities.ClientPK;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface ClientDao <T extends Client> extends InterfaceDao<T> {
    
    public List<T> findByDocumentNumber(String documentNumber);
     
    public List<T> findByFirstName(String firstName);
    
    public List<T> findBysecondName(String secondName);

    public List<T> findByFirstLastName(String firstLastname);
    
    public List<T> findBySecondLastName(String secondLastname);
   
    public List<T> findByIdDocument(String idDocument);
    
    public List<T> findByLikeDocumentNumber(String documentNumber);
     
    public List<T> findByLikeFirstName(String firstName);
    
    public List<T> findByLikeSecondName(String secondName);

    public List<T> findByLikeFirstLastName(String firstLastname);
    
    public List<T> findByLikeSecondLastName(String secondLastname);
   
    public List<T> findByLikeIdDocument(String idDocument);
    

    
    
    public int updatePrimaryKey(ClientPK newPK, ClientPK oldPK );
    
   
    
    
 
}
