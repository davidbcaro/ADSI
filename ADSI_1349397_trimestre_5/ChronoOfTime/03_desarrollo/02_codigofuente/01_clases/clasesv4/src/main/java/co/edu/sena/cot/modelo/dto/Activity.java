/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findByIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity = :idActivity")
    , @NamedQuery(name = "Activity.findByNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.phaseNamePhase = :phaseNamePhase")
    , @NamedQuery(name = "Activity.findByCodeProject", query = "SELECT a FROM Activity a WHERE a.activityPK.phaseProjectCode = :phaseProjectCode")
    , @NamedQuery(name = "Activity.findByName", query = "SELECT a FROM Activity a WHERE a.name = :name")
    , @NamedQuery(name = "Activity.findByLikeName", query = "SELECT a FROM Activity a WHERE a.name LIKE :name")
    , @NamedQuery(name = "Activity.findByLikeIdActivity", query = "SELECT a FROM Activity a WHERE a.activityPK.idActivity LIKE :idActivity")
    , @NamedQuery(name = "Activity.findByLikeNamePhase", query = "SELECT a FROM Activity a WHERE a.activityPK.phaseNamePhase LIKE :phaseNamePhase")
    , @NamedQuery(name = "Activity.updatePK", query = "UPDATE Activity a SET a.activityPK.idActivity = :IdActivityNew,  a.activityPK.phaseNamePhase = :PhaseNamePhaseNew,  a.activityPK.phaseProjectCode = :PhaseProjectCodeNew WHERE a.activityPK.idActivity = :IdActivityOld and a.activityPK.phaseNamePhase = :PhaseNamePhaseOld and a.activityPK.phaseProjectCode = :PhaseProjectCodeOld")
})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivityPK activityPK;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @JoinTable(name = "learning_result_has_activity", joinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", nullable = false)
        , @JoinColumn(name = "app_code", referencedColumnName = "phase_project_code", nullable = false)
        , @JoinColumn(name = "apn_phase", referencedColumnName = "phase_name_phase", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "program_code", referencedColumnName = "code_program", nullable = false)
        , @JoinColumn(name = "edition", referencedColumnName = "edition", nullable = false)
        , @JoinColumn(name = "competence_code", referencedColumnName = "code_competence", nullable = false)
        , @JoinColumn(name = "code", referencedColumnName = "code", nullable = false)})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumns({
        @JoinColumn(name = "phase_name_phase", referencedColumnName = "name_phase", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "phase_project_code", referencedColumnName = "project_code", nullable = false, insertable = false, updatable = false)})
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

    public Activity(String idActivity, String phaseNamePhase, int phaseProjectCode) {
        this.activityPK = new ActivityPK(idActivity, phaseNamePhase, phaseProjectCode);
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

    @XmlTransient
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
        return "co.edu.sena.cot.modelo.dto.Activity[ activityPK=" + activityPK + " ]";
    }
    
}
