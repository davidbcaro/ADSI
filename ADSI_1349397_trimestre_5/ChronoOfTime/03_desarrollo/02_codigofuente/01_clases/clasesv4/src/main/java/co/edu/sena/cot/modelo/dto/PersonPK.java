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
public class PersonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "number_document", nullable = false)
    private int numberDocument;
    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;

    public PersonPK() {
    }

    public PersonPK(int numberDocument, String document) {
        this.numberDocument = numberDocument;
        this.document = document;
    }

    public int getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(int numberDocument) {
        this.numberDocument = numberDocument;
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
        hash += (int) numberDocument;
        hash += (document != null ? document.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPK)) {
            return false;
        }
        PersonPK other = (PersonPK) object;
        if (this.numberDocument != other.numberDocument) {
            return false;
        }
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.PersonPK[ numberDocument=" + numberDocument + ", document=" + document + " ]";
    }
    
}
