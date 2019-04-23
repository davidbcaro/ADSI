/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
    ,@NamedQuery(name = "Project.findByCode", query = "SELECT p FROM Project p WHERE p.projectCode = :Code")
    ,@NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.nameProject = :Name")
    ,@NamedQuery(name = "Project.findByState", query = "SELECT p FROM Project p WHERE p.state = :State")
    ,@NamedQuery(name = "Project.findByLikeCode", query = "SELECT p FROM Project p WHERE p.projectCode LIKE :Code")
    ,@NamedQuery(name = "Project.updatePrimaryKey", query = "UPDATE Project p SET p.projectCode = :codigoNuevo WHERE p.projectCode = :codigoViejo")
        
})

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "project_Code", nullable = false, length = 100)
    private String projectCode;
    @Basic(optional = false)
    @Column(name = "name_project", nullable = false, length = 100)
    private String nameProject;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<Phase> phaseCollection;

    public Project() {
    }

    public Project(String projectCode) {
        this.projectCode = projectCode;
    }

    public Project(String projectCode, String nameProject, boolean state) {
        this.projectCode = projectCode;
        this.nameProject = nameProject;
        this.state = state;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Collection<Phase> getPhaseCollection() {
        return phaseCollection;
    }

    public void setPhaseCollection(Collection<Phase> phaseCollection) {
        this.phaseCollection = phaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectCode != null ? projectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectCode == null && other.projectCode != null) || (this.projectCode != null && !this.projectCode.equals(other.projectCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Project[ projectCode=" + projectCode + " ]";
    }

}
