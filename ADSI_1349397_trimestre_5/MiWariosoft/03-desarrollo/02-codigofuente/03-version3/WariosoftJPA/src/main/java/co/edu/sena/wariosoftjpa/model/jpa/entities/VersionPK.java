/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class VersionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Version", nullable = false)
    private int idVersion;
    @Basic(optional = false)
    @Column(name = "id_Current_Quarter", nullable = false, length = 12)
    private String idCurrentQuarter;

    public VersionPK() {
    }

    public VersionPK(int idVersion, String idCurrentQuarter) {
        this.idVersion = idVersion;
        this.idCurrentQuarter = idCurrentQuarter;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getIdCurrentQuarter() {
        return idCurrentQuarter;
    }

    public void setIdCurrentQuarter(String idCurrentQuarter) {
        this.idCurrentQuarter = idCurrentQuarter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVersion;
        hash += (idCurrentQuarter != null ? idCurrentQuarter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionPK)) {
            return false;
        }
        VersionPK other = (VersionPK) object;
        if (this.idVersion != other.idVersion) {
            return false;
        }
        if ((this.idCurrentQuarter == null && other.idCurrentQuarter != null) || (this.idCurrentQuarter != null && !this.idCurrentQuarter.equals(other.idCurrentQuarter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.VersionPK[ idVersion=" + idVersion + ", idCurrentQuarter=" + idCurrentQuarter + " ]";
    }
    
}
