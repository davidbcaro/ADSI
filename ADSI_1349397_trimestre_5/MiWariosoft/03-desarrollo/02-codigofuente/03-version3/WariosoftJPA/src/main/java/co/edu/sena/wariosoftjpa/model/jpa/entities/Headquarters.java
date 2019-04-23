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
@Table(name = "headquarters")
@NamedQueries({
    @NamedQuery(name = "Headquarters.findAll", query = "SELECT hq FROM Headquarters hq")
    ,@NamedQuery(name = "Headquarters.findAll", query = "SELECT hq FROM Headquarters hq")
    ,@NamedQuery(name = "Headquarters.findByHeadquarters", query = "SELECT hq FROM Headquarters hq WHERE hq.nameHeadquarters = :Headquarters")
    ,@NamedQuery(name = "Headquarters.findByAddress", query = "SELECT hq FROM Headquarters hq WHERE hq.address = :Address")
    ,@NamedQuery(name = "Headquarters.findByState", query = "SELECT hq FROM Headquarters hq WHERE hq.state = :State")
    ,@NamedQuery(name = "Headquarters.findByLikeHeadquarters", query = "SELECT hq FROM Headquarters hq WHERE hq.nameHeadquarters LIKE :Headquarters")
    ,@NamedQuery(name = "Headquarters.updatePrimaryKey", query = "UPDATE Headquarters hq SET hq.nameHeadquarters = :sedeNueva WHERE hq.nameHeadquarters = :sedeVieja")
})
public class Headquarters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_Headquarters", nullable = false, length = 100)
    private String nameHeadquarters;
    @Basic(optional = false)
    @Column(name = "address", nullable = false, length = 45)
    private String address;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headquarters")
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Headquarters[ nameHeadquarters=" + nameHeadquarters + " ]";
    }
    
}
