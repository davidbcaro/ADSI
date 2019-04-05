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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.updatePk", query = "UPDATE Project p set p.code = :ProjectNew WHERE p.code = :ProjectOld")
    , @NamedQuery(name = "Project.findByCode", query = "SELECT p FROM Project p WHERE p.code = :code")
    , @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name")
    , @NamedQuery(name = "Project.findByState", query = "SELECT p FROM Project p WHERE p.state = :state")
    , @NamedQuery(name = "Project.findByLikeName", query = "SELECT p FROM Project p WHERE p.name LIKE :name")
    , @NamedQuery(name = "Project.findByLikeCode", query = "SELECT p FROM Project p WHERE p.code LIKE :code"),
    
})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false)
    private Integer code;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<Phase> phaseCollection;

    public Project() {
    }

    public Project(Integer code) {
        this.code = code;
    }

    public Project(Integer code, String name, boolean state) {
        this.code = code;
        this.name = name;
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Phase> getPhaseCollection() {
        return phaseCollection;
    }

    public void setPhaseCollection(Collection<Phase> phaseCollection) {
        this.phaseCollection = phaseCollection;
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
        return "co.edu.sena.cot.modelo.dto.Project[ code=" + code + " ]";
    }
    
}
