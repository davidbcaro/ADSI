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
public class CompetitionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Competition_code", nullable = false, length = 50)
    private String competitioncode;
    @Basic(optional = false)
    @Column(name = "Program_Code", nullable = false, length = 50)
    private String programCode;
    @Basic(optional = false)
    @Column(name = "Version", nullable = false, length = 50)
    private String version;

    public CompetitionPK() {
    }

    public CompetitionPK(String competitioncode, String programCode, String version) {
        this.competitioncode = competitioncode;
        this.programCode = programCode;
        this.version = version;
    }

    public String getCompetitioncode() {
        return competitioncode;
    }

    public void setCompetitioncode(String competitioncode) {
        this.competitioncode = competitioncode;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
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
        hash += (competitioncode != null ? competitioncode.hashCode() : 0);
        hash += (programCode != null ? programCode.hashCode() : 0);
        hash += (version != null ? version.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetitionPK)) {
            return false;
        }
        CompetitionPK other = (CompetitionPK) object;
        if ((this.competitioncode == null && other.competitioncode != null) || (this.competitioncode != null && !this.competitioncode.equals(other.competitioncode))) {
            return false;
        }
        if ((this.programCode == null && other.programCode != null) || (this.programCode != null && !this.programCode.equals(other.programCode))) {
            return false;
        }
        if ((this.version == null && other.version != null) || (this.version != null && !this.version.equals(other.version))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.CompetitionPK[ competitioncode=" + competitioncode + ", programCode=" + programCode + ", version=" + version + " ]";
    }
    
}
