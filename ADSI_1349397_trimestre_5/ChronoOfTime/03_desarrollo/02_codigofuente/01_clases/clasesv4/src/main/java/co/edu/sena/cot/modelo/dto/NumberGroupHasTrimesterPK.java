/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorge
 */
@Embeddable
public class NumberGroupHasTrimesterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "number_group", nullable = false)
    private int numberGroup;
    @Basic(optional = false)
    @Column(name = "number", nullable = false)
    private int number;
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 10)
    private String initials;
    @Basic(optional = false)
    @Column(name = "tri_code", nullable = false, length = 45)
    private String triCode;

    public NumberGroupHasTrimesterPK() {
    }

    public NumberGroupHasTrimesterPK(int numberGroup, int number, String initials, String triCode) {
        this.numberGroup = numberGroup;
        this.number = number;
        this.initials = initials;
        this.triCode = triCode;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getTriCode() {
        return triCode;
    }

    public void setTriCode(String triCode) {
        this.triCode = triCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numberGroup;
        hash += (int) number;
        hash += (initials != null ? initials.hashCode() : 0);
        hash += (triCode != null ? triCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberGroupHasTrimesterPK)) {
            return false;
        }
        NumberGroupHasTrimesterPK other = (NumberGroupHasTrimesterPK) object;
        if (this.numberGroup != other.numberGroup) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if ((this.initials == null && other.initials != null) || (this.initials != null && !this.initials.equals(other.initials))) {
            return false;
        }
        if ((this.triCode == null && other.triCode != null) || (this.triCode != null && !this.triCode.equals(other.triCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.NumberGroupHasTrimesterPK[ numberGroup=" + numberGroup + ", number=" + number + ", initials=" + initials + ", triCode=" + triCode + " ]";
    }
    
}
