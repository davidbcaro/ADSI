/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    @Column(name = "document_Number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "id_Document", nullable = false, length = 100)
    private String idDocument;

    public InstructorPK() {
    }

    public InstructorPK(String documentNumber, String idDocument) {
        this.documentNumber = documentNumber;
        this.idDocument = idDocument;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorPK)) {
            return false;
        }
        InstructorPK other = (InstructorPK) object;
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.InstructorPK[ documentNumber=" + documentNumber + ", idDocument=" + idDocument + " ]";
    }
    
}
