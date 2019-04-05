/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c")
    , @NamedQuery(name = "Competence.findByCodeCompetence", query = "SELECT c FROM Competence c WHERE c.competencePK.codeCompetence = :codeCompetence")
    , @NamedQuery(name = "Competence.findByDescription", query = "SELECT c FROM Competence c WHERE c.description = :description")
    , @NamedQuery(name = "Competence.findByCodeProgram", query = "SELECT c FROM Competence c WHERE c.competencePK.codeProgram = :codeProgram")
    , @NamedQuery(name = "Competence.findByEdition", query = "SELECT c FROM Competence c WHERE c.competencePK.edition = :edition")
    , @NamedQuery(name = "Competence.updatePK", query = "UPDATE Competence c set c.competencePK.codeCompetence = :CompetenceNew,  c.competencePK.codeProgram = :CompetenceNew2,  c.competencePK.edition = :CompetenceNew3 WHERE c.competencePK.codeCompetence = :CompetenceOld and c.competencePK.codeProgram = :CompetenceOld2 and c.competencePK.edition = :CompetenceOld3")
    , @NamedQuery(name = "Competence.findByLikeDescription", query = "SELECT c FROM Competence c WHERE c.description LIKE :description")
    , @NamedQuery(name = "Competence.findByLikeEdition", query = "SELECT c FROM Competence c WHERE c.program.programPK.edition LIKE :edition")
})
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetencePK competencePK;
    @Column(name = "description", length = 250)
    private String description;
    @JoinColumns({
        @JoinColumn(name = "code_program", referencedColumnName = "code_program", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "edition", referencedColumnName = "edition", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private Collection<LearningResult> learningResultCollection;

    public Competence() {
    }

    public Competence(CompetencePK competencePK) {
        this.competencePK = competencePK;
    }

    public Competence(int codeCompetence, int codeProgram, String edition) {
        this.competencePK = new CompetencePK(codeCompetence, codeProgram, edition);
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

    @XmlTransient
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
        return "co.edu.sena.cot.modelo.dto.Competence[ competencePK=" + competencePK + " ]";
    }
    
}
