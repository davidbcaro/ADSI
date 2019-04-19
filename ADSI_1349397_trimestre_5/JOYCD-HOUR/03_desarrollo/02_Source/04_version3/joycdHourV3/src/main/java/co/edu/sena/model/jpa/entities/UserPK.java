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
public class UserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document_type", nullable = false, length = 25)
    private String documentType;
    @Basic(optional = false)
    @Column(name = "identification_card_number", nullable = false, length = 10)
    private String identificationCardNumber;

    public UserPK() {
    }

    public UserPK(String documentType, String identificationCardNumber) {
        this.documentType = documentType;
        this.identificationCardNumber = identificationCardNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdentificationCardNumber() {
        return identificationCardNumber;
    }

    public void setIdentificationCardNumber(String identificationCardNumber) {
        this.identificationCardNumber = identificationCardNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentType != null ? documentType.hashCode() : 0);
        hash += (identificationCardNumber != null ? identificationCardNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPK)) {
            return false;
        }
        UserPK other = (UserPK) object;
        if ((this.documentType == null && other.documentType != null) || (this.documentType != null && !this.documentType.equals(other.documentType))) {
            return false;
        }
        if ((this.identificationCardNumber == null && other.identificationCardNumber != null) || (this.identificationCardNumber != null && !this.identificationCardNumber.equals(other.identificationCardNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.UserPK[ documentType=" + documentType + ", identificationCardNumber=" + identificationCardNumber + " ]";
    }
    
}
