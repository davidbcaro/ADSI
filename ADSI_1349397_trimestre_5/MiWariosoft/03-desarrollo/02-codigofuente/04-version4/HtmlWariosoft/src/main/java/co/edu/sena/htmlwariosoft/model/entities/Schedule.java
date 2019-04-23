/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "schedule", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_Document", "document_Number", "number_Environment", "name_Headquarters", "id_Version", "id_Current_Quarter", "name_Day", "number_Group", "name_Trimester", "initials_Working_Day", "training_Level"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findByStartTime", query = "SELECT s FROM Schedule s WHERE s.startTime = :startTime")
    , @NamedQuery(name = "Schedule.findByEndTime", query = "SELECT s FROM Schedule s WHERE s.endTime = :endTime")
    , @NamedQuery(name = "Schedule.findByNameTrimester", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameTrimester = :nameTrimester")
    , @NamedQuery(name = "Schedule.findByNumberGroup", query = "SELECT s FROM Schedule s WHERE s.schedulePK.numberGroup = :numberGroup")
    , @NamedQuery(name = "Schedule.findByInitialsWorkingDay", query = "SELECT s FROM Schedule s WHERE s.schedulePK.initialsWorkingDay = :initialsWorkingDay")
    , @NamedQuery(name = "Schedule.findByDocumentNumber", query = "SELECT s FROM Schedule s WHERE s.schedulePK.documentNumber = :documentNumber")
    , @NamedQuery(name = "Schedule.findByIdDocument", query = "SELECT s FROM Schedule s WHERE s.schedulePK.idDocument = :idDocument")
    , @NamedQuery(name = "Schedule.findByNameDay", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameDay = :nameDay")
    , @NamedQuery(name = "Schedule.findByNumberEnvironment", query = "SELECT s FROM Schedule s WHERE s.schedulePK.numberEnvironment = :numberEnvironment")
    , @NamedQuery(name = "Schedule.findByNameHeadquarters", query = "SELECT s FROM Schedule s WHERE s.schedulePK.nameHeadquarters = :nameHeadquarters")
    , @NamedQuery(name = "Schedule.findByIdVersion", query = "SELECT s FROM Schedule s WHERE s.schedulePK.idVersion = :idVersion")
    , @NamedQuery(name = "Schedule.findByIdCurrentQuarter", query = "SELECT s FROM Schedule s WHERE s.schedulePK.idCurrentQuarter = :idCurrentQuarter")
    , @NamedQuery(name = "Schedule.findByTrainingLevel", query = "SELECT s FROM Schedule s WHERE s.schedulePK.trainingLevel = :trainingLevel")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulePK schedulePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "start_Time", nullable = false, length = 15)
    private String startTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "end_Time", nullable = false, length = 15)
    private String endTime;
    @JoinColumn(name = "name_Day", referencedColumnName = "name_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Day day;
    @JoinColumns({
        @JoinColumn(name = "number_Environment", referencedColumnName = "number_Environment", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "name_Headquarters", referencedColumnName = "name_Headquarters", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Environment environment;
    @JoinColumn(name = "name_Modality", referencedColumnName = "name_Modality")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modality nameModality;
    @JoinColumns({
        @JoinColumn(name = "number_Group", referencedColumnName = "number_Group", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "name_Trimester", referencedColumnName = "name_Trimester", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "initials_Working_Day", referencedColumnName = "initials_Working_Day", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "training_Level", referencedColumnName = "training_Level", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NumberGroupHasTrimester numberGroupHasTrimester;
    @JoinColumns({
        @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Teacher teacher;
    @JoinColumns({
        @JoinColumn(name = "id_Version", referencedColumnName = "id_Version", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_Current_Quarter", referencedColumnName = "id_Current_Quarter", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

    public Schedule(String nameTrimester, String numberGroup, String initialsWorkingDay, String documentNumber, String idDocument, String nameDay, String numberEnvironment, String nameHeadquarters, int idVersion, String idCurrentQuarter, String trainingLevel) {
        this.schedulePK = new SchedulePK(nameTrimester, numberGroup, initialsWorkingDay, documentNumber, idDocument, nameDay, numberEnvironment, nameHeadquarters, idVersion, idCurrentQuarter, trainingLevel);
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

    public Modality getNameModality() {
        return nameModality;
    }

    public void setNameModality(Modality nameModality) {
        this.nameModality = nameModality;
    }

    public NumberGroupHasTrimester getNumberGroupHasTrimester() {
        return numberGroupHasTrimester;
    }

    public void setNumberGroupHasTrimester(NumberGroupHasTrimester numberGroupHasTrimester) {
        this.numberGroupHasTrimester = numberGroupHasTrimester;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        return "co.edu.sena.htmlwariosoft.model.entities.Schedule[ schedulePK=" + schedulePK + " ]";
    }
    
}
