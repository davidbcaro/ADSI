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
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    ,@NamedQuery(name = "Role.findByIdRole", query = "SELECT r FROM Role r WHERE r.idRole = :idRole")
    ,@NamedQuery(name = "Role.findByLikeIdRole", query = "SELECT r FROM Role r WHERE r.idRole LIKE :idRole")
    ,@NamedQuery(name = "Role.findByDescriptionRole", query = "SELECT r FROM Role r WHERE r.descriptionRole = :descriptionRole")
    ,@NamedQuery(name = "Role.findByState", query = "SELECT r FROM Role r WHERE r.state = :state"),
     @NamedQuery(name = "Role.updatePk", query = "UPDATE Role r SET r.idRole = :documentoNuevo WHERE r.idRole = :documentoViejo")
})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Role", nullable = false, length = 20)
    private String idRole;
    @Basic(optional = false)
    @Column(name = "description_Role", nullable = false, length = 100)
    private String descriptionRole;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<RoleHasClient> roleHasClientCollection;

    public Role() {
    }

    public Role(String idRole) {
        this.idRole = idRole;
    }

    public Role(String idRole, String descriptionRole) {
        this.idRole = idRole;
        this.descriptionRole = descriptionRole;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Collection<RoleHasClient> getRoleHasClientCollection() {
        return roleHasClientCollection;
    }

    public void setRoleHasClientCollection(Collection<RoleHasClient> roleHasClientCollection) {
        this.roleHasClientCollection = roleHasClientCollection;
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Role[ idRole=" + idRole + " ]";
    }
    
}
