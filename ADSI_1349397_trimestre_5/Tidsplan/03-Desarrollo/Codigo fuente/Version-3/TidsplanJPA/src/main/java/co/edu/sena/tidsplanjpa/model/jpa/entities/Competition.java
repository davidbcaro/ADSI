/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
        @Table(name = "competition")
        @NamedQueries({
    @NamedQuery(name = "Competition.findAll", query = "SELECT c FROM Competition c")
    , @NamedQuery(name = "Competition.findByCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.code = :code")
    , @NamedQuery(name = "Competition.findByLikeCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.code like :code")
    , @NamedQuery(name = "Competition.findByDescription", query = "SELECT c FROM Competition c WHERE c.description = :description")
    , @NamedQuery(name = "Competition.findByLikeDescription", query = "SELECT c FROM Competition c WHERE c.description like  :description")
    , @NamedQuery(name = "Competition.findByProgramCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.programCode = :programCode")
    , @NamedQuery(name = "Competition.findByLikeProgramCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.programCode like   :programCode")
    , @NamedQuery(name = "Competition.findByProgramVersion", query = "SELECT c FROM Competition c WHERE c.competitionPK.programVersion = :programVersion")
    , @NamedQuery(name = "Competition.findByLikeProgramVersion", query = "SELECT c FROM Competition c WHERE c.competitionPK.programVersion  like :programVersion")
    , @NamedQuery(name = "Competition.updatePrimaryKey", query = "UPDATE Competition c SET c.competitionPK.programVersion =:newProgramVersion, c.competitionPK.code =:newCode, c.competitionPK.programCode =:newProgramCode  where c.competitionPK.programVersion =:oldProgramVersion and c.competitionPK.code =:oldCode and c.competitionPK.programCode =:oldProgramCode")})

public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetitionPK competitionPK;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 150)
    private String description;
    @JoinColumns({
        @JoinColumn(name = "program_code", referencedColumnName = "id_code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "program_version", referencedColumnName = "version", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TrainingProgram trainingProgram;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private Collection<LearningResult> learningResultCollection;

    public Competition() {
    }

    public Competition(CompetitionPK competitionPK) {
        this.competitionPK = competitionPK;
    }

    public Competition(CompetitionPK competitionPK, String description) {
        this.competitionPK = competitionPK;
        this.description = description;
    }

    public Competition(String code, String programCode, String programVersion) {
        this.competitionPK = new CompetitionPK(code, programCode, programVersion);
    }

    public CompetitionPK getCompetitionPK() {
        return competitionPK;
    }

    public void setCompetitionPK(CompetitionPK competitionPK) {
        this.competitionPK = competitionPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public Collection<LearningResult> getLearningResultCollection() {
        return learningResultCollection;
    }

    public void setLearningResultCollection(Collection<LearningResult> learningResultCollection) {
        this.learningResultCollection = learningResultCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competitionPK != null ? competitionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competition)) {
            return false;
        }
        Competition other = (Competition) object;
        if ((this.competitionPK == null && other.competitionPK != null) || (this.competitionPK != null && !this.competitionPK.equals(other.competitionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Competition[ competitionPK=" + competitionPK + " ]";
    }

}
