/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findByIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity = :idActivity")
    , @NamedQuery(name = "Activity.findByNameActivity", query = "SELECT a FROM Activity a WHERE a.nameActivity = :nameActivity")
    , @NamedQuery(name = "Activity.findByNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase = :namePhase")
    , @NamedQuery(name = "Activity.findByProjectCode", query = "SELECT a FROM Activity a WHERE a.activityPK.projectCode = :projectCode")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivityPK activityPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "name_activity", nullable = false, length = 400)
    private String nameActivity;
    @JoinTable(name = "learning_outcome_has_activity", joinColumns = {
        @JoinColumn(name = "id_Activity", referencedColumnName = "id_Activity", nullable = false)
        , @JoinColumn(name = "name_Phase", referencedColumnName = "name_Phase", nullable = false)
        , @JoinColumn(name = "project_Code", referencedColumnName = "project_Code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "learning_Outcome_Code", referencedColumnName = "learning_Outcome_Code", nullable = false)
        , @JoinColumn(name = "competition_Code", referencedColumnName = "competition_Code", nullable = false)
        , @JoinColumn(name = "program_Code", referencedColumnName = "program_Code", nullable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<LearningOutcome> learningOutcomeCollection;
    @JoinColumns({
        @JoinColumn(name = "name_Phase", referencedColumnName = "name_Phase", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "project_Code", referencedColumnName = "project_Code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Phase phase;

    public Activity() {
    }

    public Activity(ActivityPK activityPK) {
        this.activityPK = activityPK;
    }

    public Activity(ActivityPK activityPK, String nameActivity) {
        this.activityPK = activityPK;
        this.nameActivity = nameActivity;
    }

    public Activity(int idActivity, String namePhase, String projectCode) {
        this.activityPK = new ActivityPK(idActivity, namePhase, projectCode);
    }

    public ActivityPK getActivityPK() {
        return activityPK;
    }

    public void setActivityPK(ActivityPK activityPK) {
        this.activityPK = activityPK;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    @XmlTransient
    public Collection<LearningOutcome> getLearningOutcomeCollection() {
        return learningOutcomeCollection;
    }

    public void setLearningOutcomeCollection(Collection<LearningOutcome> learningOutcomeCollection) {
        this.learningOutcomeCollection = learningOutcomeCollection;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityPK != null ? activityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityPK == null && other.activityPK != null) || (this.activityPK != null && !this.activityPK.equals(other.activityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "activityPK=" + activityPK + "";
    }
    
}
