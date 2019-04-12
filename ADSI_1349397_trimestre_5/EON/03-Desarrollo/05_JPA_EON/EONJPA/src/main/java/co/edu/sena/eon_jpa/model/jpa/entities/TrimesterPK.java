/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    @Column(name = "quarter_Name", nullable = false, length = 20)
    private String quarterName;
    @Basic(optional = false)
    @Column(name = "acronyms_Working_Day", nullable = false, length = 100)
    private String acronymsWorkingDay;
    @Basic(optional = false)
    @Column(name = "speciality_Name", nullable = false, length = 100)
    private String specialityName;

    public TrimesterPK() {
    }

    public TrimesterPK(String quarterName, String acronymsWorkingDay, String specialityName) {
        this.quarterName = quarterName;
        this.acronymsWorkingDay = acronymsWorkingDay;
        this.specialityName = specialityName;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public String getAcronymsWorkingDay() {
        return acronymsWorkingDay;
    }

    public void setAcronymsWorkingDay(String acronymsWorkingDay) {
        this.acronymsWorkingDay = acronymsWorkingDay;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quarterName != null ? quarterName.hashCode() : 0);
        hash += (acronymsWorkingDay != null ? acronymsWorkingDay.hashCode() : 0);
        hash += (specialityName != null ? specialityName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimesterPK)) {
            return false;
        }
        TrimesterPK other = (TrimesterPK) object;
        if ((this.quarterName == null && other.quarterName != null) || (this.quarterName != null && !this.quarterName.equals(other.quarterName))) {
            return false;
        }
        if ((this.acronymsWorkingDay == null && other.acronymsWorkingDay != null) || (this.acronymsWorkingDay != null && !this.acronymsWorkingDay.equals(other.acronymsWorkingDay))) {
            return false;
        }
        if ((this.specialityName == null && other.specialityName != null) || (this.specialityName != null && !this.specialityName.equals(other.specialityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.TrimesterPK[ quarterName=" + quarterName + ", acronymsWorkingDay=" + acronymsWorkingDay + ", specialityName=" + specialityName + " ]";
    }
    
}
