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
public class ActivityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_activity", nullable = false, length = 20)
    private String idActivity;
    @Basic(optional = false)
    @Column(name = "name_phase", nullable = false, length = 20)
    private String namePhase;
    @Basic(optional = false)
    @Column(name = "Project_code", nullable = false, length = 20)
    private String projectcode;

    public ActivityPK() {
    }

    public ActivityPK(String idActivity, String namePhase, String projectcode) {
        this.idActivity = idActivity;
        this.namePhase = namePhase;
        this.projectcode = projectcode;
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivity != null ? idActivity.hashCode() : 0);
        hash += (namePhase != null ? namePhase.hashCode() : 0);
        hash += (projectcode != null ? projectcode.hashCode() : 0);
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
        if ((this.namePhase == null && other.namePhase != null) || (this.namePhase != null && !this.namePhase.equals(other.namePhase))) {
            return false;
        }
        if ((this.projectcode == null && other.projectcode != null) || (this.projectcode != null && !this.projectcode.equals(other.projectcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.ActivityPK[ idActivity=" + idActivity + ", namePhase=" + namePhase + ", projectcode=" + projectcode + " ]";
    }
    
}
