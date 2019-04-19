/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "phase_project")
@NamedQueries({
    @NamedQuery(name = "PhaseProject.findAll", query = "SELECT p FROM PhaseProject p")
    , @NamedQuery(name = "PhaseProject.findByNamePhase", query = "SELECT p FROM PhaseProject p WHERE p.phaseProjectPK.namePhase = :namePhase")
    , @NamedQuery(name = "PhaseProject.findByStatusPhase", query = "SELECT p FROM PhaseProject p WHERE p.statusPhase = :statusPhase")
    , @NamedQuery(name = "PhaseProject.findByProjectCode", query = "SELECT p FROM PhaseProject p WHERE p.phaseProjectPK.projectCode = :projectCode")
    , @NamedQuery(name = "PhaseProject.findByLikeNamePhase", query = "SELECT p FROM PhaseProject p WHERE p.phaseProjectPK.namePhase LIKE :namePhase")
    , @NamedQuery(name = "PhaseProject.findByLikeStatusPhase", query = "SELECT p FROM PhaseProject p WHERE p.statusPhase LIKE :statusPhase")
    , @NamedQuery (name= "PhaseProject.findByLikeProjectCode", query = "SELECT p FROM PhaseProject p WHERE p.phaseProjectPK.projectCode LIKE :projectCode")
    , @NamedQuery (name= "PhaseProject.UpdatePK", query = "UPDATE PhaseProject p SET p.phaseProjectPK.namePhase = :nombreFaseNuevo, p.phaseProjectPK.projectCode = :codigoProjectNuevo WHERE p.phaseProjectPK.namePhase = :viejoNombreFase and p.phaseProjectPK.projectCode = :viejoCodigoProyecto" )})
public class PhaseProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PhaseProjectPK phaseProjectPK;
    @Column(name = "status_phase", length = 20)
    private String statusPhase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phaseProject")
    private Collection<Activity> activityCollection;
    @JoinColumn(name = "project_code", referencedColumnName = "code_project", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public PhaseProject() {
    }

    public PhaseProject(PhaseProjectPK phaseProjectPK) {
        this.phaseProjectPK = phaseProjectPK;
    }

    public PhaseProject(String namePhase, String projectCode) {
        this.phaseProjectPK = new PhaseProjectPK(namePhase, projectCode);
    }

    public PhaseProjectPK getPhaseProjectPK() {
        return phaseProjectPK;
    }

    public void setPhaseProjectPK(PhaseProjectPK phaseProjectPK) {
        this.phaseProjectPK = phaseProjectPK;
    }

    public String getStatusPhase() {
        return statusPhase;
    }

    public void setStatusPhase(String statusPhase) {
        this.statusPhase = statusPhase;
    }

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
        hash += (phaseProjectPK != null ? phaseProjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhaseProject)) {
            return false;
        }
        PhaseProject other = (PhaseProject) object;
        if ((this.phaseProjectPK == null && other.phaseProjectPK != null) || (this.phaseProjectPK != null && !this.phaseProjectPK.equals(other.phaseProjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.PhaseProject[ phaseProjectPK=" + phaseProjectPK + " ]";
    }
    
}
