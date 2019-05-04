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
public class CustomerHasRolePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;
    @Basic(optional = false)
    @Column(name = "document_number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "idrol", nullable = false, length = 20)
    private String idrol;

    public CustomerHasRolePK() {
    }

    public CustomerHasRolePK(String document, String documentNumber, String idrol) {
        this.document = document;
        this.documentNumber = documentNumber;
        this.idrol = idrol;
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

    public String getIdrol() {
        return idrol;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerHasRolePK)) {
            return false;
        }
        CustomerHasRolePK other = (CustomerHasRolePK) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRolePK[ document=" + document + ", documentNumber=" + documentNumber + ", idrol=" + idrol + " ]";
    }
    
}
