/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1349397
 */
@Embeddable
public class AvailabilityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document_Number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "id_Document", nullable = false, length = 100)
    private String idDocument;
    @Basic(optional = false)
    @Column(name = "start_Time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "acronyms_Working_Day", nullable = false, length = 20)
    private String acronymsWorkingDay;
    @Basic(optional = false)
    @Column(name = "name_Day", nullable = false, length = 10)
    private String nameDay;

    public AvailabilityPK() {
    }

    public AvailabilityPK(String documentNumber, String idDocument, Date startTime, String acronymsWorkingDay, String nameDay) {
        this.documentNumber = documentNumber;
        this.idDocument = idDocument;
        this.startTime = startTime;
        this.acronymsWorkingDay = acronymsWorkingDay;
        this.nameDay = nameDay;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getAcronymsWorkingDay() {
        return acronymsWorkingDay;
    }

    public void setAcronymsWorkingDay(String acronymsWorkingDay) {
        this.acronymsWorkingDay = acronymsWorkingDay;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        hash += (startTime != null ? startTime.hashCode() : 0);
        hash += (acronymsWorkingDay != null ? acronymsWorkingDay.hashCode() : 0);
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvailabilityPK)) {
            return false;
        }
        AvailabilityPK other = (AvailabilityPK) object;
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        if ((this.startTime == null && other.startTime != null) || (this.startTime != null && !this.startTime.equals(other.startTime))) {
            return false;
        }
        if ((this.acronymsWorkingDay == null && other.acronymsWorkingDay != null) || (this.acronymsWorkingDay != null && !this.acronymsWorkingDay.equals(other.acronymsWorkingDay))) {
            return false;
        }
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.AvailabilityPK[ documentNumber=" + documentNumber + ", idDocument=" + idDocument + ", startTime=" + startTime + ", acronymsWorkingDay=" + acronymsWorkingDay + ", nameDay=" + nameDay + " ]";
    }
    
}
