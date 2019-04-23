/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.User;
import co.edu.sena.wariosoftjpa.model.jpa.entities.UserPK;
import java.util.List;

/**
 *
 * @author WINDOWS 8
 * @param <T>
 */
public interface UserDAO <T extends User> extends InterfaceDAO<T>{
    

    public List<T> findByEmail(String email);
     
    public List<T> findByPassword(String password);

    public List<T> findByDateTerminate(String dateTerminate);
    
     public List<T> findByIdDocument(String idDocument);

    public List<T> findByDocumentNumber(String documentNumber);
    
    public List<T> findByLikeIdDocument(String idDocument);

    public List<T> findByLikeDocumentNumber(String documentNumber);
    

  
    
    public int updatePk(UserPK llaveNueva, UserPK llaveVieja );  
    
}
