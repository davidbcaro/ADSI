/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
public class DisponibilityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;
    @Basic(optional = false)
    @Column(name = "document_number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "start_hour", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startHour;
    @Basic(optional = false)
    @Column(name = "name_day", nullable = false, length = 10)
    private String nameDay;
    @Basic(optional = false)
    @Column(name = "working_day_initials", nullable = false, length = 10)
    private String workingDayInitials;

    public DisponibilityPK() {
    }

    public DisponibilityPK(String document, String documentNumber, Date startHour, String nameDay, String workingDayInitials) {
        this.document = document;
        this.documentNumber = documentNumber;
        this.startHour = startHour;
        this.nameDay = nameDay;
        this.workingDayInitials = workingDayInitials;
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

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getWorkingDayInitials() {
        return workingDayInitials;
    }

    public void setWorkingDayInitials(String workingDayInitials) {
        this.workingDayInitials = workingDayInitials;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (startHour != null ? startHour.hashCode() : 0);
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        hash += (workingDayInitials != null ? workingDayInitials.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilityPK)) {
            return false;
        }
        DisponibilityPK other = (DisponibilityPK) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.startHour == null && other.startHour != null) || (this.startHour != null && !this.startHour.equals(other.startHour))) {
            return false;
        }
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        if ((this.workingDayInitials == null && other.workingDayInitials != null) || (this.workingDayInitials != null && !this.workingDayInitials.equals(other.workingDayInitials))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.DisponibilityPK[ document=" + document + ", documentNumber=" + documentNumber + ", startHour=" + startHour + ", nameDay=" + nameDay + ", workingDayInitials=" + workingDayInitials + " ]";
    }
    
}
