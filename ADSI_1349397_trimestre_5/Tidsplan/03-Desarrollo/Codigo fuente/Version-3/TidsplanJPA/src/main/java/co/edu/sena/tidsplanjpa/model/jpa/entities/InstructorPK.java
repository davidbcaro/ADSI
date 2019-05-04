/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class InstructorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;
    @Basic(optional = false)
    @Column(name = "document_number", nullable = false, length = 20)
    private String documentNumber;

    public InstructorPK() {
    }

    public InstructorPK(String document, String documentNumber) {
        this.document = document;
        this.documentNumber = documentNumber;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorPK)) {
            return false;
        }
        InstructorPK other = (InstructorPK) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.InstructorPK[ document=" + document + ", documentNumber=" + documentNumber + " ]";
    }
    
}
