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
public class LearningResultPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_code", nullable = false, length = 100)
    private String idCode;
    @Basic(optional = false)
    @Column(name = "program_code", nullable = false, length = 100)
    private String programCode;
    @Basic(optional = false)
    @Column(name = "competition_code", nullable = false, length = 100)
    private String competitionCode;
    @Basic(optional = false)
    @Column(name = "program_version", nullable = false, length = 20)
    private String programVersion;

    public LearningResultPK() {
    }

    public LearningResultPK(String idCode, String programCode, String competitionCode, String programVersion) {
        this.idCode = idCode;
        this.programCode = programCode;
        this.competitionCode = competitionCode;
        this.programVersion = programVersion;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
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

    public String getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(String programVersion) {
        this.programVersion = programVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCode != null ? idCode.hashCode() : 0);
        hash += (programCode != null ? programCode.hashCode() : 0);
        hash += (competitionCode != null ? competitionCode.hashCode() : 0);
        hash += (programVersion != null ? programVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningResultPK)) {
            return false;
        }
        LearningResultPK other = (LearningResultPK) object;
        if ((this.idCode == null && other.idCode != null) || (this.idCode != null && !this.idCode.equals(other.idCode))) {
            return false;
        }
        if ((this.programCode == null && other.programCode != null) || (this.programCode != null && !this.programCode.equals(other.programCode))) {
            return false;
        }
        if ((this.competitionCode == null && other.competitionCode != null) || (this.competitionCode != null && !this.competitionCode.equals(other.competitionCode))) {
            return false;
        }
        if ((this.programVersion == null && other.programVersion != null) || (this.programVersion != null && !this.programVersion.equals(other.programVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResultPK[ idCode=" + idCode + ", programCode=" + programCode + ", competitionCode=" + competitionCode + ", programVersion=" + programVersion + " ]";
    }
    
}
