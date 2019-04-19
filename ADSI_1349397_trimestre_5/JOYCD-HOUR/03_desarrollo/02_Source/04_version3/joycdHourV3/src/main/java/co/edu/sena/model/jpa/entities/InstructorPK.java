/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
    @Column(name = "document_type", nullable = false, length = 25)
    private String documentType;
    @Basic(optional = false)
    @Column(name = "identification_card", nullable = false, length = 10)
    private String identificationCard;

    public InstructorPK() {
    }

    public InstructorPK(String documentType, String identificationCard) {
        this.documentType = documentType;
        this.identificationCard = identificationCard;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentType != null ? documentType.hashCode() : 0);
        hash += (identificationCard != null ? identificationCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorPK)) {
            return false;
        }
        InstructorPK other = (InstructorPK) object;
        if ((this.documentType == null && other.documentType != null) || (this.documentType != null && !this.documentType.equals(other.documentType))) {
            return false;
        }
        if ((this.identificationCard == null && other.identificationCard != null) || (this.identificationCard != null && !this.identificationCard.equals(other.identificationCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.InstructorPK[ documentType=" + documentType + ", identificationCard=" + identificationCard + " ]";
    }
    
}
