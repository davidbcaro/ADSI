/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "learning_result")
@NamedQueries({
    @NamedQuery(name = "LearningResult.findAll", query = "SELECT l FROM LearningResult l")
    , @NamedQuery(name = "LearningResult.findByLearningResultCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.learningResultCode = :learningResultCode")
    , @NamedQuery(name = "LearningResult.findByDescription", query = "SELECT l FROM LearningResult l WHERE l.description = :description")
    , @NamedQuery(name = "LearningResult.findByProgramcode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programcode = :programcode")
    , @NamedQuery(name = "LearningResult.findByCompetenceCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.competenceCode = :competenceCode")
    , @NamedQuery(name = "LearningResult.findByVersion", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.version = :version")
    , @NamedQuery(name = "LearningResult.findByLikeLearningResultCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.learningResultCode LIKE :learningResultCode")
    ,@NamedQuery(name = "LearningResult.findByLikeDescription", query = "SELECT l FROM LearningResult l WHERE l.description LIKE :description")
    ,@NamedQuery(name = "LearningResult.findByLikeProgramCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programcode LIKE :programcode")
    ,@NamedQuery(name = "LearningResult.findByLikeCompetenceCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.competenceCode LIKE :competenceCode")
    ,@NamedQuery(name = "LearningResult.findByLikeVersion", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.version LIKE :version")
,@NamedQuery (name = "LearningResult.UpdatePK", query = "UPDATE LearningResult l SET l.learningResultPK.learningResultCode = :resultadoNuevo, l.learningResultPK.programcode = :codigoProgramNuevo, l.learningResultPK.competenceCode = :competenciaNueva, l.learningResultPK.version = :versionNueva WHERE l.learningResultPK.learningResultCode = :resultadoViejo and l.learningResultPK.programcode = :codigoProgramViejo and l.learningResultPK.competenceCode = :competenciaVieja and l.learningResultPK.version = :versionVieja")
})
public class LearningResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LearningResultPK learningResultPK;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 350)
    private String description;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<GroupNumberHasTrimester> groupNumberHasTrimesterCollection;
    @JoinTable(name = "trimester_has_learning_result", joinColumns = {
        @JoinColumn(name = "learning_result_code", referencedColumnName = "learning_result_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "Program_code", nullable = false)
        , @JoinColumn(name = "competence_code", referencedColumnName = "competence_code", nullable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "trimester_name", referencedColumnName = "trimester_name", nullable = false)
        , @JoinColumn(name = "working_day_initials", referencedColumnName = "working_day_initials", nullable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false)})
    @ManyToMany
    private Collection<Trimester> trimesterCollection;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<Activity> activityCollection;
    @JoinColumns({
        @JoinColumn(name = "Program_code", referencedColumnName = "program_code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "competence_code", referencedColumnName = "competence_code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false, insertable = false, updatable = false)})
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

    public LearningResult(String learningResultCode, String programcode, String competenceCode, String version) {
        this.learningResultPK = new LearningResultPK(learningResultCode, programcode, competenceCode, version);
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

    public Collection<GroupNumberHasTrimester> getGroupNumberHasTrimesterCollection() {
        return groupNumberHasTrimesterCollection;
    }

    public void setGroupNumberHasTrimesterCollection(Collection<GroupNumberHasTrimester> groupNumberHasTrimesterCollection) {
        this.groupNumberHasTrimesterCollection = groupNumberHasTrimesterCollection;
    }

    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
    }

    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
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
        return "co.edu.sena.model.jpa.entities.LearningResult[ learningResultPK=" + learningResultPK + " ]";
    }
    
}
