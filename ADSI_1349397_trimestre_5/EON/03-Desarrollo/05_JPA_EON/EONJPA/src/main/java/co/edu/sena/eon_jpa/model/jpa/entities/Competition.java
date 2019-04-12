/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    @NamedQuery(name = "Competition.findAll", query = "SELECT c FROM Competition c"),
    @NamedQuery(name = "Competition.findByCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.competitioncode = :CompetitionCode"),
    @NamedQuery(name = "Competition.findByDescription", query = "SELECT c FROM Competition c WHERE c.description = :Description"),
    @NamedQuery(name = "Competition.findByProgramCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.programCode = :ProgramCode"),
    @NamedQuery(name = "Competition.findByProgramVersion", query = "SELECT c FROM Competition c WHERE c.competitionPK.version = :Version"),
    @NamedQuery(name = "Competition.findByLikeCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.competitioncode LIKE :CompetitionCode"),
    @NamedQuery(name = "Competition.findByLikeDescription", query = "SELECT c FROM Competition c WHERE c.description LIKE :Description"),
    @NamedQuery(name = "Competition.findByLikeProgramCode", query = "SELECT c FROM Competition c WHERE c.competitionPK.programCode LIKE :ProgramCode"),
    @NamedQuery(name = "Competition.findByLikeProgramVersion", query = "SELECT c FROM Competition c WHERE c.competitionPK.version LIKE :Version"),
    @NamedQuery(name = "Competition.updatePrimaryKey", query = "UPDATE Competition c SET c.competitionPK.competitioncode = :CompetitionNuevo, c.competitionPK.programCode = :CodeNuevo, c.competitionPK.version = :VersionNuevo WHERE c.competitionPK.competitioncode = :CompetitionViejo AND c.competitionPK.programCode = :CodeViejo AND c.competitionPK.version = :VersionViejo")
})
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetitionPK competitionPK;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 300)
    private String description;
    @JoinColumns({
        @JoinColumn(name = "Program_Code", referencedColumnName = "Program_Code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Version", referencedColumnName = "Version", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Program program;
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

    public Competition(String competitioncode, String programCode, String version) {
        this.competitionPK = new CompetitionPK(competitioncode, programCode, version);
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Competition[ competitionPK=" + competitionPK + " ]";
    }
    
}
