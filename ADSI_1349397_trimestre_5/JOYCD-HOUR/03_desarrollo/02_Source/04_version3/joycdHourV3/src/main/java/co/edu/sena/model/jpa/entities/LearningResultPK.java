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
public class LearningResultPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "learning_result_code", nullable = false, length = 100)
    private String learningResultCode;
    @Basic(optional = false)
    @Column(name = "Program_code", nullable = false, length = 100)
    private String programcode;
    @Basic(optional = false)
    @Column(name = "competence_code", nullable = false, length = 100)
    private String competenceCode;
    @Basic(optional = false)
    @Column(name = "version", nullable = false, length = 20)
    private String version;

    public LearningResultPK() {
    }

    public LearningResultPK(String learningResultCode, String programcode, String competenceCode, String version) {
        this.learningResultCode = learningResultCode;
        this.programcode = programcode;
        this.competenceCode = competenceCode;
        this.version = version;
    }

    public String getLearningResultCode() {
        return learningResultCode;
    }

    public void setLearningResultCode(String learningResultCode) {
        this.learningResultCode = learningResultCode;
    }

    public String getProgramcode() {
        return programcode;
    }

    public void setProgramcode(String programcode) {
        this.programcode = programcode;
    }

    public String getCompetenceCode() {
        return competenceCode;
    }

    public void setCompetenceCode(String competenceCode) {
        this.competenceCode = competenceCode;
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
        hash += (learningResultCode != null ? learningResultCode.hashCode() : 0);
        hash += (programcode != null ? programcode.hashCode() : 0);
        hash += (competenceCode != null ? competenceCode.hashCode() : 0);
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
        if ((this.learningResultCode == null && other.learningResultCode != null) || (this.learningResultCode != null && !this.learningResultCode.equals(other.learningResultCode))) {
            return false;
        }
        if ((this.programcode == null && other.programcode != null) || (this.programcode != null && !this.programcode.equals(other.programcode))) {
            return false;
        }
        if ((this.competenceCode == null && other.competenceCode != null) || (this.competenceCode != null && !this.competenceCode.equals(other.competenceCode))) {
            return false;
        }
        if ((this.version == null && other.version != null) || (this.version != null && !this.version.equals(other.version))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.LearningResultPK[ learningResultCode=" + learningResultCode + ", programcode=" + programcode + ", competenceCode=" + competenceCode + ", version=" + version + " ]";
    }
    
}
