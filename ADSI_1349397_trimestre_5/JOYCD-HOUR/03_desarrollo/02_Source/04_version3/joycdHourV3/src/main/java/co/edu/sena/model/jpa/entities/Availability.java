/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "availability")
@NamedQueries({
    @NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a")
    , @NamedQuery(name = "Availability.findByHourStart", query = "SELECT a FROM Availability a WHERE a.availabilityPK.hourStart = :hourStart")
    , @NamedQuery(name = "Availability.findByHourEnd", query = "SELECT a FROM Availability a WHERE a.hourEnd = :hourEnd")
    , @NamedQuery(name = "Availability.findByDocumentType", query = "SELECT a FROM Availability a WHERE a.availabilityPK.documentType = :documentType")
    , @NamedQuery(name = "Availability.findByIdentificationCard", query = "SELECT a FROM Availability a WHERE a.availabilityPK.identificationCard = :identificationCard")
    , @NamedQuery(name = "Availability.findByNameDay", query = "SELECT a FROM Availability a WHERE a.availabilityPK.nameDay = :nameDay")
    , @NamedQuery(name = "Availability.findByWorkingDayInitials", query = "SELECT a FROM Availability a WHERE a.availabilityPK.workingDayInitials = :workingDayInitials")})
public class Availability implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvailabilityPK availabilityPK;
    @Column(name = "hour_end")
    @Temporal(TemporalType.TIME)
    private Date hourEnd;
    @JoinColumn(name = "name_day", referencedColumnName = "name_day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "document_type", referencedColumnName = "document_type", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "identification_card", referencedColumnName = "identification_card", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "working_day_initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Availability() {
    }

    public Availability(AvailabilityPK availabilityPK) {
        this.availabilityPK = availabilityPK;
    }

    public Availability(Date hourStart, String documentType, String identificationCard, String nameDay, String workingDayInitials) {
        this.availabilityPK = new AvailabilityPK(hourStart, documentType, identificationCard, nameDay, workingDayInitials);
    }

    public AvailabilityPK getAvailabilityPK() {
        return availabilityPK;
    }

    public void setAvailabilityPK(AvailabilityPK availabilityPK) {
        this.availabilityPK = availabilityPK;
    }

    public Date getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Date hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (availabilityPK != null ? availabilityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Availability)) {
            return false;
        }
        Availability other = (Availability) object;
        if ((this.availabilityPK == null && other.availabilityPK != null) || (this.availabilityPK != null && !this.availabilityPK.equals(other.availabilityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Availability[ availabilityPK=" + availabilityPK + " ]";
    }
    
}
