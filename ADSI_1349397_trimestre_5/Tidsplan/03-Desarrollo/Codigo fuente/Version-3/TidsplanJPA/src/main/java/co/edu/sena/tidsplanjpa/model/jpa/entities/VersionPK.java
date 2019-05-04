/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
    @Column(name = "id_version", nullable = false)
    private int idVersion;
    @Basic(optional = false)
    @Column(name = "id_trimester_current", nullable = false, length = 10)
    private String idTrimesterCurrent;

    public VersionPK() {
    }

    public VersionPK(int idVersion, String idTrimesterCurrent) {
        this.idVersion = idVersion;
        this.idTrimesterCurrent = idTrimesterCurrent;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getIdTrimesterCurrent() {
        return idTrimesterCurrent;
    }

    public void setIdTrimesterCurrent(String idTrimesterCurrent) {
        this.idTrimesterCurrent = idTrimesterCurrent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVersion;
        hash += (idTrimesterCurrent != null ? idTrimesterCurrent.hashCode() : 0);
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
        if ((this.idTrimesterCurrent == null && other.idTrimesterCurrent != null) || (this.idTrimesterCurrent != null && !this.idTrimesterCurrent.equals(other.idTrimesterCurrent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.VersionPK[ idVersion=" + idVersion + ", idTrimesterCurrent=" + idTrimesterCurrent + " ]";
    }
    
}
