/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorge
 */
@Embeddable
public class TrimesterHasLearningResultPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "trimester_number", nullable = false)
    private int trimesterNumber;
    @Basic(optional = false)
    @Column(name = "tri_work_initials", nullable = false, length = 10)
    private String triWorkInitials;
    @Basic(optional = false)
    @Column(name = "learningr_code", nullable = false, length = 45)
    private String learningrCode;
    @Basic(optional = false)
    @Column(name = "levelt_code", nullable = false, length = 45)
    private String leveltCode;
    @Basic(optional = false)
    @Column(name = "learning_edition", nullable = false, length = 10)
    private String learningEdition;
    @Basic(optional = false)
    @Column(name = "program_code", nullable = false)
    private int programCode;
    @Basic(optional = false)
    @Column(name = "competence_code", nullable = false)
    private int competenceCode;

    public TrimesterHasLearningResultPK() {
    }

    public TrimesterHasLearningResultPK(int trimesterNumber, String triWorkInitials, String learningrCode, String leveltCode, String learningEdition, int programCode, int competenceCode) {
        this.trimesterNumber = trimesterNumber;
        this.triWorkInitials = triWorkInitials;
        this.learningrCode = learningrCode;
        this.leveltCode = leveltCode;
        this.learningEdition = learningEdition;
        this.programCode = programCode;
        this.competenceCode = competenceCode;
    }

    public int getTrimesterNumber() {
        return trimesterNumber;
    }

    public void setTrimesterNumber(int trimesterNumber) {
        this.trimesterNumber = trimesterNumber;
    }

    public String getTriWorkInitials() {
        return triWorkInitials;
    }

    public void setTriWorkInitials(String triWorkInitials) {
        this.triWorkInitials = triWorkInitials;
    }

    public String getLearningrCode() {
        return learningrCode;
    }

    public void setLearningrCode(String learningrCode) {
        this.learningrCode = learningrCode;
    }

    public String getLeveltCode() {
        return leveltCode;
    }

    public void setLeveltCode(String leveltCode) {
        this.leveltCode = leveltCode;
    }

    public String getLearningEdition() {
        return learningEdition;
    }

    public void setLearningEdition(String learningEdition) {
        this.learningEdition = learningEdition;
    }

    public int getProgramCode() {
        return programCode;
    }

    public void setProgramCode(int programCode) {
        this.programCode = programCode;
    }

    public int getCompetenceCode() {
        return competenceCode;
    }

    public void setCompetenceCode(int competenceCode) {
        this.competenceCode = competenceCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) trimesterNumber;
        hash += (triWorkInitials != null ? triWorkInitials.hashCode() : 0);
        hash += (learningrCode != null ? learningrCode.hashCode() : 0);
        hash += (leveltCode != null ? leveltCode.hashCode() : 0);
        hash += (learningEdition != null ? learningEdition.hashCode() : 0);
        hash += (int) programCode;
        hash += (int) competenceCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimesterHasLearningResultPK)) {
            return false;
        }
        TrimesterHasLearningResultPK other = (TrimesterHasLearningResultPK) object;
        if (this.trimesterNumber != other.trimesterNumber) {
            return false;
        }
        if ((this.triWorkInitials == null && other.triWorkInitials != null) || (this.triWorkInitials != null && !this.triWorkInitials.equals(other.triWorkInitials))) {
            return false;
        }
        if ((this.learningrCode == null && other.learningrCode != null) || (this.learningrCode != null && !this.learningrCode.equals(other.learningrCode))) {
            return false;
        }
        if ((this.leveltCode == null && other.leveltCode != null) || (this.leveltCode != null && !this.leveltCode.equals(other.leveltCode))) {
            return false;
        }
        if ((this.learningEdition == null && other.learningEdition != null) || (this.learningEdition != null && !this.learningEdition.equals(other.learningEdition))) {
            return false;
        }
        if (this.programCode != other.programCode) {
            return false;
        }
        if (this.competenceCode != other.competenceCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.TrimesterHasLearningResultPK[ trimesterNumber=" + trimesterNumber + ", triWorkInitials=" + triWorkInitials + ", learningrCode=" + learningrCode + ", leveltCode=" + leveltCode + ", learningEdition=" + learningEdition + ", programCode=" + programCode + ", competenceCode=" + competenceCode + " ]";
    }
    
}
