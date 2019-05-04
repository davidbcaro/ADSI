/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRole;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRolePK;
import java.util.List;



/**
 * @param <T>
 * @author MIHOGAR
 */
public interface CustomerHasRoleDao <T extends CustomerHasRole> extends  InterfaceDao<T>{
    public List<T> findByDocumentNumber(String documentNumber);
    public List<T> findByLikeDocumentNumber(String documentNumber);
    public List<T> findByDocument(String document);
    public List<T> findByLikeDocument(String document);
    public List<T> findByIdRol(String idRol);
    public List<T> findByLikeIdRol(String idRol);
    public List<T> findByStatus(boolean status);
    public int updatePrimaryKey(CustomerHasRolePK  newKey, CustomerHasRolePK oldKey);

   
    
}
