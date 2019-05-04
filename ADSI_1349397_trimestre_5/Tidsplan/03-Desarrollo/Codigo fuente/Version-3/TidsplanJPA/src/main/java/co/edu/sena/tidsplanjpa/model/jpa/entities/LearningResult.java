/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
    , @NamedQuery(name = "LearningResult.findByIdCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.idCode = :idCode")
    , @NamedQuery(name = "LearningResult.findByLikeIdCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.idCode like :idCode")
    , @NamedQuery(name = "LearningResult.findByDescription", query = "SELECT l FROM LearningResult l WHERE l.description = :description")
    , @NamedQuery(name = "LearningResult.findByLikeDescription", query = "SELECT l FROM LearningResult l WHERE l.description like :description")
    , @NamedQuery(name = "LearningResult.findByProgramCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programCode = :programCode")
    , @NamedQuery(name = "LearningResult.findByLikeProgramCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programCode like :programCode")
    , @NamedQuery(name = "LearningResult.findByCompetitionCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.competitionCode = :competitionCode")
    , @NamedQuery(name = "LearningResult.findByLikeCompetitionCode", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.competitionCode like :competitionCode")
    , @NamedQuery(name = "LearningResult.findByProgramVersion", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programVersion = :programVersion")
    , @NamedQuery(name = "LearningResult.findByLikeProgramVersion", query = "SELECT l FROM LearningResult l WHERE l.learningResultPK.programVersion like :programVersion")
    , @NamedQuery(name = "LearningResult.updatePrimaryKey", query = "UPDATE LearningResult l SET l.learningResultPK.programVersion =:newProgramVersion, l.learningResultPK.idCode =:newIdCode, l.learningResultPK.programCode =:newProgramCode, l.learningResultPK.competitionCode =:newCompetitionCode WHERE l.learningResultPK.programVersion =:oldProgramVersion and l.learningResultPK.idCode =:oldIdCode and l.learningResultPK.programCode =:oldProgramCode and l.learningResultPK.competitionCode =:oldCompetitionCode")})
public class LearningResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LearningResultPK learningResultPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
    @JoinTable(name = "quarter_planning", joinColumns = {
        @JoinColumn(name = "lr_code", referencedColumnName = "id_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false)
        , @JoinColumn(name = "competition_code", referencedColumnName = "competition_code", nullable = false)
        , @JoinColumn(name = "program_version", referencedColumnName = "program_version", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "name_trimester", referencedColumnName = "name_trimester", nullable = false)
        , @JoinColumn(name = "workingday_initials", referencedColumnName = "workingday_initials", nullable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false)})
    @ManyToMany
    private Collection<Trimester> trimesterCollection;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<GroupHasTrimester> groupHasTrimesterCollection;
    @ManyToMany(mappedBy = "learningResultCollection")
    private Collection<Activity> activityCollection;
    @JoinColumns({
        @JoinColumn(name = "competition_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "program_version", referencedColumnName = "program_version", nullable = false, insertable = false, updatable = false)})
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

    public LearningResult(String idCode, String programCode, String competitionCode, String programVersion) {
        this.learningResultPK = new LearningResultPK(idCode, programCode, competitionCode, programVersion);
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

    public Collection<GroupHasTrimester> getGroupHasTrimesterCollection() {
        return groupHasTrimesterCollection;
    }

    public void setGroupHasTrimesterCollection(Collection<GroupHasTrimester> groupHasTrimesterCollection) {
        this.groupHasTrimesterCollection = groupHasTrimesterCollection;
    }

    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
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
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.LearningResult[ learningResultPK=" + learningResultPK + " ]";
    }
    
}
