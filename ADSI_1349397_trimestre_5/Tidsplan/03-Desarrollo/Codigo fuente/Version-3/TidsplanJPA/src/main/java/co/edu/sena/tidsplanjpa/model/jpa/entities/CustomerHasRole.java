/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
@Table(name = "customer_has_role")
@NamedQueries({
    @NamedQuery(name = "CustomerHasRole.findAll", query = "SELECT c FROM CustomerHasRole c")
    , @NamedQuery(name = "CustomerHasRole.findByDocument", query = "SELECT c FROM CustomerHasRole c WHERE c.customerHasRolePK.document = :document")
    , @NamedQuery(name = "CustomerHasRole.findByLikeDocument", query = "SELECT c FROM CustomerHasRole c WHERE c.customerHasRolePK.document like :document")
    , @NamedQuery(name = "CustomerHasRole.findByDocumentNumber", query = "SELECT c FROM CustomerHasRole c WHERE c.customerHasRolePK.documentNumber = :documentNumber")
    , @NamedQuery(name = "CustomerHasRole.findByLikeDocumentNumber", query = "SELECT c FROM CustomerHasRole c WHERE c.customerHasRolePK.documentNumber like :documentNumber")
    , @NamedQuery(name = "CustomerHasRole.findByIdRol", query = "SELECT c FROM CustomerHasRole c WHERE c.role.idRol = :idRol")
    , @NamedQuery(name = "CustomerHasRole.findByLikeIdRol", query = "SELECT c FROM CustomerHasRole c WHERE c.role.idRol like :idRol")
    , @NamedQuery(name = "CustomerHasRole.findByStatus", query = "SELECT c FROM CustomerHasRole c WHERE c.status = :status")
    , @NamedQuery(name = "CustomerHasRole.updatePrimaryKey", query = "UPDATE CustomerHasRole c set c.customerHasRolePK.document = :newDocument, c.customerHasRolePK.documentNumber = :newDocumentNumber, c.customerHasRolePK.idrol = :newIdRol WHERE c.customerHasRolePK.document = :oldDocument and c.customerHasRolePK.documentNumber = :oldDocumentNumber and c.customerHasRolePK.idrol = :oldIdRol")})

public class CustomerHasRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerHasRolePK customerHasRolePK;
    @Column(name = "status")
    private Boolean status;
    @JoinColumns({
        @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document_number", referencedColumnName = "document_number", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "idrol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public CustomerHasRole() {
    }

    public CustomerHasRole(CustomerHasRolePK customerHasRolePK) {
        this.customerHasRolePK = customerHasRolePK;
    }

    public CustomerHasRole(String document, String documentNumber, String idrol) {
        this.customerHasRolePK = new CustomerHasRolePK(document, documentNumber, idrol);
    }

    public CustomerHasRolePK getCustomerHasRolePK() {
        return customerHasRolePK;
    }

    public void setCustomerHasRolePK(CustomerHasRolePK customerHasRolePK) {
        this.customerHasRolePK = customerHasRolePK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        hash += (customerHasRolePK != null ? customerHasRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerHasRole)) {
            return false;
        }
        CustomerHasRole other = (CustomerHasRole) object;
        if ((this.customerHasRolePK == null && other.customerHasRolePK != null) || (this.customerHasRolePK != null && !this.customerHasRolePK.equals(other.customerHasRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.CustomerHasRole[ customerHasRolePK=" + customerHasRolePK + " ]";
    }
    
}
