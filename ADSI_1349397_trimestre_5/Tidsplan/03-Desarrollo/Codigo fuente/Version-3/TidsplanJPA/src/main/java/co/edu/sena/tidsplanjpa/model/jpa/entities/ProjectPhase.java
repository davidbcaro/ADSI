/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "project_phase")
@NamedQueries({
    @NamedQuery(name = "ProjectPhase.findAll", query = "SELECT p FROM ProjectPhase p")
    , @NamedQuery(name = "ProjectPhase.findByNamePhase", query = "SELECT p FROM ProjectPhase p WHERE p.projectPhasePK.namePhase = :namePhase")
    , @NamedQuery(name = "ProjectPhase.findByLikeNamePhase", query = "SELECT p FROM ProjectPhase p WHERE p.projectPhasePK.namePhase LIKE :namePhase")
    , @NamedQuery(name = "ProjectPhase.findByStatus", query = "SELECT p FROM ProjectPhase p WHERE p.status = :status")
    , @NamedQuery(name = "ProjectPhase.findByProjectCode", query = "SELECT p FROM ProjectPhase p WHERE p.projectPhasePK.projectCode = :projectCode")
    , @NamedQuery(name = "ProjectPhase.findByLikeProjectCode", query = "SELECT p FROM ProjectPhase p WHERE p.projectPhasePK.projectCode LIKE :projectCode")
    , @NamedQuery(name = "ProjectPhase.updatePrimaryKey", query = "UPDATE ProjectPhase p set p.projectPhasePK.projectCode = :newProjectCode, p.projectPhasePK.namePhase = :newNamePhase WHERE p.projectPhasePK.projectCode = :oldProjectCode and p.projectPhasePK.namePhase = :oldNamePhase")})
public class ProjectPhase implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectPhasePK projectPhasePK;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectPhase")
    private Collection<Activity> activityCollection;
    @JoinColumn(name = "project_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public ProjectPhase() {
    }

    public ProjectPhase(ProjectPhasePK projectPhasePK) {
        this.projectPhasePK = projectPhasePK;
    }

    public ProjectPhase(ProjectPhasePK projectPhasePK, boolean status) {
        this.projectPhasePK = projectPhasePK;
        this.status = status;
    }

    public ProjectPhase(String namePhase, String projectCode) {
        this.projectPhasePK = new ProjectPhasePK(namePhase, projectCode);
    }

    public ProjectPhasePK getProjectPhasePK() {
        return projectPhasePK;
    }

    public void setProjectPhasePK(ProjectPhasePK projectPhasePK) {
        this.projectPhasePK = projectPhasePK;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        hash += (projectPhasePK != null ? projectPhasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectPhase)) {
            return false;
        }
        ProjectPhase other = (ProjectPhase) object;
        if ((this.projectPhasePK == null && other.projectPhasePK != null) || (this.projectPhasePK != null && !this.projectPhasePK.equals(other.projectPhasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.ProjectPhase[ projectPhasePK=" + projectPhasePK + " ]";
    }
    
}
