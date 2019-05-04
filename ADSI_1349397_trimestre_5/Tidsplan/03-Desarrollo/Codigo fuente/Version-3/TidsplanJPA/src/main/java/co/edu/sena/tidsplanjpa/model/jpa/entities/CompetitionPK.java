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
public class CompetitionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 100)
    private String code;
    @Basic(optional = false)
    @Column(name = "program_code", nullable = false, length = 100)
    private String programCode;
    @Basic(optional = false)
    @Column(name = "program_version", nullable = false, length = 10)
    private String programVersion;

    public CompetitionPK() {
    }

    public CompetitionPK(String code, String programCode, String programVersion) {
        this.code = code;
        this.programCode = programCode;
        this.programVersion = programVersion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(String programVersion) {
        this.programVersion = programVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        hash += (programCode != null ? programCode.hashCode() : 0);
        hash += (programVersion != null ? programVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetitionPK)) {
            return false;
        }
        CompetitionPK other = (CompetitionPK) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if ((this.programCode == null && other.programCode != null) || (this.programCode != null && !this.programCode.equals(other.programCode))) {
            return false;
        }
        if ((this.programVersion == null && other.programVersion != null) || (this.programVersion != null && !this.programVersion.equals(other.programVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.CompetitionPK[ code=" + code + ", programCode=" + programCode + ", programVersion=" + programVersion + " ]";
    }
    
}
