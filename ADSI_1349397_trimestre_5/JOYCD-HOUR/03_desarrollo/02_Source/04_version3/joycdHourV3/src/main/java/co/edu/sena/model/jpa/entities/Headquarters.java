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
@Table(name = "headquarters")
@NamedQueries({
    @NamedQuery(name = "Headquarters.findAll", query = "SELECT h FROM Headquarters h")
    , @NamedQuery(name = "Headquarters.findByNameHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.nameHeadquarters = :nameHeadquarters")
    , @NamedQuery(name = "Headquarters.findByDirection", query = "SELECT h FROM Headquarters h WHERE h.direction = :direction")
    , @NamedQuery(name = "Headquarters.findByStatus", query = "SELECT h FROM Headquarters h WHERE h.status = :status")
    ,@NamedQuery(name = "Headquarters.findByLikeNameHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.nameHeadquarters LIKE :nameHeadquarters")
    ,@NamedQuery(name = "Headquarters.findByLikeDirection", query = "SELECT h FROM Headquarters h WHERE h.direction LIKE :direction")
    , @NamedQuery(name = "Headquarters.updatePrimaryKey", query = "UPDATE Headquarters h SET h.nameHeadquarters = :headquartersNew WHERE h.nameHeadquarters = :headquartersOld")
})
public class Headquarters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_headquarters", nullable = false, length = 100)
    private String nameHeadquarters;
    @Basic(optional = false)
    @Column(name = "direction", nullable = false, length = 45)
    private String direction;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headquarters")
    private Collection<Environment> environmentCollection;

    public Headquarters() {
    }

    public Headquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    public Headquarters(String nameHeadquarters, String direction) {
        this.nameHeadquarters = nameHeadquarters;
        this.direction = direction;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        return "co.edu.sena.model.jpa.entities.Headquarters[ nameHeadquarters=" + nameHeadquarters + " ]";
    }

}
