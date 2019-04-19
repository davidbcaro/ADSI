/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;
    @Basic(optional = false)
    @Column(name = "version_actuality_trimester", nullable = false, length = 12)
    private String versionActualityTrimester;
    @Basic(optional = false)
    @Column(name = "number_environment", nullable = false, length = 45)
    private String numberEnvironment;
    @Basic(optional = false)
    @Column(name = "headquarters_name", nullable = false, length = 100)
    private String headquartersName;
    @Basic(optional = false)
    @Column(name = "name_day", nullable = false, length = 10)
    private String nameDay;
    @Basic(optional = false)
    @Column(name = "document_type", nullable = false, length = 25)
    private String documentType;
    @Basic(optional = false)
    @Column(name = "identification_card_number", nullable = false, length = 10)
    private String identificationCardNumber;
    @Basic(optional = false)
    @Column(name = "groups_number", nullable = false, length = 20)
    private String groupsNumber;
    @Basic(optional = false)
    @Column(name = "trimester_name", nullable = false, length = 15)
    private String trimesterName;
    @Basic(optional = false)
    @Column(name = "working_day_initials", nullable = false, length = 10)
    private String workingDayInitials;
    @Basic(optional = false)
    @Column(name = "level_formation", nullable = false, length = 20)
    private String levelFormation;

    public SchedulePK() {
    }

    public SchedulePK(int version, String versionActualityTrimester, String numberEnvironment, String headquartersName, String nameDay, String documentType, String identificationCardNumber, String groupsNumber, String trimesterName, String workingDayInitials, String levelFormation) {
        this.version = version;
        this.versionActualityTrimester = versionActualityTrimester;
        this.numberEnvironment = numberEnvironment;
        this.headquartersName = headquartersName;
        this.nameDay = nameDay;
        this.documentType = documentType;
        this.identificationCardNumber = identificationCardNumber;
        this.groupsNumber = groupsNumber;
        this.trimesterName = trimesterName;
        this.workingDayInitials = workingDayInitials;
        this.levelFormation = levelFormation;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getVersionActualityTrimester() {
        return versionActualityTrimester;
    }

    public void setVersionActualityTrimester(String versionActualityTrimester) {
        this.versionActualityTrimester = versionActualityTrimester;
    }

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getHeadquartersName() {
        return headquartersName;
    }

    public void setHeadquartersName(String headquartersName) {
        this.headquartersName = headquartersName;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdentificationCardNumber() {
        return identificationCardNumber;
    }

    public void setIdentificationCardNumber(String identificationCardNumber) {
        this.identificationCardNumber = identificationCardNumber;
    }

    public String getGroupsNumber() {
        return groupsNumber;
    }

    public void setGroupsNumber(String groupsNumber) {
        this.groupsNumber = groupsNumber;
    }

    public String getTrimesterName() {
        return trimesterName;
    }

    public void setTrimesterName(String trimesterName) {
        this.trimesterName = trimesterName;
    }

    public String getWorkingDayInitials() {
        return workingDayInitials;
    }

    public void setWorkingDayInitials(String workingDayInitials) {
        this.workingDayInitials = workingDayInitials;
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
        hash += (int) version;
        hash += (versionActualityTrimester != null ? versionActualityTrimester.hashCode() : 0);
        hash += (numberEnvironment != null ? numberEnvironment.hashCode() : 0);
        hash += (headquartersName != null ? headquartersName.hashCode() : 0);
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        hash += (documentType != null ? documentType.hashCode() : 0);
        hash += (identificationCardNumber != null ? identificationCardNumber.hashCode() : 0);
        hash += (groupsNumber != null ? groupsNumber.hashCode() : 0);
        hash += (trimesterName != null ? trimesterName.hashCode() : 0);
        hash += (workingDayInitials != null ? workingDayInitials.hashCode() : 0);
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
        if (this.version != other.version) {
            return false;
        }
        if ((this.versionActualityTrimester == null && other.versionActualityTrimester != null) || (this.versionActualityTrimester != null && !this.versionActualityTrimester.equals(other.versionActualityTrimester))) {
            return false;
        }
        if ((this.numberEnvironment == null && other.numberEnvironment != null) || (this.numberEnvironment != null && !this.numberEnvironment.equals(other.numberEnvironment))) {
            return false;
        }
        if ((this.headquartersName == null && other.headquartersName != null) || (this.headquartersName != null && !this.headquartersName.equals(other.headquartersName))) {
            return false;
        }
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        if ((this.documentType == null && other.documentType != null) || (this.documentType != null && !this.documentType.equals(other.documentType))) {
            return false;
        }
        if ((this.identificationCardNumber == null && other.identificationCardNumber != null) || (this.identificationCardNumber != null && !this.identificationCardNumber.equals(other.identificationCardNumber))) {
            return false;
        }
        if ((this.groupsNumber == null && other.groupsNumber != null) || (this.groupsNumber != null && !this.groupsNumber.equals(other.groupsNumber))) {
            return false;
        }
        if ((this.trimesterName == null && other.trimesterName != null) || (this.trimesterName != null && !this.trimesterName.equals(other.trimesterName))) {
            return false;
        }
        if ((this.workingDayInitials == null && other.workingDayInitials != null) || (this.workingDayInitials != null && !this.workingDayInitials.equals(other.workingDayInitials))) {
            return false;
        }
        if ((this.levelFormation == null && other.levelFormation != null) || (this.levelFormation != null && !this.levelFormation.equals(other.levelFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.SchedulePK[ version=" + version + ", versionActualityTrimester=" + versionActualityTrimester + ", numberEnvironment=" + numberEnvironment + ", headquartersName=" + headquartersName + ", nameDay=" + nameDay + ", documentType=" + documentType + ", identificationCardNumber=" + identificationCardNumber + ", groupsNumber=" + groupsNumber + ", trimesterName=" + trimesterName + ", workingDayInitials=" + workingDayInitials + ", levelFormation=" + levelFormation + " ]";
    }
    
}
