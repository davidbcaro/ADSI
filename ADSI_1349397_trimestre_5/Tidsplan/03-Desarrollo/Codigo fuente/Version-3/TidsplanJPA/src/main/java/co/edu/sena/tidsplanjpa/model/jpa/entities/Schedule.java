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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "schedule", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"start_hour", "id_version", "name_day", "id_trimester_current", "number_environment", "name_headquartes", "number_group", "name_trimester", "working_day_initials", "document_number", "document", "level_formation"})})
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findByStartHour", query = "SELECT s FROM Schedule s WHERE s.schedulePK.startHour = :startHour")
    , @NamedQuery(name = "Schedule.findByEndHour", query = "SELECT s FROM Schedule s WHERE s.endHour = :endHour")
    , @NamedQuery(name = "Schedule.findByIdVersion", query = "SELECT s FROM Schedule s WHERE s.schedulePK.idVersion = :idVersion")
    , @NamedQuery(name = "Schedule.findByNameDay", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameDay = :nameDay")
    , @NamedQuery(name = "Schedule.findByIdTrimesterCurrent", query = "SELECT s FROM Schedule s WHERE s.schedulePK.idTrimesterCurrent = :idTrimesterCurrent")
    , @NamedQuery(name = "Schedule.findByNumberEnvironment", query = "SELECT s FROM Schedule s WHERE s.schedulePK.numberEnvironment = :numberEnvironment")
    , @NamedQuery(name = "Schedule.findByNameHeadquartes", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameHeadquartes = :nameHeadquartes")
    , @NamedQuery(name = "Schedule.findByNumberGroup", query = "SELECT s FROM Schedule s WHERE s.schedulePK.numberGroup = :numberGroup")
    , @NamedQuery(name = "Schedule.findByNameTrimester", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameTrimester = :nameTrimester")
    , @NamedQuery(name = "Schedule.findByWorkingDayInitials", query = "SELECT s FROM Schedule s WHERE s.schedulePK.workingDayInitials = :workingDayInitials")
    , @NamedQuery(name = "Schedule.findByDocumentNumber", query = "SELECT s FROM Schedule s WHERE s.schedulePK.documentNumber = :documentNumber")
    , @NamedQuery(name = "Schedule.findByDocument", query = "SELECT s FROM Schedule s WHERE s.schedulePK.document = :document")
    , @NamedQuery(name = "Schedule.findByLevelFormation", query = "SELECT s FROM Schedule s WHERE s.schedulePK.levelFormation = :levelFormation")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulePK schedulePK;
    @Basic(optional = false)
    @Column(name = "end_hour", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endHour;
    @JoinColumn(name = "name_day", referencedColumnName = "name_day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "number_environment", referencedColumnName = "number_environment", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "name_headquartes", referencedColumnName = "name_headquartes", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Environment environment;
    @JoinColumns({
        @JoinColumn(name = "number_group", referencedColumnName = "number_group", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "name_trimester", referencedColumnName = "name_trimester", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "working_day_initials", referencedColumnName = "workingday_initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GroupHasTrimester groupHasTrimester;
    @JoinColumns({
        @JoinColumn(name = "document_number", referencedColumnName = "document_number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "name_modality", referencedColumnName = "name_modality", nullable = false)
    @ManyToOne(optional = false)
    private Modality nameModality;
    @JoinColumns({
        @JoinColumn(name = "id_version", referencedColumnName = "id_version", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_trimester_current", referencedColumnName = "id_trimester_current", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Version version;

    public Schedule() {
    }

    public Schedule(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Schedule(SchedulePK schedulePK, Date endHour) {
        this.schedulePK = schedulePK;
        this.endHour = endHour;
    }

    public Schedule(Date startHour, int idVersion, String nameDay, String idTrimesterCurrent, String numberEnvironment, String nameHeadquartes, String numberGroup, String nameTrimester, String workingDayInitials, String documentNumber, String document, String levelFormation) {
        this.schedulePK = new SchedulePK(startHour, idVersion, nameDay, idTrimesterCurrent, numberEnvironment, nameHeadquartes, numberGroup, nameTrimester, workingDayInitials, documentNumber, document, levelFormation);
    }

    public SchedulePK getSchedulePK() {
        return schedulePK;
    }

    public void setSchedulePK(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
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

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public GroupHasTrimester getGroupHasTrimester() {
        return groupHasTrimester;
    }

    public void setGroupHasTrimester(GroupHasTrimester groupHasTrimester) {
        this.groupHasTrimester = groupHasTrimester;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Modality getNameModality() {
        return nameModality;
    }

    public void setNameModality(Modality nameModality) {
        this.nameModality = nameModality;
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
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Schedule[ schedulePK=" + schedulePK + " ]";
    }
    
}
