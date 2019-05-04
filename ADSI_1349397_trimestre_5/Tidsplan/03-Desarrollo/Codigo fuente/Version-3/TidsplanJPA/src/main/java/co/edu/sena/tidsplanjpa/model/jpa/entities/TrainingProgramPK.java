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
public class TrainingProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_code", nullable = false, length = 70)
    private String idCode;
    @Basic(optional = false)
    @Column(name = "version", nullable = false, length = 50)
    private String version;

    public TrainingProgramPK() {
    }

    public TrainingProgramPK(String idCode, String version) {
        this.idCode = idCode;
        this.version = version;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCode != null ? idCode.hashCode() : 0);
        hash += (version != null ? version.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingProgramPK)) {
            return false;
        }
        TrainingProgramPK other = (TrainingProgramPK) object;
        if ((this.idCode == null && other.idCode != null) || (this.idCode != null && !this.idCode.equals(other.idCode))) {
            return false;
        }
        if ((this.version == null && other.version != null) || (this.version != null && !this.version.equals(other.version))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgramPK[ idCode=" + idCode + ", version=" + version + " ]";
    }
    
}
