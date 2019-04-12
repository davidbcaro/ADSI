/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "schedule", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"document_Number", "id_Document", "name_Day", "number_Ambience", "name_Headquarters", "number_Ficha", "quarter_Name", "acronyms_Working_Day", "speciality_Name", "idVersion", "idCurrent_Quarter"})})
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulePK schedulePK;
    @Basic(optional = false)
    @Column(name = "start_Time", nullable = false, length = 20)
    private String startTime;
    @Basic(optional = false)
    @Column(name = "end_Time", nullable = false, length = 10)
    private String endTime;
    @JoinColumns({
        @JoinColumn(name = "name_Headquarters", referencedColumnName = "name_Headquarters", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "number_Ambience", referencedColumnName = "number_Ambience", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ambience ambience;
    @JoinColumn(name = "name_Day", referencedColumnName = "name_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "number_Ficha", referencedColumnName = "number_Ficha", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "quarter_Name", referencedColumnName = "quarter_Name", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "acronyms_Working_Day", referencedColumnName = "acronyms_working_Day", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "speciality_Name", referencedColumnName = "speciality_Name", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private FichaHasTrimester fichaHasTrimester;
    @JoinColumns({
        @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "modality_Name", referencedColumnName = "modality_Name", nullable = false)
    @ManyToOne(optional = false)
    private Modality modalityName;
    @JoinColumns({
        @JoinColumn(name = "idCurrent_Quarter", referencedColumnName = "idCurrent_Quarter", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "idVersion", referencedColumnName = "idVersion", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Version version;

    public Schedule() {
    }

    public Schedule(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Schedule(SchedulePK schedulePK, String startTime, String endTime) {
        this.schedulePK = schedulePK;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Schedule(String documentNumber, String idDocument, String nameDay, String numberAmbience, String nameHeadquarters, String numberFicha, String quarterName, String acronymsWorkingDay, String specialityName, int idVersion, String idCurrentQuarter) {
        this.schedulePK = new SchedulePK(documentNumber, idDocument, nameDay, numberAmbience, nameHeadquarters, numberFicha, quarterName, acronymsWorkingDay, specialityName, idVersion, idCurrentQuarter);
    }

    public SchedulePK getSchedulePK() {
        return schedulePK;
    }

    public void setSchedulePK(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Ambience getAmbience() {
        return ambience;
    }

    public void setAmbience(Ambience ambience) {
        this.ambience = ambience;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public FichaHasTrimester getFichaHasTrimester() {
        return fichaHasTrimester;
    }

    public void setFichaHasTrimester(FichaHasTrimester fichaHasTrimester) {
        this.fichaHasTrimester = fichaHasTrimester;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Modality getModalityName() {
        return modalityName;
    }

    public void setModalityName(Modality modalityName) {
        this.modalityName = modalityName;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schedulePK != null ? schedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.schedulePK == null && other.schedulePK != null) || (this.schedulePK != null && !this.schedulePK.equals(other.schedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Schedule[ schedulePK=" + schedulePK + " ]";
    }
    
}
