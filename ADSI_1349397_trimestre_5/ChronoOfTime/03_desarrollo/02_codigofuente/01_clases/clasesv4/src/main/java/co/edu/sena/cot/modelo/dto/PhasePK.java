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
public class PhasePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "name_phase", nullable = false, length = 100)
    private String namePhase;
    @Basic(optional = false)
    @Column(name = "project_code", nullable = false)
    private int projectCode;

    public PhasePK() {
    }

    public PhasePK(String namePhase, int projectCode) {
        this.namePhase = namePhase;
        this.projectCode = projectCode;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (namePhase != null ? namePhase.hashCode() : 0);
        hash += (int) projectCode;
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
        if (this.projectCode != other.projectCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.PhasePK[ namePhase=" + namePhase + ", projectCode=" + projectCode + " ]";
    }
    
}
