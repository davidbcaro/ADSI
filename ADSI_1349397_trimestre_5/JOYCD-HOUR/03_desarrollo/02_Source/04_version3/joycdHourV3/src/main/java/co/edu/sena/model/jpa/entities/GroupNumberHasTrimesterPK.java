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
public class GroupNumberHasTrimesterPK implements Serializable {

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

    public GroupNumberHasTrimesterPK() {
    }

    public GroupNumberHasTrimesterPK(String groupsNumber, String trimesterName, String workingDayInitials, String levelFormation) {
        this.groupsNumber = groupsNumber;
        this.trimesterName = trimesterName;
        this.workingDayInitials = workingDayInitials;
        this.levelFormation = levelFormation;
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
        hash += (groupsNumber != null ? groupsNumber.hashCode() : 0);
        hash += (trimesterName != null ? trimesterName.hashCode() : 0);
        hash += (workingDayInitials != null ? workingDayInitials.hashCode() : 0);
        hash += (levelFormation != null ? levelFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupNumberHasTrimesterPK)) {
            return false;
        }
        GroupNumberHasTrimesterPK other = (GroupNumberHasTrimesterPK) object;
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
        return "co.edu.sena.model.jpa.entities.GroupNumberHasTrimesterPK[ groupsNumber=" + groupsNumber + ", trimesterName=" + trimesterName + ", workingDayInitials=" + workingDayInitials + ", levelFormation=" + levelFormation + " ]";
    }
    
}
