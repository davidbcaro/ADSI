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
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "start_hour", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startHour;
    @Basic(optional = false)
    @Column(name = "id_version", nullable = false)
    private int idVersion;
    @Basic(optional = false)
    @Column(name = "name_day", nullable = false, length = 10)
    private String nameDay;
    @Basic(optional = false)
    @Column(name = "id_trimester_current", nullable = false, length = 10)
    private String idTrimesterCurrent;
    @Basic(optional = false)
    @Column(name = "number_environment", nullable = false, length = 50)
    private String numberEnvironment;
    @Basic(optional = false)
    @Column(name = "name_headquartes", nullable = false, length = 100)
    private String nameHeadquartes;
    @Basic(optional = false)
    @Column(name = "number_group", nullable = false, length = 100)
    private String numberGroup;
    @Basic(optional = false)
    @Column(name = "name_trimester", nullable = false, length = 20)
    private String nameTrimester;
    @Basic(optional = false)
    @Column(name = "working_day_initials", nullable = false, length = 10)
    private String workingDayInitials;
    @Basic(optional = false)
    @Column(name = "document_number", nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;
    @Basic(optional = false)
    @Column(name = "level_formation", nullable = false, length = 50)
    private String levelFormation;

    public SchedulePK() {
    }

    public SchedulePK(Date startHour, int idVersion, String nameDay, String idTrimesterCurrent, String numberEnvironment, String nameHeadquartes, String numberGroup, String nameTrimester, String workingDayInitials, String documentNumber, String document, String levelFormation) {
        this.startHour = startHour;
        this.idVersion = idVersion;
        this.nameDay = nameDay;
        this.idTrimesterCurrent = idTrimesterCurrent;
        this.numberEnvironment = numberEnvironment;
        this.nameHeadquartes = nameHeadquartes;
        this.numberGroup = numberGroup;
        this.nameTrimester = nameTrimester;
        this.workingDayInitials = workingDayInitials;
        this.documentNumber = documentNumber;
        this.document = document;
        this.levelFormation = levelFormation;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getIdTrimesterCurrent() {
        return idTrimesterCurrent;
    }

    public void setIdTrimesterCurrent(String idTrimesterCurrent) {
        this.idTrimesterCurrent = idTrimesterCurrent;
    }

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getNameHeadquartes() {
        return nameHeadquartes;
    }

    public void setNameHeadquartes(String nameHeadquartes) {
        this.nameHeadquartes = nameHeadquartes;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public String getNameTrimester() {
        return nameTrimester;
    }

    public void setNameTrimester(String nameTrimester) {
        this.nameTrimester = nameTrimester;
    }

    public String getWorkingDayInitials() {
        return workingDayInitials;
    }

    public void setWorkingDayInitials(String workingDayInitials) {
        this.workingDayInitials = workingDayInitials;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getLevelFormation() {
        return levelFormation;
    }

    public void setLevelFormation(String levelFormation) {
        this.levelFormation = levelFormation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (startHour != null ? startHour.hashCode() : 0);
        hash += (int) idVersion;
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        hash += (idTrimesterCurrent != null ? idTrimesterCurrent.hashCode() : 0);
        hash += (numberEnvironment != null ? numberEnvironment.hashCode() : 0);
        hash += (nameHeadquartes != null ? nameHeadquartes.hashCode() : 0);
        hash += (numberGroup != null ? numberGroup.hashCode() : 0);
        hash += (nameTrimester != null ? nameTrimester.hashCode() : 0);
        hash += (workingDayInitials != null ? workingDayInitials.hashCode() : 0);
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        hash += (document != null ? document.hashCode() : 0);
        hash += (levelFormation != null ? levelFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulePK)) {
            return false;
        }
        SchedulePK other = (SchedulePK) object;
        if ((this.startHour == null && other.startHour != null) || (this.startHour != null && !this.startHour.equals(other.startHour))) {
            return false;
        }
        if (this.idVersion != other.idVersion) {
            return false;
        }
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        if ((this.idTrimesterCurrent == null && other.idTrimesterCurrent != null) || (this.idTrimesterCurrent != null && !this.idTrimesterCurrent.equals(other.idTrimesterCurrent))) {
            return false;
        }
        if ((this.numberEnvironment == null && other.numberEnvironment != null) || (this.numberEnvironment != null && !this.numberEnvironment.equals(other.numberEnvironment))) {
            return false;
        }
        if ((this.nameHeadquartes == null && other.nameHeadquartes != null) || (this.nameHeadquartes != null && !this.nameHeadquartes.equals(other.nameHeadquartes))) {
            return false;
        }
        if ((this.numberGroup == null && other.numberGroup != null) || (this.numberGroup != null && !this.numberGroup.equals(other.numberGroup))) {
            return false;
        }
        if ((this.nameTrimester == null && other.nameTrimester != null) || (this.nameTrimester != null && !this.nameTrimester.equals(other.nameTrimester))) {
            return false;
        }
        if ((this.workingDayInitials == null && other.workingDayInitials != null) || (this.workingDayInitials != null && !this.workingDayInitials.equals(other.workingDayInitials))) {
            return false;
        }
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        if ((this.levelFormation == null && other.levelFormation != null) || (this.levelFormation != null && !this.levelFormation.equals(other.levelFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.SchedulePK[ startHour=" + startHour + ", idVersion=" + idVersion + ", nameDay=" + nameDay + ", idTrimesterCurrent=" + idTrimesterCurrent + ", numberEnvironment=" + numberEnvironment + ", nameHeadquartes=" + nameHeadquartes + ", numberGroup=" + numberGroup + ", nameTrimester=" + nameTrimester + ", workingDayInitials=" + workingDayInitials + ", documentNumber=" + documentNumber + ", document=" + document + ", levelFormation=" + levelFormation + " ]";
    }
    
}
