/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
    @Column(name = "hour_start", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hourStart;
    @Basic(optional = false)
    @Column(name = "document_type", nullable = false, length = 25)
    private String documentType;
    @Basic(optional = false)
    @Column(name = "identification_card", nullable = false, length = 10)
    private String identificationCard;
    @Basic(optional = false)
    @Column(name = "name_day", nullable = false, length = 10)
    private String nameDay;
    @Basic(optional = false)
    @Column(name = "working_day_initials", nullable = false, length = 10)
    private String workingDayInitials;

    public AvailabilityPK() {
    }

    public AvailabilityPK(Date hourStart, String documentType, String identificationCard, String nameDay, String workingDayInitials) {
        this.hourStart = hourStart;
        this.documentType = documentType;
        this.identificationCard = identificationCard;
        this.nameDay = nameDay;
        this.workingDayInitials = workingDayInitials;
    }

    public Date getHourStart() {
        return hourStart;
    }

    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
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
        hash += (hourStart != null ? hourStart.hashCode() : 0);
        hash += (documentType != null ? documentType.hashCode() : 0);
        hash += (identificationCard != null ? identificationCard.hashCode() : 0);
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        hash += (workingDayInitials != null ? workingDayInitials.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvailabilityPK)) {
            return false;
        }
        AvailabilityPK other = (AvailabilityPK) object;
        if ((this.hourStart == null && other.hourStart != null) || (this.hourStart != null && !this.hourStart.equals(other.hourStart))) {
            return false;
        }
        if ((this.documentType == null && other.documentType != null) || (this.documentType != null && !this.documentType.equals(other.documentType))) {
            return false;
        }
        if ((this.identificationCard == null && other.identificationCard != null) || (this.identificationCard != null && !this.identificationCard.equals(other.identificationCard))) {
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
        return "co.edu.sena.model.jpa.entities.AvailabilityPK[ hourStart=" + hourStart + ", documentType=" + documentType + ", identificationCard=" + identificationCard + ", nameDay=" + nameDay + ", workingDayInitials=" + workingDayInitials + " ]";
    }
    
}
