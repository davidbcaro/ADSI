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
public class ActivityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Activity", nullable = false)
    private int idActivity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name_Phase", nullable = false, length = 20)
    private String namePhase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "project_Code", nullable = false, length = 100)
    private String projectCode;

    public ActivityPK() {
    }

    public ActivityPK(int idActivity, String namePhase, String projectCode) {
        this.idActivity = idActivity;
        this.namePhase = namePhase;
        this.projectCode = projectCode;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActivity;
        hash += (namePhase != null ? namePhase.hashCode() : 0);
        hash += (projectCode != null ? projectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityPK)) {
            return false;
        }
        ActivityPK other = (ActivityPK) object;
        if (this.idActivity != other.idActivity) {
            return false;
        }
        if ((this.namePhase == null && other.namePhase != null) || (this.namePhase != null && !this.namePhase.equals(other.namePhase))) {
            return false;
        }
        if ((this.projectCode == null && other.projectCode != null) || (this.projectCode != null && !this.projectCode.equals(other.projectCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " idActivity=" + idActivity + ", namePhase=" + namePhase + ", projectCode=" + projectCode + "";
    }
    
}
