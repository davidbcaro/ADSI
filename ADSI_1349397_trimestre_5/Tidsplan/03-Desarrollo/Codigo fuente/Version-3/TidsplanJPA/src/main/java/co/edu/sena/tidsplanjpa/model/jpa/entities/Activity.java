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
    , @NamedQuery(name = "Activity.findByLikeIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity  LIKE :idActivity")
    , @NamedQuery(name = "Activity.findByName", query = "SELECT a FROM Activity a WHERE a.name = :name")
    , @NamedQuery(name = "Activity.findByLikeName", query = "SELECT a FROM Activity a WHERE a.name like :name")
    , @NamedQuery(name = "Activity.findByNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase = :namePhase")
    , @NamedQuery(name = "Activity.findByLikeNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase  LIKE :namePhase")
    , @NamedQuery(name = "Activity.findByProjectCode", query = "SELECT a FROM Activity a WHERE a.activityPK.projectCode = :projectCode")
    , @NamedQuery(name = "Activity.findByLikeProjectCode", query = "SELECT a FROM Activity a WHERE a.activityPK.projectCode  LIKE :projectCode")
    , @NamedQuery(name = "Activity.updatePrimaryKey", query = "UPDATE Activity a set a.activityPK.idActivity = :newIdActivity, a.activityPK.namePhase = :newNamePhase, a.activityPK.projectCode = :newProjectCode WHERE a.activityPK.idActivity = :oldIdActivity and a.activityPK.namePhase = :oldNamePhase and a.activityPK.projectCode =:oldProjectCode")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivityPK activityPK;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @JoinTable(name = "learning_result_has_activity", joinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", nullable = false)
        , @JoinColumn(name = "name_phase", referencedColumnName = "name_phase", nullable = false)
        , @JoinColumn(name = "project_code", referencedColumnName = "project_code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "lr_code", referencedColumnName = "id_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false)
        , @JoinColumn(name = "competition_code", referencedColumnName = "competition_code", nullable = false)
        , @JoinColumn(name = "program_version", referencedColumnName = "program_version", nullable = false)})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumns({
        @JoinColumn(name = "name_phase", referencedColumnName = "name_phase", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "project_code", referencedColumnName = "project_code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProjectPhase projectPhase;

    public Activity() {
    }

    public Activity(ActivityPK activityPK) {
        this.activityPK = activityPK;
    }

    public Activity(ActivityPK activityPK, String name) {
        this.activityPK = activityPK;
        this.name = name;
    }

    public Activity(String idActivity, String namePhase, String projectCode) {
        this.activityPK = new ActivityPK(idActivity, namePhase, projectCode);
    }

    public ActivityPK getActivityPK() {
        return activityPK;
    }

    public void setActivityPK(ActivityPK activityPK) {
        this.activityPK = activityPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<LearningResult> getLearningResultCollection() {
        return learningResultCollection;
    }

    public void setLearningResultCollection(Collection<LearningResult> learningResultCollection) {
        this.learningResultCollection = learningResultCollection;
    }

    public ProjectPhase getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        this.projectPhase = projectPhase;
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
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Activity[ activityPK=" + activityPK + " ]";
    }

    public void setProjectCode(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
