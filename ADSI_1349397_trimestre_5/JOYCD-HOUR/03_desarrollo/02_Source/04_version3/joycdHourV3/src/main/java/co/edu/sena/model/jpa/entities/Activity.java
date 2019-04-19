/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "activity")
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findByIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity = :idActivity")
    , @NamedQuery(name = "Activity.findByLikeIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity LIKE :idActivity")
    
    , @NamedQuery(name = "Activity.findByNameActivity", query = "SELECT a FROM Activity a WHERE a.nameActivity = :nameActivity")
    , @NamedQuery(name = "Activity.finByLikeNameActivity", query = "SELECT a FROM Activity a WHERE a.nameActivity LIKE :nameActivity")
    , @NamedQuery(name = "Activity.findByNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase = :namePhase")
    , @NamedQuery(name = "Activity.findByLikeNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase LIKE :namePhase")
    , @NamedQuery(name = "Activity.findByProjectcode", query = "SELECT a FROM Activity a WHERE a.activityPK.projectcode = :projectCode")
    , @NamedQuery(name = "Activity.findByLikeProjectCode", query = "SELECT a FROM Activity a WHERE a.activityPK.projectcode LIKE :projectCode")
    ,@NamedQuery(name = "Activity.updatePrimaryKey", query = "UPDATE Activity a set a.activityPK.idActivity = :idActivityNew,  a.activityPK.namePhase = :namePhaseNew, a.activityPK.projectcode = :projectCodeNew WHERE a.activityPK.idActivity = :idActivityOld and a.activityPK.namePhase = :namePhaseOld and a.activityPK.projectcode = :projectCodeOld")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivityPK activityPK;
    @Column(name = "name_activity", length = 350)
    private String nameActivity;
    @JoinTable(name = "learning_result_has_activity", joinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", nullable = false)
        , @JoinColumn(name = "name_phase", referencedColumnName = "name_phase", nullable = false)
        , @JoinColumn(name = "project_code", referencedColumnName = "Project_code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "learning_result_code", referencedColumnName = "learning_result_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "Program_code", nullable = false)
        , @JoinColumn(name = "competence_code", referencedColumnName = "competence_code", nullable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version")})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumns({
        @JoinColumn(name = "name_phase", referencedColumnName = "name_phase", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Project_code", referencedColumnName = "project_code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PhaseProject phaseProject;

    public Activity() {
    }

    public Activity(ActivityPK activityPK) {
        this.activityPK = activityPK;
    }

    public Activity(String idActivity, String namePhase, String projectcode) {
        this.activityPK = new ActivityPK(idActivity, namePhase, projectcode);
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

    public Collection<LearningResult> getLearningResultCollection() {
        return learningResultCollection;
    }

    public void setLearningResultCollection(Collection<LearningResult> learningResultCollection) {
        this.learningResultCollection = learningResultCollection;
    }

    public PhaseProject getPhaseProject() {
        return phaseProject;
    }

    public void setPhaseProject(PhaseProject phaseProject) {
        this.phaseProject = phaseProject;
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
        return "co.edu.sena.model.jpa.entities.Activity[ activityPK=" + activityPK + " ]";
    }

}
