/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name = "disponibility")
@NamedQueries({
    @NamedQuery(name = "Disponibility.findAll", query = "SELECT d FROM Disponibility d")
    , @NamedQuery(name = "Disponibility.findByDocument", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.document = :document")
    , @NamedQuery(name = "Disponibility.findByLikeDocument", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.document like :document")
    , @NamedQuery(name = "Disponibility.findByDocumentNumber", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.documentNumber = :documentNumber")
    , @NamedQuery(name = "Disponibility.findByLikeDocumentNumber", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.documentNumber like :documentNumber")
    , @NamedQuery(name = "Disponibility.findByStartHour", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.startHour = :startHour")
    , @NamedQuery(name = "Disponibility.findByLikeStartHour", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.startHour like :startHour")
    , @NamedQuery(name = "Disponibility.findByEndHour", query = "SELECT d FROM Disponibility d WHERE d.endHour = :endHour")
    , @NamedQuery(name = "Disponibility.findByLikeEndHour", query = "SELECT d FROM Disponibility d WHERE d.endHour like :endHour")
    , @NamedQuery(name = "Disponibility.findByNameDay", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.nameDay = :nameDay")
    , @NamedQuery(name = "Disponibility.findByLikeNameDay", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.nameDay like :nameDay")
    , @NamedQuery(name = "Disponibility.findByWorkingDayInitials", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.workingDayInitials = :workingDayInitials")
    , @NamedQuery(name = "Disponibility.findByLikeWorkingDayInitials", query = "SELECT d FROM Disponibility d WHERE d.disponibilityPK.workingDayInitials like :workingDayInitials")
, @NamedQuery(name = "Disponibility.updatePrimaryKey", query = "UPDATE Disponibility d set d.disponibilityPK.startHour = :newStartHour, d.disponibilityPK.nameDay = :newNameDay, d.disponibilityPK.workingDayInitials = :newWorkingDayInitials, d.disponibilityPK.document = :newDocument, d.disponibilityPK.documentNumber = :newDocumentNumber WHERE d.disponibilityPK.startHour = :oldStartHour and d.disponibilityPK.nameDay = :oldNameDay and d.disponibilityPK.workingDayInitials = :oldWorkingDayInitials and d.disponibilityPK.document = :oldDocument and d.disponibilityPK.documentNumber = :oldDocumentNumber")})

public class Disponibility implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisponibilityPK disponibilityPK;
    @Column(name = "end_hour")
    @Temporal(TemporalType.TIME)
    private Date endHour;
    @JoinColumn(name = "name_day", referencedColumnName = "name_day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "document_number", referencedColumnName = "document_number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "working_day_initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Disponibility() {
    }

    public Disponibility(DisponibilityPK disponibilityPK) {
        this.disponibilityPK = disponibilityPK;
    }

    public Disponibility(String document, String documentNumber, Date startHour, String nameDay, String workingDayInitials) {
        this.disponibilityPK = new DisponibilityPK(document, documentNumber, startHour, nameDay, workingDayInitials);
    }

    public DisponibilityPK getDisponibilityPK() {
        return disponibilityPK;
    }

    public void setDisponibilityPK(DisponibilityPK disponibilityPK) {
        this.disponibilityPK = disponibilityPK;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
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
        hash += (disponibilityPK != null ? disponibilityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibility)) {
            return false;
        }
        Disponibility other = (Disponibility) object;
        if ((this.disponibilityPK == null && other.disponibilityPK != null) || (this.disponibilityPK != null && !this.disponibilityPK.equals(other.disponibilityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Disponibility[ disponibilityPK=" + disponibilityPK + " ]";
    }

}
