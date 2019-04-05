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
@Table(name = "environment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Environment.findAll", query = "SELECT e FROM Environment e")
    , @NamedQuery(name = "Environment.findByNumEnvironment", query = "SELECT e FROM Environment e WHERE e.numEnvironment = :numEnvironment")
    , @NamedQuery(name = "Environment.findByState", query = "SELECT e FROM Environment e WHERE e.state = :state")
    , @NamedQuery(name = "Environment.findByDescription", query = "SELECT e FROM Environment e WHERE e.description = :description")})
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_environment", nullable = false, length = 45)
    private String numEnvironment;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @Column(name = "description", length = 100)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "environment")
    private Collection<Headquaters> headquatersCollection;

    public Environment() {
    }

    public Environment(String numEnvironment) {
        this.numEnvironment = numEnvironment;
    }

    public Environment(String numEnvironment, boolean state) {
        this.numEnvironment = numEnvironment;
        this.state = state;
    }

    public String getNumEnvironment() {
        return numEnvironment;
    }

    public void setNumEnvironment(String numEnvironment) {
        this.numEnvironment = numEnvironment;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Headquaters> getHeadquatersCollection() {
        return headquatersCollection;
    }

    public void setHeadquatersCollection(Collection<Headquaters> headquatersCollection) {
        this.headquatersCollection = headquatersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEnvironment != null ? numEnvironment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) object;
        if ((this.numEnvironment == null && other.numEnvironment != null) || (this.numEnvironment != null && !this.numEnvironment.equals(other.numEnvironment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Environment[ numEnvironment=" + numEnvironment + " ]";
    }
    
}
