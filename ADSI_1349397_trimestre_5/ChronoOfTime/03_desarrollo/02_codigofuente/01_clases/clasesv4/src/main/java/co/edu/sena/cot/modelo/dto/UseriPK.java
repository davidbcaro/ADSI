/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorge
 */
@Embeddable
public class UseriPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_number", nullable = false)
    private int personNumber;
    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;

    public UseriPK() {
    }

    public UseriPK(int personNumber, String document) {
        this.personNumber = personNumber;
        this.document = document;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personNumber;
        hash += (document != null ? document.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UseriPK)) {
            return false;
        }
        UseriPK other = (UseriPK) object;
        if (this.personNumber != other.personNumber) {
            return false;
        }
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.UseriPK[ personNumber=" + personNumber + ", document=" + document + " ]";
    }
    
}
