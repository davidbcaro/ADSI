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
public class FichaHasTrimesterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "number_Ficha", nullable = false, length = 60)
    private String numberFicha;
    @Basic(optional = false)
    @Column(name = "quarter_Name", nullable = false, length = 20)
    private String quarterName;
    @Basic(optional = false)
    @Column(name = "acronyms_working_Day", nullable = false, length = 20)
    private String acronymsworkingDay;
    @Basic(optional = false)
    @Column(name = "speciality_Name", nullable = false, length = 100)
    private String specialityName;

    public FichaHasTrimesterPK() {
    }

    public FichaHasTrimesterPK(String numberFicha, String quarterName, String acronymsworkingDay, String specialityName) {
        this.numberFicha = numberFicha;
        this.quarterName = quarterName;
        this.acronymsworkingDay = acronymsworkingDay;
        this.specialityName = specialityName;
    }

    public String getNumberFicha() {
        return numberFicha;
    }

    public void setNumberFicha(String numberFicha) {
        this.numberFicha = numberFicha;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public String getAcronymsworkingDay() {
        return acronymsworkingDay;
    }

    public void setAcronymsworkingDay(String acronymsworkingDay) {
        this.acronymsworkingDay = acronymsworkingDay;
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
        hash += (numberFicha != null ? numberFicha.hashCode() : 0);
        hash += (quarterName != null ? quarterName.hashCode() : 0);
        hash += (acronymsworkingDay != null ? acronymsworkingDay.hashCode() : 0);
        hash += (specialityName != null ? specialityName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaHasTrimesterPK)) {
            return false;
        }
        FichaHasTrimesterPK other = (FichaHasTrimesterPK) object;
        if ((this.numberFicha == null && other.numberFicha != null) || (this.numberFicha != null && !this.numberFicha.equals(other.numberFicha))) {
            return false;
        }
        if ((this.quarterName == null && other.quarterName != null) || (this.quarterName != null && !this.quarterName.equals(other.quarterName))) {
            return false;
        }
        if ((this.acronymsworkingDay == null && other.acronymsworkingDay != null) || (this.acronymsworkingDay != null && !this.acronymsworkingDay.equals(other.acronymsworkingDay))) {
            return false;
        }
        if ((this.specialityName == null && other.specialityName != null) || (this.specialityName != null && !this.specialityName.equals(other.specialityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimesterPK[ numberFicha=" + numberFicha + ", quarterName=" + quarterName + ", acronymsworkingDay=" + acronymsworkingDay + ", specialityName=" + specialityName + " ]";
    }
    
}
