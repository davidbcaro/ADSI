/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "role_has_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleHasClient.findAll", query = "SELECT r FROM RoleHasClient r")
    , @NamedQuery(name = "RoleHasClient.findByIdDocument", query = "SELECT r FROM RoleHasClient r WHERE r.roleHasClientPK.idDocument = :idDocument")
    , @NamedQuery(name = "RoleHasClient.findByDocumentNumber", query = "SELECT r FROM RoleHasClient r WHERE r.roleHasClientPK.documentNumber = :documentNumber")
    , @NamedQuery(name = "RoleHasClient.findByIdRole", query = "SELECT r FROM RoleHasClient r WHERE r.roleHasClientPK.idRole = :idRole")
    , @NamedQuery(name = "RoleHasClient.findByState", query = "SELECT r FROM RoleHasClient r WHERE r.state = :state")})
public class RoleHasClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleHasClientPK roleHasClientPK;
    @Column(name = "state")
    private Boolean state;
    @JoinColumn(name = "id_Role", referencedColumnName = "id_Role", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;
    @JoinColumns({
        @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public RoleHasClient() {
    }

    public RoleHasClient(RoleHasClientPK roleHasClientPK) {
        this.roleHasClientPK = roleHasClientPK;
    }

    public RoleHasClient(String idDocument, String documentNumber, String idRole) {
        this.roleHasClientPK = new RoleHasClientPK(idDocument, documentNumber, idRole);
    }

    public RoleHasClientPK getRoleHasClientPK() {
        return roleHasClientPK;
    }

    public void setRoleHasClientPK(RoleHasClientPK roleHasClientPK) {
        this.roleHasClientPK = roleHasClientPK;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleHasClientPK != null ? roleHasClientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleHasClient)) {
            return false;
        }
        RoleHasClient other = (RoleHasClient) object;
        if ((this.roleHasClientPK == null && other.roleHasClientPK != null) || (this.roleHasClientPK != null && !this.roleHasClientPK.equals(other.roleHasClientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.RoleHasClient[ roleHasClientPK=" + roleHasClientPK + " ]";
    }
    
}
