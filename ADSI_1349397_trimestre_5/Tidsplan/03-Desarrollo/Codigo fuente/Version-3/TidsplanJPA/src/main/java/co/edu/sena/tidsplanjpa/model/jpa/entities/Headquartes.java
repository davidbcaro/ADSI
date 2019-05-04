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
 * @author 1349397
 */
@Entity
@Table(name = "headquartes")
@NamedQueries({
        @NamedQuery(name = "Headquartes.findAll", query = "SELECT h FROM Headquartes h")
        , @NamedQuery(name = "Headquartes.findByNameHeadquartes", query = "SELECT h FROM Headquartes h WHERE h.nameHeadquartes = :nameHeadquartes")
        , @NamedQuery(name = "Headquartes.findByAddress", query = "SELECT h FROM Headquartes h WHERE h.address = :address")
        , @NamedQuery(name = "Headquartes.findByStatus", query = "SELECT h FROM Headquartes h WHERE h.status = :status")
        , @NamedQuery(name = "Headquartes.findByLikeNameHeadquartes", query = "SELECT h FROM Headquartes h WHERE h.nameHeadquartes like :headquartes")
        , @NamedQuery(name = "Headquartes.findByLikeAddress", query = "SELECT h FROM Headquartes h WHERE h.address like :address")
        , @NamedQuery(name = "Headquartes.updatePrimaryKey", query = "UPDATE Headquartes h SET h.nameHeadquartes = :newName WHERE h.nameHeadquartes = :oldName")})

public class Headquartes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_headquartes", nullable = false, length = 100)
    private String nameHeadquartes;
    @Basic(optional = false)
    @Column(name = "address", nullable = false, length = 45)
    private String address;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headquartes")
    private Collection<Environment> environmentCollection;

    public Headquartes() {
    }

    public Headquartes(String nameHeadquartes) {
        this.nameHeadquartes = nameHeadquartes;
    }

    public Headquartes(String nameHeadquartes, String address) {
        this.nameHeadquartes = nameHeadquartes;
        this.address = address;
    }

    public String getNameHeadquartes() {
        return nameHeadquartes;
    }

    public void setNameHeadquartes(String nameHeadquartes) {
        this.nameHeadquartes = nameHeadquartes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        hash += (nameHeadquartes != null ? nameHeadquartes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Headquartes)) {
            return false;
        }
        Headquartes other = (Headquartes) object;
        if ((this.nameHeadquartes == null && other.nameHeadquartes != null) || (this.nameHeadquartes != null && !this.nameHeadquartes.equals(other.nameHeadquartes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Headquartes[ nameHeadquartes=" + nameHeadquartes + " ]";
    }

}
