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
public class LearningResultPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Code", nullable = false, length = 50)
    private String code;
    @Basic(optional = false)
    @Column(name = "Program_Code", nullable = false, length = 50)
    private String programCode;
    @Basic(optional = false)
    @Column(name = "Competition_Code", nullable = false, length = 50)
    private String competitionCode;
    @Basic(optional = false)
    @Column(name = "Version", nullable = false, length = 50)
    private String version;

    public LearningResultPK() {
    }

    public LearningResultPK(String code, String programCode, String competitionCode, String version) {
        this.code = code;
        this.programCode = programCode;
        this.competitionCode = competitionCode;
        this.version = version;
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

    public String getCompetitionCode() {
        return competitionCode;
    }

    public void setCompetitionCode(String competitionCode) {
        this.competitionCode = competitionCode;
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
        hash += (code != null ? code.hashCode() : 0);
        hash += (programCode != null ? programCode.hashCode() : 0);
        hash += (competitionCode != null ? competitionCode.hashCode() : 0);
        hash += (version != null ? version.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningResultPK)) {
            return false;
        }
        LearningResultPK other = (LearningResultPK) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if ((this.programCode == null && other.programCode != null) || (this.programCode != null && !this.programCode.equals(other.programCode))) {
            return false;
        }
        if ((this.competitionCode == null && other.competitionCode != null) || (this.competitionCode != null && !this.competitionCode.equals(other.competitionCode))) {
            return false;
        }
        if ((this.version == null && other.version != null) || (this.version != null && !this.version.equals(other.version))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.LearningResultPK[ code=" + code + ", programCode=" + programCode + ", competitionCode=" + competitionCode + ", version=" + version + " ]";
    }
    
}
