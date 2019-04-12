/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByCode", query = "SELECT p FROM Project p WHERE p.code = :Code"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :Name"),
    @NamedQuery(name = "Project.findByState", query = "SELECT p FROM Project p WHERE p.state = :State"),
    @NamedQuery(name = "Project.findByLikeCode", query = "SELECT p FROM Project p WHERE p.code LIKE :Code"),
    @NamedQuery(name = "Project.findByLikeName", query = "SELECT p FROM Project p WHERE p.name LIKE :Name"),
    @NamedQuery(name = "Project.updatePrimaryKey", query = "UPDATE Project p SET p.code = :CodeNuevo WHERE p.code = :CodeViejo")
})
public class Project implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<Phase> phaseCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code", nullable = false, length = 50)
    private String code;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 150)
    private String name;
    @Column(name = "State")
    private Boolean state;

    public Project() {
    }

    public Project(String code) {
        this.code = code;
    }

    public Project(String code, String name) {
        this.code = code;
        this.name = name;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Project[ code=" + code + " ]";
    }

    public Collection<Phase> getPhaseCollection() {
        return phaseCollection;
    }

    public void setPhaseCollection(Collection<Phase> phaseCollection) {
        this.phaseCollection = phaseCollection;
    }
    
}
