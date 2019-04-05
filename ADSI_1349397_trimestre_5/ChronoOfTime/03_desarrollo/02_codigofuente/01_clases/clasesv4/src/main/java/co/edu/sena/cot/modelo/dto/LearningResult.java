/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "learning_result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearningResult.findAll", query = "SELECT l FROM LearningResult l")
    , @NamedQuery(name = "LearningResult.findByCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.code = :code")
    , @NamedQuery(name = "LearningResult.findByDescription", query = "SELECT l FROM LearningResult l WHERE l.description = :description")
    , @NamedQuery(name = "LearningResult.findByCodeCompetence", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.codeCompetence = :codeCompetence")
    , @NamedQuery(name = "LearningResult.findByCodeProgram", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.codeProgram = :codeProgram")
    , @NamedQuery(name = "LearningResult.findByEdition", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.edition = :edition")
    , @NamedQuery(name = "LearningResult.findByLikeDescription", query = "SELECT l FROM LearningResult l WHERE l.description LIKE :description")
    , @NamedQuery(name = "LearningResult.findByLikeEdition", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.edition LIKE :edition")
    , @NamedQuery(name = "LearningResult.updatePK", query = "UPDATE LearningResult l SET l.learningResultPK.code = :codeNew,  l.learningResultPK.codeCompetence = :competenceNew,  l.learningResultPK.codeProgram = :programNew, l.learningResultPK.edition = :editionNew WHERE l.learningResultPK.code = :code and l.learningResultPK.codeCompetence = :competence and l.learningResultPK.codeProgram = :program and l.learningResultPK.edition = :edition")})
public class LearningResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LearningResultPK learningResultPK;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 500)
    private String description;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<Activity> activityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningResult")
    private Collection<TrimesterHasLearningResult> trimesterHasLearningResultCollection;
    @JoinColumns({
        @JoinColumn(name = "code_program", referencedColumnName = "code_program", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "edition", referencedColumnName = "edition", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_competence", referencedColumnName = "code_competence", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Competence competence;

    public LearningResult() {
    }

    public LearningResult(LearningResultPK learningResultPK) {
        this.learningResultPK = learningResultPK;
    }

    public LearningResult(LearningResultPK learningResultPK, String description) {
        this.learningResultPK = learningResultPK;
        this.description = description;
    }

    public LearningResult(String code, int codeCompetence, int codeProgram, String edition) {
        this.learningResultPK = new LearningResultPK(code, codeCompetence, codeProgram, edition);
    }

    public LearningResultPK getLearningResultPK() {
        return learningResultPK;
    }

    public void setLearningResultPK(LearningResultPK learningResultPK) {
        this.learningResultPK = learningResultPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @XmlTransient
    public Collection<TrimesterHasLearningResult> getTrimesterHasLearningResultCollection() {
        return trimesterHasLearningResultCollection;
    }

    public void setTrimesterHasLearningResultCollection(Collection<TrimesterHasLearningResult> trimesterHasLearningResultCollection) {
        this.trimesterHasLearningResultCollection = trimesterHasLearningResultCollection;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (learningResultPK != null ? learningResultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningResult)) {
            return false;
        }
        LearningResult other = (LearningResult) object;
        if ((this.learningResultPK == null && other.learningResultPK != null) || (this.learningResultPK != null && !this.learningResultPK.equals(other.learningResultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.LearningResult[ learningResultPK=" + learningResultPK + " ]";
    }
    
}
