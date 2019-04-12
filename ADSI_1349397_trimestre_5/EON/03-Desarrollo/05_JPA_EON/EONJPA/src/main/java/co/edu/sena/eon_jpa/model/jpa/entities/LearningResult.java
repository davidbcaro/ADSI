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
    @NamedQuery(name = "LearningResult.findAll", query = "SELECT l FROM LearningResult l"),
    @NamedQuery(name = "LearningResult.findByCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.code = :Code"),
    @NamedQuery(name = "LearningResult.findByDescription", query = "SELECT l FROM LearningResult l WHERE l.description = :Description"),
    @NamedQuery(name = "LearningResult.findByCompetitionCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.competitionCode = :CompetitionCode"),
    @NamedQuery(name = "LearningResult.findByProgramCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programCode = :ProgramCode"),
    @NamedQuery(name = "LearningResult.findByVersion", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.version = :Version"),
    @NamedQuery(name = "LearningResult.findByLikeCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.code LIKE :Code"),
    @NamedQuery(name = "LearningResult.findByLikeDescription", query = "SELECT l FROM LearningResult l WHERE l.description LIKE :Description"),
    @NamedQuery(name = "LearningResult.findByLikeCompetitionCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.competitionCode LIKE :CompetitionCode"),
    @NamedQuery(name = "LearningResult.findByLikeProgramCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programCode LIKE :ProgramCode"),
    @NamedQuery(name = "LearningResult.findByLikeVersion", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.version LIKE :Version"),
    @NamedQuery(name = "LearningResult.updatePrimaryKey", query = "UPDATE LearningResult l SET l.learningResultPK.code = :CodeNuevo, l.learningResultPK.competitionCode = :CompetitionNuevo, l.learningResultPK.programCode = :ProgramNuevo, l.learningResultPK.version = :VersionNuevo WHERE l.learningResultPK.code = :CodeViejo AND l.learningResultPK.competitionCode = :CompetitionViejo AND l.learningResultPK.programCode = :ProgramViejo AND l.learningResultPK.version = :VersionViejo")
})
public class LearningResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LearningResultPK learningResultPK;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 400)
    private String description;
    @JoinTable(name = "trimester_has_learning_result", joinColumns = {
        @JoinColumn(name = "Learning_Result_Code", referencedColumnName = "Code", nullable = false)
        , @JoinColumn(name = "Program_Code", referencedColumnName = "Program_Code", nullable = false)
        , @JoinColumn(name = "Version", referencedColumnName = "Version", nullable = false)
        , @JoinColumn(name = "Competition_Code", referencedColumnName = "Competition_Code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "quarter_Name", referencedColumnName = "quarter_Name", nullable = false)
        , @JoinColumn(name = "acronyms_Working_Day", referencedColumnName = "acronyms_Working_Day", nullable = false)
        , @JoinColumn(name = "speciality_Name", referencedColumnName = "speciality_Name", nullable = false)})
    @ManyToMany
    private Collection<Trimester> trimesterCollection;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<Activity> activityCollection;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<FichaHasTrimester> fichaHasTrimesterCollection;
    @JoinColumns({
        @JoinColumn(name = "Competition_Code", referencedColumnName = "Competition_code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Program_Code", referencedColumnName = "Program_Code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Version", referencedColumnName = "Version", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Competition competition;

    public LearningResult() {
    }

    public LearningResult(LearningResultPK learningResultPK) {
        this.learningResultPK = learningResultPK;
    }

    public LearningResult(LearningResultPK learningResultPK, String description) {
        this.learningResultPK = learningResultPK;
        this.description = description;
    }

    public LearningResult(String code, String programCode, String competitionCode, String version) {
        this.learningResultPK = new LearningResultPK(code, programCode, competitionCode, version);
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

    public Collection<FichaHasTrimester> getFichaHasTrimesterCollection() {
        return fichaHasTrimesterCollection;
    }

    public void setFichaHasTrimesterCollection(Collection<FichaHasTrimester> fichaHasTrimesterCollection) {
        this.fichaHasTrimesterCollection = fichaHasTrimesterCollection;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.LearningResult[ learningResultPK=" + learningResultPK + " ]";
    }
    
}
