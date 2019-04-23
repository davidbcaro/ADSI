/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
    ,@NamedQuery(name = "Competition.findByCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.competitionCode = :code")
    , @NamedQuery(name = "Competition.findByLikeCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.competitionCode LIKE :code")
    , @NamedQuery(name = "Competition.findByDescription", query = "SELECT c FROM Competition c WHERE c.description = :description")
    , @NamedQuery(name = "Competition.findByProgramCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.programCode = :programCode")
    , @NamedQuery(name = "Competition.findByLikeProgramCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.programCode LIKE :programCode")
    , @NamedQuery(name = "Competition.findByProgramVersion", query = "SELECT c FROM Competition c WHERE c.competitionPK.version = :programVersion")
    , @NamedQuery(name = "Competition.findByLikeProgramVersion", query = "SELECT c FROM Competition c WHERE c.competitionPK.version LIKE :programVersion")
    ,@NamedQuery(name = "Competition.updatePk", query = "UPDATE Competition c set c.competitionPK.competitionCode = :competitionNuevo,  c.competitionPK.programCode = :codeNuevo, c.competitionPK.version = :versionNueva WHERE c.competitionPK.competitionCode = :competitionViejo and  c.competitionPK.programCode = :codeViejo and c.competitionPK.version = :versionViejo")
})
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetitionPK competitionPK;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 800)
    private String description;
    @JoinColumns({
        @JoinColumn(name = "program_Code", referencedColumnName = "program_Code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private Collection<LearningOutcome> learningOutcomeCollection;

    public Competition() {
    }

    public Competition(CompetitionPK competitionPK) {
        this.competitionPK = competitionPK;
    }

    public Competition(CompetitionPK competitionPK, String description) {
        this.competitionPK = competitionPK;
        this.description = description;
    }

    public Competition(String competitionCode, String programCode, String version) {
        this.competitionPK = new CompetitionPK(competitionCode, programCode, version);
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Collection<LearningOutcome> getLearningOutcomeCollection() {
        return learningOutcomeCollection;
    }

    public void setLearningOutcomeCollection(Collection<LearningOutcome> learningOutcomeCollection) {
        this.learningOutcomeCollection = learningOutcomeCollection;
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Competition[ competitionPK=" + competitionPK + " ]";
    }
    
}
