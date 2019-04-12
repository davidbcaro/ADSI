/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    ,@NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")
    ,@NamedQuery(name = "Role.findByStatus", query = "SELECT r FROM Role r WHERE r.status = :status")
    ,@NamedQuery(name = "Role.findByIdRole", query = "SELECT r FROM Role r WHERE r.idRole = :idRole")
    ,@NamedQuery(name = "Role.findBylikeIdRole", query = "SELECT r FROM Role r WHERE r.idRole LIKE :idRole")
    ,@NamedQuery(name = "Role.findByLikeDescription", query = "SELECT r FROM Role r WHERE r.description LIKE :description")
    ,@NamedQuery(name = "Role.updatePrimaryKey", query = "UPDATE Role r SET r.idRole = :idRoleNuevo WHERE r.idRole = :idRoleViejo")
})

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Role", nullable = false, length = 30)
    private String idRole;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 100)
    private String description;
    @Column(name = "Status")
    private Boolean status;

    public Role() {
    }

    public Role(String idRole) {
        this.idRole = idRole;
    }

    public Role(String idRole, String description) {
        this.idRole = idRole;
        this.description = description;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Role[ idRole=" + idRole + " ]";
    }

}
