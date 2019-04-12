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
public class PhasePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "name_phase", nullable = false, length = 30)
    private String namePhase;
    @Basic(optional = false)
    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    public PhasePK() {
    }

    public PhasePK(String namePhase, String code) {
        this.namePhase = namePhase;
        this.code = code;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
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
        hash += (namePhase != null ? namePhase.hashCode() : 0);
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhasePK)) {
            return false;
        }
        PhasePK other = (PhasePK) object;
        if ((this.namePhase == null && other.namePhase != null) || (this.namePhase != null && !this.namePhase.equals(other.namePhase))) {
            return false;
        }
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.PhasePK[ namePhase=" + namePhase + ", code=" + code + " ]";
    }
    
}
