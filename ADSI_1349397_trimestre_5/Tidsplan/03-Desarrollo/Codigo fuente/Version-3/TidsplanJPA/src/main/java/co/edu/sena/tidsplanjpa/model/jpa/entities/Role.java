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
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByIdRol", query = "SELECT r FROM Role r WHERE r.idRol = :idRol")
    , @NamedQuery(name = "Role.findByLikeIdRol", query = "SELECT r FROM Role r WHERE r.idRol like :idRol")
    , @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")
    , @NamedQuery(name = "Role.findByLikeDescription", query = "SELECT r FROM Role r WHERE r.description like :description")
    , @NamedQuery(name = "Role.findByStatus", query = "SELECT r FROM Role r WHERE r.status = :status")
    , @NamedQuery(name = "Role.updatePrimaryKey", query = "UPDATE Role r SET r.idRol = :newRol WHERE r.idRol = :oldRol")})


public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false, length = 20)
    private String idRol;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<CustomerHasRole> customerHasRoleCollection;

    public Role() {
    }

    public Role(String idRol) {
        this.idRol = idRol;
    }

    public Role(String idRol, String description) {
        this.idRol = idRol;
        this.description = description;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<CustomerHasRole> getCustomerHasRoleCollection() {
        return customerHasRoleCollection;
    }

    public void setCustomerHasRoleCollection(Collection<CustomerHasRole> customerHasRoleCollection) {
        this.customerHasRoleCollection = customerHasRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Role[ idRol=" + idRol + " ]";
    }
    
}
