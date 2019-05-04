/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;

/**
 *
 * @author 1349397
 */
public class Customer {
    private int documentNumber;
    private String firtsName;
    private String secondName;
    private String surname;
    private String secondSurname;
    private byte foto;
    private User user;
    private List<CustomerHasRole> customerHasRole;
    private Document document;
    private Instructor instructor; 

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CustomerHasRole> getCustomerHasRole() {
        return customerHasRole;
    }

    public void setCustomerHasRole(List<CustomerHasRole> customerHasRole) {
        this.customerHasRole = customerHasRole;
    }
    
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.documentNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.documentNumber != other.documentNumber) {
            return false;
        }
        return true;
    }
    
    
}
