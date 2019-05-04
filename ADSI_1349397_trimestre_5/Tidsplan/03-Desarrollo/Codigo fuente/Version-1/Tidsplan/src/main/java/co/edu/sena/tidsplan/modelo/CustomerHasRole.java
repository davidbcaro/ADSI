/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class CustomerHasRole {
    private String document;
    private boolean status;
    private Role role;
    private Customer customer;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.document);
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
        final CustomerHasRole other = (CustomerHasRole) obj;
        if (!Objects.equals(this.document, other.document)) {
            return false;
        }
        return true;
    }
        
}
