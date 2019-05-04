/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Customer;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerPK;

import java.util.List;

/**
 * @param <T>
 * @author 1349397
 */
public interface CustomerDao <T extends Customer> extends  InterfaceDao<T> {
    public List<T> findByDocument(String document);
    public List<T> findByLikeDocument(String document);
    public List<T> findByDocumentNumber(String documentNumber);
    public List<T> findByLikeDocumentNumber(String documentNumber);
    public List<T> findByFirstName(String firstName);
    public List<T> findByLikeFirstName(String firstName);
    public List<T> findBySecondName(String secondName);
    public List<T> findByLikeSecondName(String secondName);
    public List<T> findBySurname(String surname);
    public List<T> findByLikeSurname(String surname);
    public List<T> findBySecondSurname(String secondSurname);
    public List<T> findByLikeSecondSurname(String secondSurname);
    public int updatePrimaryKey(CustomerPK  newKey, CustomerPK oldKey);
    
    
}
