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
public class TrimesterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "number", nullable = false)
    private int number;
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 10)
    private String initials;
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 45)
    private String code;

    public TrimesterPK() {
    }

    public TrimesterPK(int number, String initials, String code) {
        this.number = number;
        this.initials = initials;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) number;
        hash += (initials != null ? initials.hashCode() : 0);
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimesterPK)) {
            return false;
        }
        TrimesterPK other = (TrimesterPK) object;
        if (this.number != other.number) {
            return false;
        }
        if ((this.initials == null && other.initials != null) || (this.initials != null && !this.initials.equals(other.initials))) {
            return false;
        }
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.TrimesterPK[ number=" + number + ", initials=" + initials + ", code=" + code + " ]";
    }
    
}
