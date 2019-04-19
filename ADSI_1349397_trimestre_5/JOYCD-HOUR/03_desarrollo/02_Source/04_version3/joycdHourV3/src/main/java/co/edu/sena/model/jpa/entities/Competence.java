/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
@Table(name = "competence")
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c")
    , @NamedQuery(name = "Competence.findByCompetenceCode", query = "SELECT c FROM Competence c WHERE c.competencePK.competenceCode = :competenceCode")
    , @NamedQuery(name = "Competence.findByDescription", query = "SELECT c FROM Competence c WHERE c.description = :description")
    , @NamedQuery(name = "Competence.findByProgramCode", query = "SELECT c FROM Competence c WHERE c.competencePK.programCode = :programCode")
    , @NamedQuery(name = "Competence.findByVersion", query = "SELECT c FROM Competence c WHERE c.competencePK.version = :version")
    , @NamedQuery(name = "Competence.findByLikeCompetenceCode", query = "SELECT c FROM Competence c WHERE c.competencePK.competenceCode LIKE :competenceCode")
    , @NamedQuery(name = "Competence.findByLikeDescription", query = "SELECT c FROM Competence c WHERE c.description LIKE :description")
    , @NamedQuery(name = "Competence.findByLikeProgramCode", query = "SELECT c FROM Competence c WHERE c.competencePK.programCode LIKE :programCode")
    , @NamedQuery(name = "Competence.findByLikeVersion", query = "SELECT c FROM Competence c WHERE c.competencePK.version LIKE :version")
    , @NamedQuery(name = "Competence.UpdatePK", query = "UPDATE Competence c SET c.competencePK.competenceCode = :competenciaNueva, c.competencePK.programCode = :programCodeNueva, c.competencePK.version = :versionNueva WHERE c.competencePK.competenceCode = :competenciaVieja and c.competencePK.programCode = :programCodeVieja and c.competencePK.version = :versionVieja ")
})
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetencePK competencePK;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @JoinColumns({
        @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private Collection<LearningResult> learningResultCollection;

    public Competence() {
    }

    public Competence(CompetencePK competencePK) {
        this.competencePK = competencePK;
    }

    public Competence(CompetencePK competencePK, String description) {
        this.competencePK = competencePK;
        this.description = description;
    }

    public Competence(String competenceCode, String programCode, String version) {
        this.competencePK = new CompetencePK(competenceCode, programCode, version);
    }

    public CompetencePK getCompetencePK() {
        return competencePK;
    }

    public void setCompetencePK(CompetencePK competencePK) {
        this.competencePK = competencePK;
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
        hash += (competencePK != null ? competencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.competencePK == null && other.competencePK != null) || (this.competencePK != null && !this.competencePK.equals(other.competencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Competence[ competencePK=" + competencePK + " ]";
    }

}
