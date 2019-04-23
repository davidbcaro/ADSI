/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Client;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ClientPK;
import java.util.List;

/**
 *
 * @author WINDOWS 8
 * @param <T>
 */
public interface ClientDAO <T extends Client> extends InterfaceDAO<T>{
    
   public List<T> findByDocumentNumber(String documentNumber);
     
    public List<T> findByFirstName(String firstName);

    public List<T> findBySecondName(String secondName);
     public List<T> findByFirstLastName(String firstLastName);

    public List<T> findBySecondLastName(String secondLastName);
    
    public List<T> findByIdDocument(String idDocument);

    public List<T> findByLikeDocumentNumber(String documentNumber);
    

    
    public List<T> findByLikeIdDocument(String idDocument);
    
    public int updatePk(ClientPK llaveNueva, ClientPK llaveVieja );
    
}
