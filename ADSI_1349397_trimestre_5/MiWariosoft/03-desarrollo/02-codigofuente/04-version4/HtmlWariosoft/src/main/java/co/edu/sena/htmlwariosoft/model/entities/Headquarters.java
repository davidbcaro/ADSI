/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "headquarters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headquarters.findAll", query = "SELECT h FROM Headquarters h")
    , @NamedQuery(name = "Headquarters.findByNameHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.nameHeadquarters = :nameHeadquarters")
    , @NamedQuery(name = "Headquarters.findByAddress", query = "SELECT h FROM Headquarters h WHERE h.address = :address")
    , @NamedQuery(name = "Headquarters.findByState", query = "SELECT h FROM Headquarters h WHERE h.state = :state")})
public class Headquarters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name_Headquarters", nullable = false, length = 100)
    private String nameHeadquarters;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address", nullable = false, length = 45)
    private String address;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headquarters", fetch = FetchType.LAZY)
    private Collection<Environment> environmentCollection;

    public Headquarters() {
    }

    public Headquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    public Headquarters(String nameHeadquarters, String address) {
        this.nameHeadquarters = nameHeadquarters;
        this.address = address;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Environment> getEnvironmentCollection() {
        return environmentCollection;
    }

    public void setEnvironmentCollection(Collection<Environment> environmentCollection) {
        this.environmentCollection = environmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameHeadquarters != null ? nameHeadquarters.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Headquarters)) {
            return false;
        }
        Headquarters other = (Headquarters) object;
        if ((this.nameHeadquarters == null && other.nameHeadquarters != null) || (this.nameHeadquarters != null && !this.nameHeadquarters.equals(other.nameHeadquarters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.Headquarters[ nameHeadquarters=" + nameHeadquarters + " ]";
    }
    
}
