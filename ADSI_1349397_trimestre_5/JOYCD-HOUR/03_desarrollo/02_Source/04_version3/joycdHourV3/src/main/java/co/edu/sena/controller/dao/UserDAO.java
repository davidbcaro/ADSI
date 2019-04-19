/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.User;
import co.edu.sena.model.jpa.entities.UserPK;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface UserDAO <T extends User> extends InterfaceDao<T>{
    public List <User> findByEmail   (String email);
    public List <User> findByPassword (String password);
    public List <User> findByDocumenType (String documentType);
    public List <User> findByIdentificactionCardNumber (String identificationCardNumber);
    
    public List <User> findByLikeEmail (String email);
    public List <User> findByLikePassword (String password);
    public List <User> findByLikeDocumenType (String documentType);
    public List <User> findByLikeIdentificactionCardNumber (String identificationCardNumber);
    public int updatePrimaryKey (UserPK llaveNueva, UserPK llaveVieja);
    
    
    
}
