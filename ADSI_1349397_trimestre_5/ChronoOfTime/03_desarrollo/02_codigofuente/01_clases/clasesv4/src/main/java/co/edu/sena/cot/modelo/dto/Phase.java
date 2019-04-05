/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "phase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phase.findAll", query = "SELECT p FROM Phase p")
    , @NamedQuery(name = "Phase.findByName", query = "SELECT p FROM Phase p WHERE p.phasePK.namePhase = :namePhase")
    , @NamedQuery(name = "Phase.findByCode", query = "SELECT p FROM Phase p WHERE p.phasePK.projectCode = :projectCode")
    , @NamedQuery(name = "Phase.findByState", query = "SELECT p FROM Phase p WHERE p.state = :state")
    , @NamedQuery(name = "Phase.findByLikeName", query = "SELECT p FROM Phase p WHERE p.phasePK.namePhase LIKE :namePhase")
    , @NamedQuery(name = "Phase.updatePK", query = "UPDATE Phase p set p.phasePK.namePhase = :PhaseNew,  p.phasePK.projectCode = :PhaseNew2 WHERE p.phasePK.namePhase = :PhaseOld and  p.phasePK.projectCode = :PhaseOld2")
})
public class Phase implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PhasePK phasePK;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phase")
    private Collection<Activity> activityCollection;
    @JoinColumn(name = "project_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public Phase() {
    }

    public Phase(PhasePK phasePK) {
        this.phasePK = phasePK;
    }

    public Phase(PhasePK phasePK, boolean state) {
        this.phasePK = phasePK;
        this.state = state;
    }

    public Phase(String namePhase, int projectCode) {
        this.phasePK = new PhasePK(namePhase, projectCode);
    }

    public PhasePK getPhasePK() {
        return phasePK;
    }

    public void setPhasePK(PhasePK phasePK) {
        this.phasePK = phasePK;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phasePK != null ? phasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phase)) {
            return false;
        }
        Phase other = (Phase) object;
        if ((this.phasePK == null && other.phasePK != null) || (this.phasePK != null && !this.phasePK.equals(other.phasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Phase[ phasePK=" + phasePK + " ]";
    }
    
}
