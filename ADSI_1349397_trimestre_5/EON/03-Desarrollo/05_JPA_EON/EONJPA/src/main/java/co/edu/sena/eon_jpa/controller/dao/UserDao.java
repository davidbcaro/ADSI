/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.User;
import co.edu.sena.eon_jpa.model.jpa.entities.UserPK;
import java.util.Date;
import java.util.List;


public interface UserDao <T extends User> extends InterfaceDao<T> {
 
    public List<T> findByMail(String mail);     
    public List<T> findByPassWord(String password);    
    public List<T> findByDocumentNumber(String documentNumber);  
    public List<T> findByIdDocument(String idDocument);
    public List<T> findByDateEndind(Date dateEndind);
    public List<T> findByLikeDocumentNumber(String documentNumber);    
    public List<T> findByLikeIdDocument(String idDocument);    
    public List<T> findByLikeDateEndind(Date dateEndind);    
    public List<T> findByLikeMail(String mail);     
    public List<T> findByLikePassWord(String password);    
    public int updatePrimaryKey(UserPK newKey, UserPK oldKey);
}
