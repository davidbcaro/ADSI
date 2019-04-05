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
public class ActivityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_activity", nullable = false, length = 20)
    private String idActivity;
    @Basic(optional = false)
    @Column(name = "phase_name_phase", nullable = false, length = 50)
    private String phaseNamePhase;
    @Basic(optional = false)
    @Column(name = "phase_project_code", nullable = false)
    private int phaseProjectCode;

    public ActivityPK() {
    }

    public ActivityPK(String idActivity, String phaseNamePhase, int phaseProjectCode) {
        this.idActivity = idActivity;
        this.phaseNamePhase = phaseNamePhase;
        this.phaseProjectCode = phaseProjectCode;
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }

    public String getPhaseNamePhase() {
        return phaseNamePhase;
    }

    public void setPhaseNamePhase(String phaseNamePhase) {
        this.phaseNamePhase = phaseNamePhase;
    }

    public int getPhaseProjectCode() {
        return phaseProjectCode;
    }

    public void setPhaseProjectCode(int phaseProjectCode) {
        this.phaseProjectCode = phaseProjectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivity != null ? idActivity.hashCode() : 0);
        hash += (phaseNamePhase != null ? phaseNamePhase.hashCode() : 0);
        hash += (int) phaseProjectCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityPK)) {
            return false;
        }
        ActivityPK other = (ActivityPK) object;
        if ((this.idActivity == null && other.idActivity != null) || (this.idActivity != null && !this.idActivity.equals(other.idActivity))) {
            return false;
        }
        if ((this.phaseNamePhase == null && other.phaseNamePhase != null) || (this.phaseNamePhase != null && !this.phaseNamePhase.equals(other.phaseNamePhase))) {
            return false;
        }
        if (this.phaseProjectCode != other.phaseProjectCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.ActivityPK[ idActivity=" + idActivity + ", phaseNamePhase=" + phaseNamePhase + ", phaseProjectCode=" + phaseProjectCode + " ]";
    }
    
}
