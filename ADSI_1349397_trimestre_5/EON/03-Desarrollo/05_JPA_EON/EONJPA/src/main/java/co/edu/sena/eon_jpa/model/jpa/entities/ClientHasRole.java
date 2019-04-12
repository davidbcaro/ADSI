/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "client_has_role")
@NamedQueries({
    @NamedQuery(name = "ClientHasRole.findAll", query = "SELECT c FROM ClientHasRole c")
, @NamedQuery(name = "ClientHasRole.findByStatus", query = "SELECT r FROM ClientHasRole r WHERE r.status = :status")
    , @NamedQuery(name = "ClientHasRole.findByIdRole", query = "SELECT r FROM ClientHasRole r WHERE r.clientHasRolePK.idRole = :idRole")
    , @NamedQuery(name = "ClientHasRole.findByDocumentNumber", query = "SELECT r FROM ClientHasRole r WHERE r.clientHasRolePK.documentNumber = :documentNumber")
    , @NamedQuery(name = "ClientHasRole.findByIdDocument", query = "SELECT r FROM ClientHasRole r WHERE r.clientHasRolePK.idDocument = :idDocument")
        
    , @NamedQuery(name = "ClientHasRole.findByLikeIdRole", query = "SELECT r FROM ClientHasRole r WHERE r.clientHasRolePK.idRole LIKE :idRole")
    , @NamedQuery(name = "ClientHasRole.findByLikeDocumentNumber", query = "SELECT r FROM ClientHasRole r WHERE r.clientHasRolePK.documentNumber LIKE :documentNumber")
    , @NamedQuery(name = "ClientHasRole.findByLikeIdDocument", query = "SELECT r FROM ClientHasRole r WHERE r.clientHasRolePK.idDocument LIKE :idDocument")

   
    ,@NamedQuery(name = "ClientHasRole.updatePrimaryKey", query = "UPDATE ClientHasRole r set r.clientHasRolePK.documentNumber = :newNDocument,  r.clientHasRolePK.idDocument = :newIdDocument,  r.clientHasRolePK.idRole = :newIdRole WHERE r.clientHasRolePK.documentNumber = :oldNDocument and  r.clientHasRolePK.idDocument = :oldIdDocument and r.clientHasRolePK.idRole = :oldIdRole")
   

})
public class ClientHasRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientHasRolePK clientHasRolePK;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumns({
        @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "id_Role", referencedColumnName = "id_Role", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public ClientHasRole() {
    }

    public ClientHasRole(ClientHasRolePK clientHasRolePK) {
        this.clientHasRolePK = clientHasRolePK;
    }

    public ClientHasRole(String documentNumber, String idDocument, String idRole) {
        this.clientHasRolePK = new ClientHasRolePK(documentNumber, idDocument, idRole);
    }

    public ClientHasRolePK getClientHasRolePK() {
        return clientHasRolePK;
    }

    public void setClientHasRolePK(ClientHasRolePK clientHasRolePK) {
        this.clientHasRolePK = clientHasRolePK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientHasRolePK != null ? clientHasRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientHasRole)) {
            return false;
        }
        ClientHasRole other = (ClientHasRole) object;
        if ((this.clientHasRolePK == null && other.clientHasRolePK != null) || (this.clientHasRolePK != null && !this.clientHasRolePK.equals(other.clientHasRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.ClientHasRole[ clientHasRolePK=" + clientHasRolePK + " ]";
    }

}
