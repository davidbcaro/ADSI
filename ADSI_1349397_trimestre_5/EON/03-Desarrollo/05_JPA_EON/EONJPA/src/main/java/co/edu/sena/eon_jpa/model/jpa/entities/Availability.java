/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    @NamedQuery(name = "Availability.findAll", query = "SELECT a.availabilityPK.startTime FROM Availability a")
    ,@NamedQuery(name = "Availability.findByStartTime", query = "SELECT a FROM Availability a WHERE a.availabilityPK.startTime = :startTime")
    ,@NamedQuery(name = "Availability.findByEndTime", query = "SELECT a FROM Availability a WHERE a.endTime = :endTime")
    ,@NamedQuery(name = "Availability.findByIdDocument", query = "SELECT a FROM Availability a WHERE a.availabilityPK.idDocument = :idDocument")
    ,@NamedQuery(name = "Availability.findByDocumentNumber", query = "SELECT a FROM Availability a WHERE a.availabilityPK.documentNumber = :documentNumber")
    ,@NamedQuery(name = "Availability.findByAcronymsWorkingDay", query = "SELECT a FROM Availability a WHERE a.availabilityPK.acronymsWorkingDay = :acronymsWorkingDay")
    ,@NamedQuery(name = "Availability.findByNameDay", query = "SELECT a FROM Availability a WHERE a.availabilityPK.nameDay = :nameDay")        
    ,@NamedQuery(name = "Availability.findByLikeStarTime", query = "SELECT a FROM Availability a WHERE a.availabilityPK.startTime LIKE :startTime")     
    ,@NamedQuery(name = "Availability.findByLikeEndTime", query = "SELECT a FROM Availability a WHERE a.endTime LIKE :endTime")
    ,@NamedQuery(name = "Availability.findByLikeIdDocument", query = "SELECT a FROM Availability a WHERE a.availabilityPK.idDocument LIKE :idDocument")
    ,@NamedQuery(name = "Availability.findBylikeDocumentNumber", query = "SELECT a FROM Availability a WHERE a.availabilityPK.documentNumber LIKE :documentNumber")
    ,@NamedQuery(name = "Availability.findByLikeAcronymsWorkingDay", query = "SELECT a FROM Availability a WHERE a.availabilityPK.acronymsWorkingDay LIKE :acronymsWorkingDay")
    ,@NamedQuery(name = "Availability.findByLikeNameDay", query = "SELECT a FROM Availability a WHERE a.availabilityPK.nameDay LIKE :nameDay")
    ,@NamedQuery(name = "Availability.UpdatePrimaryKey", query = "UPDATE Availability a set a.availabilityPK.documentNumber = :newdocumentNumber,  a.availabilityPK.idDocument = :newidDocument,  a.availabilityPK.startTime = :newstartTime,  a.availabilityPK.acronymsWorkingDay = :newacronymsWorkingDay,  a.availabilityPK.nameDay = :newnameDay WHERE a.availabilityPK.documentNumber = :olddocumentNumber and a.availabilityPK.idDocument = :oldidDocument and a.availabilityPK.startTime = :oldstartTime and a.availabilityPK.acronymsWorkingDay = :oldacronymsWorkingDay and a.availabilityPK.nameDay = :oldnameDay")
})

public class Availability implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvailabilityPK availabilityPK;
    @Column(name = "end_Time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @JoinColumn(name = "name_Day", referencedColumnName = "name_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "acronyms_Working_Day", referencedColumnName = "acronyms_Working_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Availability() {
    }

    public Availability(AvailabilityPK availabilityPK) {
        this.availabilityPK = availabilityPK;
    }

    public Availability(String documentNumber, String idDocument, Date startTime, String acronymsWorkingDay, String nameDay) {
        this.availabilityPK = new AvailabilityPK(documentNumber, idDocument, startTime, acronymsWorkingDay, nameDay);
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Availability[ availabilityPK=" + availabilityPK + " ]";
    }
    
}
