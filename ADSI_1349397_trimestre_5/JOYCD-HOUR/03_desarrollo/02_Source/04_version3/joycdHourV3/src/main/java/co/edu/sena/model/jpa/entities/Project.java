/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findByCodeProject", query = "SELECT p FROM Project p WHERE p.codeProject = :codeProject")
    , @NamedQuery(name = "Project.findByNameProject", query = "SELECT p FROM Project p WHERE p.nameProject = :nameProject")
    , @NamedQuery(name = "Project.findByStatusProject", query = "SELECT p FROM Project p WHERE p.statusProject = :statusProject")
    , @NamedQuery(name = "Project.findByLikeCodeProject", query = "SELECT p FROM Project p WHERE p.codeProject LIKE :codeProject")
    , @NamedQuery(name = "Project.findByLikeNameProject", query = "SELECT p FROM Project p WHERE p.nameProject LIKE :nameProject")
    , @NamedQuery(name = "Project.updatePrimaryKey", query = "UPDATE Project p SET p.codeProject= :codigoNuevo WHERE p.codeProject = :codigoAntiguo")
})

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_project", nullable = false, length = 100)
    private String codeProject;
    @Basic(optional = false)
    @Column(name = "name_project", nullable = false, length = 200)
    private String nameProject;
    @Basic(optional = false)
    @Column(name = "status_project", nullable = false)
    private boolean statusProject;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<PhaseProject> phaseProjectCollection;

    public Project() {
    }

    public Project(String codeProject) {
        this.codeProject = codeProject;
    }

    public Project(String codeProject, String nameProject, boolean statusProject) {
        this.codeProject = codeProject;
        this.nameProject = nameProject;
        this.statusProject = statusProject;
    }

    public String getCodeProject() {
        return codeProject;
    }

    public void setCodeProject(String codeProject) {
        this.codeProject = codeProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public boolean getStatusProject() {
        return statusProject;
    }

    public void setStatusProject(boolean statusProject) {
        this.statusProject = statusProject;
    }

    public Collection<PhaseProject> getPhaseProjectCollection() {
        return phaseProjectCollection;
    }

    public void setPhaseProjectCollection(Collection<PhaseProject> phaseProjectCollection) {
        this.phaseProjectCollection = phaseProjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeProject != null ? codeProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.codeProject == null && other.codeProject != null) || (this.codeProject != null && !this.codeProject.equals(other.codeProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Project[ codeProject=" + codeProject + " ]";
    }

}
