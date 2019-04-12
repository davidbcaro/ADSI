/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findByIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity = :IdActivity"),
    @NamedQuery(name = "Activity.findByName", query = "SELECT a FROM Activity a WHERE a.name = :Name"),
    @NamedQuery(name = "Activity.findByNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase = :namePhase"),
    @NamedQuery(name = "Activity.findByCode", query = "SELECT a FROM Activity a WHERE a.activityPK.code = :Code"),
    @NamedQuery(name = "Activity.findByLikeName", query = "SELECT a FROM Activity a WHERE a.name LIKE :Name"),
    @NamedQuery(name = "Activity.findByLikeNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.namePhase LIKE :namePhase"),
    @NamedQuery(name = "Activity.findByLikeCode", query = "SELECT a FROM Activity a WHERE a.activityPK.code LIKE :Code"),
    @NamedQuery(name = "Activity.updatePrimaryKey", query = "UPDATE Activity a SET a.activityPK.idActivity = :idNuevo, a.activityPK.namePhase = :NamePhaseNuevo, a.activityPK.code = :CodeNuevo WHERE a.activityPK.idActivity = :idViejo AND a.activityPK.namePhase = :NamePhaseViejo AND a.activityPK.code = :CodeViejo")
})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivityPK activityPK;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 200)
    private String name;
    @JoinTable(name = "learning_result_has_activity", joinColumns = {
        @JoinColumn(name = "Activity_id_Activity", referencedColumnName = "id_Activity", nullable = false)
        , @JoinColumn(name = "name_Phase", referencedColumnName = "name_phase", nullable = false)
        , @JoinColumn(name = "Project_Code", referencedColumnName = "Code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "Learning_Result_Code", referencedColumnName = "Code", nullable = false)
        , @JoinColumn(name = "Program_Code", referencedColumnName = "Program_Code", nullable = false)
        , @JoinColumn(name = "Version", referencedColumnName = "Version", nullable = false)
        , @JoinColumn(name = "Competition_Code", referencedColumnName = "Competition_Code", nullable = false)})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumns({
        @JoinColumn(name = "name_phase", referencedColumnName = "name_phase", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Code", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Phase phase;

    public Activity() {
    }

    public Activity(ActivityPK activityPK) {
        this.activityPK = activityPK;
    }

    public Activity(ActivityPK activityPK, String name) {
        this.activityPK = activityPK;
        this.name = name;
    }

    public Activity(int idActivity, String code, String namePhase) {
        this.activityPK = new ActivityPK(idActivity, code, namePhase);
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Activity[ activityPK=" + activityPK + " ]";
    }
    
}
