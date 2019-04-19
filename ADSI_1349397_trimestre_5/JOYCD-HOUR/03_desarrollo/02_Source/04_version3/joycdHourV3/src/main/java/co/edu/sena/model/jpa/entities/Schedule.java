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
    @UniqueConstraint(columnNames = {"version", "version_actuality_trimester", "number_environment", "headquarters_name", "name_day", "document_type", "identification_card_number", "groups_number", "trimester_name", "working_day_initials", "level_formation"})})
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    // hourStart
    , @NamedQuery(name = "Schedule.findByHourStart", query = "SELECT s FROM Schedule s WHERE s.hourStart = :hourStart")
    , @NamedQuery(name = "Schedule.findByLikeHourStart", query = "SELECT s FROM Schedule s WHERE s.hourStart LIKE :hourStart")
    // hourEnd
    , @NamedQuery(name = "Schedule.findByHourEnd", query = "SELECT s FROM Schedule s WHERE s.hourEnd = :hourEnd")
    , @NamedQuery(name = "Schedule.findByLikeHourEnd", query = "SELECT s FROM Schedule s WHERE s.hourEnd LIKE :hourEnd")
    //ScheduleFinish ENTERO query nativo
    , @NamedQuery(name = "Schedule.findByScheduleFinish", query = "SELECT s FROM Schedule s WHERE s.scheduleFinish = :scheduleFinish")
    // version ENTERO query nativo
    , @NamedQuery(name = "Schedule.findByVersion", query = "SELECT s FROM Schedule s WHERE s.schedulePK.version = :version")
    //actualityTrimester
    , @NamedQuery(name = "Schedule.findByVersionActualityTrimester", query = "SELECT s FROM Schedule s WHERE s.schedulePK.versionActualityTrimester = :versionActualityTrimester")
    , @NamedQuery(name = "Schedule.findByLikeVersionActualityTrimester", query = "SELECT s FROM Schedule s WHERE s.schedulePK.versionActualityTrimester LIKE :versionActualityTrimester")
    // numberEnvironment ENTERO query nativo
    , @NamedQuery(name = "Schedule.findByNumberEnvironment", query = "SELECT s FROM Schedule s WHERE s.schedulePK.numberEnvironment = :numberEnvironment")
    // HeadquartersName
    , @NamedQuery(name = "Schedule.findByHeadquartersName", query = "SELECT s FROM Schedule s WHERE s.schedulePK.headquartersName = :headquartersName")
    , @NamedQuery(name = "Schedule.findByLikeHeadquartersName", query = "SELECT s FROM Schedule s WHERE s.schedulePK.headquartersName LIKE :headquartersName")
    //NameDay
    , @NamedQuery(name = "Schedule.findByNameDay", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameDay = :nameDay")
    , @NamedQuery(name = "Schedule.findByLikeNameDay", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameDay LIKE :nameDay")
    //DocumentType
    , @NamedQuery(name = "Schedule.findByDocumentType", query = "SELECT s FROM Schedule s WHERE s.schedulePK.documentType = :documentType")
    , @NamedQuery(name = "Schedule.findByLikeDocumentType", query = "SELECT s FROM Schedule s WHERE s.schedulePK.documentType LIKE :documentType")
    //identificationCardNumber
    , @NamedQuery(name = "Schedule.findByIdentificationCardNumber", query = "SELECT s FROM Schedule s WHERE s.schedulePK.identificationCardNumber = :identificationCardNumber")
    , @NamedQuery(name = "Schedule.findByLikeIdentificationCardNumber", query = "SELECT s FROM Schedule s WHERE s.schedulePK.identificationCardNumber LIKE :identificationCardNumber")
    //Grupsnumber
    , @NamedQuery(name = "Schedule.findByGroupsNumber", query = "SELECT s FROM Schedule s WHERE s.schedulePK.groupsNumber = :groupsNumber")
    , @NamedQuery(name = "Schedule.findByLikeGroupsNumber", query = "SELECT s FROM Schedule s WHERE s.schedulePK.groupsNumber LIKE :groupsNumber")
    //TrimesterName ENTERO query nativo
    , @NamedQuery(name = "Schedule.findByTrimesterName", query = "SELECT s FROM Schedule s WHERE s.schedulePK.trimesterName = :trimesterName")
    //WorkingDayinitials
    , @NamedQuery(name = "Schedule.findByWorkingDayInitials", query = "SELECT s FROM Schedule s WHERE s.schedulePK.workingDayInitials = :workingDayInitials")
    , @NamedQuery(name = "Schedule.findByLikeWorkingDayInitials", query = "SELECT s FROM Schedule s WHERE s.schedulePK.workingDayInitials LIKE :workingDayInitials")
    //LevelFormation
    , @NamedQuery(name = "Schedule.findByLevelFormation", query = "SELECT s FROM Schedule s WHERE s.schedulePK.levelFormation = :levelFormation")
    , @NamedQuery(name = "Schedule.findByLikeLevelFormation", query = "SELECT s FROM Schedule s WHERE s.schedulePK.levelFormation LIKE :levelFormation")
    //nameModality
    , @NamedQuery(name = "Schedule.findByNameModality", query = "SELECT s FROM Schedule s WHERE s.nameModality = :nameModality")
    , @NamedQuery(name = "Schedule.findByLikeNameModality", query = "SELECT s FROM Schedule s WHERE s.nameModality = :nameModality")
    //Update
   ,@NamedQuery(name= "Schedule.updatePrimaryKey", query = "UPDATE Schedule s set s.schedulePK.documentType = :documentTypeNew,  s.schedulePK.groupsNumber = :groupsNumberNew, s.schedulePK.headquartersName = :headquartersNameNew, s.schedulePK.identificationCardNumber = :identificationCardNumberNew, s.schedulePK.levelFormation = :levelFormationNew, s.schedulePK.nameDay = :nameDayNew, s.schedulePK.numberEnvironment = :numberEnvironmentNew, s.schedulePK.trimesterName = :trimesterNameNew, s.schedulePK.version = :versionNew, s.schedulePK.versionActualityTrimester = :versionActualityTrimesterNew , s.schedulePK.workingDayInitials = :workingDayInitialsNew WHERE s.schedulePK.documentType = :documentTypeOld and  s.schedulePK.groupsNumber = :groupsNumberOld and s.schedulePK.headquartersName = :headquartersNameOld and s.schedulePK.identificationCardNumber = :identificationCardNumberOld and s.schedulePK.levelFormation = :levelFormationOld and s.schedulePK.nameDay = :nameDayOld and s.schedulePK.numberEnvironment = :numberEnvironmentOld and s.schedulePK.trimesterName = :trimesterNameOld and s.schedulePK.version = :versionOld and s.schedulePK.versionActualityTrimester = :versionActualityTrimesterOld and s.schedulePK.workingDayInitials = :workingDayInitialsOld")
        
})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulePK schedulePK;
    @Basic(optional = false)
    @Column(name = "hour_start", nullable = false, length = 45)
    private String hourStart;
    @Basic(optional = false)
    @Column(name = "hour_end", nullable = false, length = 45)
    private String hourEnd;
    @Basic(optional = false)
    @Column(name = "schedule_finish", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date scheduleFinish;
    @JoinColumn(name = "name_day", referencedColumnName = "name_day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "number_environment", referencedColumnName = "number_environment", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "headquarters_name", referencedColumnName = "headquarters_name", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Environment environment;
    @JoinColumns({
        @JoinColumn(name = "groups_number", referencedColumnName = "groups_number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "trimester_name", referencedColumnName = "trimester_name", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "working_day_initials", referencedColumnName = "working_day_initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GroupNumberHasTrimester groupNumberHasTrimester;
    @JoinColumns({
        @JoinColumn(name = "document_type", referencedColumnName = "document_type", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "identification_card_number", referencedColumnName = "identification_card", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor;
    @JoinColumn(name = "name_modality", referencedColumnName = "name_modality", nullable = false)
    @ManyToOne(optional = false)
    private Modality nameModality;
    @JoinColumns({
        @JoinColumn(name = "version", referencedColumnName = "version", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "version_actuality_trimester", referencedColumnName = "actuality_trimester", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private VersionSchedule versionSchedule;

    public Schedule() {
    }

    public Schedule(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Schedule(SchedulePK schedulePK, String hourStart, String hourEnd, Date scheduleFinish) {
        this.schedulePK = schedulePK;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.scheduleFinish = scheduleFinish;
    }

    public Schedule(int version, String versionActualityTrimester, String numberEnvironment, String headquartersName, String nameDay, String documentType, String identificationCardNumber, String groupsNumber, String trimesterName, String workingDayInitials, String levelFormation) {
        this.schedulePK = new SchedulePK(version, versionActualityTrimester, numberEnvironment, headquartersName, nameDay, documentType, identificationCardNumber, groupsNumber, trimesterName, workingDayInitials, levelFormation);
    }

    public SchedulePK getSchedulePK() {
        return schedulePK;
    }

    public void setSchedulePK(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Date getScheduleFinish() {
        return scheduleFinish;
    }

    public void setScheduleFinish(Date scheduleFinish) {
        this.scheduleFinish = scheduleFinish;
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

    public GroupNumberHasTrimester getGroupNumberHasTrimester() {
        return groupNumberHasTrimester;
    }

    public void setGroupNumberHasTrimester(GroupNumberHasTrimester groupNumberHasTrimester) {
        this.groupNumberHasTrimester = groupNumberHasTrimester;
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

    public VersionSchedule getVersionSchedule() {
        return versionSchedule;
    }

    public void setVersionSchedule(VersionSchedule versionSchedule) {
        this.versionSchedule = versionSchedule;
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
        return "co.edu.sena.model.jpa.entities.Schedule[ schedulePK=" + schedulePK + " ]";
    }

}
