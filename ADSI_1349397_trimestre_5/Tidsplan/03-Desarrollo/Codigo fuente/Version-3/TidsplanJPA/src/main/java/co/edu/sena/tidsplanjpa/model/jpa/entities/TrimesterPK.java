/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class TrimesterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "name_trimester", nullable = false, length = 20)
    private String nameTrimester;
    @Basic(optional = false)
    @Column(name = "workingday_initials", nullable = false, length = 10)
    private String workingdayInitials;
    @Basic(optional = false)
    @Column(name = "level_formation", nullable = false, length = 50)
    private String levelFormation;

    public TrimesterPK() {
    }

    public TrimesterPK(String nameTrimester, String workingdayInitials, String levelFormation) {
        this.nameTrimester = nameTrimester;
        this.workingdayInitials = workingdayInitials;
        this.levelFormation = levelFormation;
    }

    public String getNameTrimester() {
        return nameTrimester;
    }

    public void setNameTrimester(String nameTrimester) {
        this.nameTrimester = nameTrimester;
    }

    public String getWorkingdayInitials() {
        return workingdayInitials;
    }

    public void setWorkingdayInitials(String workingdayInitials) {
        this.workingdayInitials = workingdayInitials;
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
        hash += (nameTrimester != null ? nameTrimester.hashCode() : 0);
        hash += (workingdayInitials != null ? workingdayInitials.hashCode() : 0);
        hash += (levelFormation != null ? levelFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimesterPK)) {
            return false;
        }
        TrimesterPK other = (TrimesterPK) object;
        if ((this.nameTrimester == null && other.nameTrimester != null) || (this.nameTrimester != null && !this.nameTrimester.equals(other.nameTrimester))) {
            return false;
        }
        if ((this.workingdayInitials == null && other.workingdayInitials != null) || (this.workingdayInitials != null && !this.workingdayInitials.equals(other.workingdayInitials))) {
            return false;
        }
        if ((this.levelFormation == null && other.levelFormation != null) || (this.levelFormation != null && !this.levelFormation.equals(other.levelFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterPK[ nameTrimester=" + nameTrimester + ", workingdayInitials=" + workingdayInitials + ", levelFormation=" + levelFormation + " ]";
    }
    
}
