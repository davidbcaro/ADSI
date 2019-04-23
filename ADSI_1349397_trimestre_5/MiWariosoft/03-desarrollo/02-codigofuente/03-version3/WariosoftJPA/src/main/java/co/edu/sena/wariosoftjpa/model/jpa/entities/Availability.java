/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a")})
public class Availability implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvailabilityPK availabilityPK;
    @Basic(optional = false)
    @Column(name = "end_Time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @JoinColumn(name = "name_Day", referencedColumnName = "name_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "initials_Working_Day", referencedColumnName = "initials_Working_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Availability() {
    }

    public Availability(AvailabilityPK availabilityPK) {
        this.availabilityPK = availabilityPK;
    }

    public Availability(AvailabilityPK availabilityPK, Date endTime) {
        this.availabilityPK = availabilityPK;
        this.endTime = endTime;
    }

    public Availability(Date startTime, String initialsWorkingDay, String idDocument, String documentNumber, String nameDay) {
        this.availabilityPK = new AvailabilityPK(startTime, initialsWorkingDay, idDocument, documentNumber, nameDay);
    }

    public AvailabilityPK getAvailabilityPK() {
        return availabilityPK;
    }

    public void setAvailabilityPK(AvailabilityPK availabilityPK) {
        this.availabilityPK = availabilityPK;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Availability[ availabilityPK=" + availabilityPK + " ]";
    }
    
}
