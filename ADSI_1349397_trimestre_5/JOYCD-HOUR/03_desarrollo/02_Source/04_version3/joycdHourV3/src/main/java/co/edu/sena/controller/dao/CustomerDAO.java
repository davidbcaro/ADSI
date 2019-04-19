/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Customer;
import co.edu.sena.model.jpa.entities.CustomerPK;
import java.util.List;

/**
 *
 * @author Usser
 */
public interface CustomerDAO <T extends Customer> extends InterfaceDao <T> {
    public List<Customer> findByDocumentType (String documentType);
    public List<Customer> findByFirstName (String firstName);
    public List<Customer> findBySecondName (String secondName);
    public List<Customer> findByFirstLastName (String firstLastName);
    public List<Customer> findBySecondLastName (String secondLastName);
    public List<Customer> findByIdentificationCardNumber (String identificationCardNumber);
    //--------
    public List<Customer> findByLikeDocumentType (String documentType);
    public List<Customer> findByLikeFirstName (String firstName);
    public List<Customer> findByLikeSecondName (String secondName);
    public List<Customer> findByLikeFirstLastName (String firstLastName);
    public List<Customer> findByLikeSecondLastName (String secondLastName);
    public List<Customer> findByLikeIdentificationCardNumber (String identificationCardNumber);
    public int updatePrimaryKey(CustomerPK llaveNueva, CustomerPK llaveVieja);
    
}
