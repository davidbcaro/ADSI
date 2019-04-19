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
public class VersionSchedulePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;
    @Basic(optional = false)
    @Column(name = "actuality_trimester", nullable = false, length = 12)
    private String actualityTrimester;

    public VersionSchedulePK() {
    }

    public VersionSchedulePK(int version, String actualityTrimester) {
        this.version = version;
        this.actualityTrimester = actualityTrimester;
  
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getActualityTrimester() {
        return actualityTrimester;
    }

    public void setActualityTrimester(String actualityTrimester) {
        this.actualityTrimester = actualityTrimester;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) version;
        hash += (actualityTrimester != null ? actualityTrimester.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionSchedulePK)) {
            return false;
        }
        VersionSchedulePK other = (VersionSchedulePK) object;
        if (this.version != other.version) {
            return false;
        }
        if ((this.actualityTrimester == null && other.actualityTrimester != null) || (this.actualityTrimester != null && !this.actualityTrimester.equals(other.actualityTrimester))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.VersionSchedulePK[ version=" + version + ", actualityTrimester=" + actualityTrimester + " ]";
    }

}
