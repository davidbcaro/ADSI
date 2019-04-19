/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByIdRole", query = "SELECT r FROM Role r WHERE r.idRole = :idRole")
    , @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")
    , @NamedQuery(name = "Role.findByStatus", query = "SELECT r FROM Role r WHERE r.status = :status")
    , @NamedQuery(name = "Role.findByLikeIdRole", query = "SELECT r FROM Role r WHERE r.idRole LIKE :idRole")
    , @NamedQuery (name = "Role.findByLikeDescription", query= "SELECT r FROM Role r WHERE r.description LIKE :description ")    
    , @NamedQuery(name = "Role.updatePrimaryKey", query = "UPDATE Role r SET r.idRole= :administradorNuevo WHERE r.idRole = :administradorAntiguo")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_role", nullable = false, length = 20)
    private String idRole;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @ManyToMany(mappedBy = "roleCollection")
    private Collection<Customer> customerCollection;

    public Role() {
    }

    public Role(String idRole) {
        this.idRole = idRole;
    }

    public Role(String idRole, String description, boolean status) {
        this.idRole = idRole;
        this.description = description;
        this.status = status;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Role[ idRole=" + idRole + " ]";
    }
    
}
