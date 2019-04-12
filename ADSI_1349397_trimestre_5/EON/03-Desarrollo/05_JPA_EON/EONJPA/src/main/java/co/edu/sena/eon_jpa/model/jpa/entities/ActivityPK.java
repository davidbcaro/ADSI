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
public class ActivityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Activity", nullable = false)
    private int idActivity;
    @Basic(optional = false)
    @Column(name = "Code", nullable = false, length = 50)
    private String code;
    @Basic(optional = false)
    @Column(name = "name_phase", nullable = false, length = 30)
    private String namePhase;

    public ActivityPK() {
    }

    public ActivityPK(int idActivity, String code, String namePhase) {
        this.idActivity = idActivity;
        this.code = code;
        this.namePhase = namePhase;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActivity;
        hash += (code != null ? code.hashCode() : 0);
        hash += (namePhase != null ? namePhase.hashCode() : 0);
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
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if ((this.namePhase == null && other.namePhase != null) || (this.namePhase != null && !this.namePhase.equals(other.namePhase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.ActivityPK[ idActivity=" + idActivity + ", code=" + code + ", namePhase=" + namePhase + " ]";
    }
    
}
