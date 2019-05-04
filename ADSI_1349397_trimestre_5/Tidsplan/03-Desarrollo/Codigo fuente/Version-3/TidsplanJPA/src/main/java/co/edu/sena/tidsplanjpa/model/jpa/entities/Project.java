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
    , @NamedQuery(name = "Project.findByCode", query = "SELECT p FROM Project p WHERE p.code = :code")
    , @NamedQuery(name = "Project.findByLikeCode", query = "SELECT p FROM Project p WHERE p.code like :code")
    , @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name")
    , @NamedQuery(name = "Project.findByLikeName", query = "SELECT p FROM Project p WHERE p.name like :name")
    , @NamedQuery(name = "Project.findByStatus", query = "SELECT p FROM Project p WHERE p.status = :status")
    , @NamedQuery(name = "Project.updatePrimaryKey", query = "UPDATE Project p SET p.code = :codeNew WHERE p.code = :codeOld")})

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 100)
    private String code;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<ProjectPhase> projectPhaseCollection;

    public Project() {
    }

    public Project(String code) {
        this.code = code;
    }

    public Project(String code, String name, boolean status) {
        this.code = code;
        this.name = name;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<ProjectPhase> getProjectPhaseCollection() {
        return projectPhaseCollection;
    }

    public void setProjectPhaseCollection(Collection<ProjectPhase> projectPhaseCollection) {
        this.projectPhaseCollection = projectPhaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Project[ code=" + code + " ]";
    }
    
}
