/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 1349397
 */
@Embeddable
public class NumberGroupHasTrimesterPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "number_Group", nullable = false, length = 100)
    private String numberGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name_Trimester", nullable = false, length = 20)
    private String nameTrimester;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "initials_Working_Day", nullable = false, length = 10)
    private String initialsWorkingDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "training_Level", nullable = false, length = 20)
    private String trainingLevel;

    public NumberGroupHasTrimesterPK() {
    }

    public NumberGroupHasTrimesterPK(String numberGroup, String nameTrimester, String initialsWorkingDay, String trainingLevel) {
        this.numberGroup = numberGroup;
        this.nameTrimester = nameTrimester;
        this.initialsWorkingDay = initialsWorkingDay;
        this.trainingLevel = trainingLevel;
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

    public String getInitialsWorkingDay() {
        return initialsWorkingDay;
    }

    public void setInitialsWorkingDay(String initialsWorkingDay) {
        this.initialsWorkingDay = initialsWorkingDay;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberGroup != null ? numberGroup.hashCode() : 0);
        hash += (nameTrimester != null ? nameTrimester.hashCode() : 0);
        hash += (initialsWorkingDay != null ? initialsWorkingDay.hashCode() : 0);
        hash += (trainingLevel != null ? trainingLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberGroupHasTrimesterPK)) {
            return false;
        }
        NumberGroupHasTrimesterPK other = (NumberGroupHasTrimesterPK) object;
        if ((this.numberGroup == null && other.numberGroup != null) || (this.numberGroup != null && !this.numberGroup.equals(other.numberGroup))) {
            return false;
        }
        if ((this.nameTrimester == null && other.nameTrimester != null) || (this.nameTrimester != null && !this.nameTrimester.equals(other.nameTrimester))) {
            return false;
        }
        if ((this.initialsWorkingDay == null && other.initialsWorkingDay != null) || (this.initialsWorkingDay != null && !this.initialsWorkingDay.equals(other.initialsWorkingDay))) {
            return false;
        }
        if ((this.trainingLevel == null && other.trainingLevel != null) || (this.trainingLevel != null && !this.trainingLevel.equals(other.trainingLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK[ numberGroup=" + numberGroup + ", nameTrimester=" + nameTrimester + ", initialsWorkingDay=" + initialsWorkingDay + ", trainingLevel=" + trainingLevel + " ]";
    }
    
}
