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
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
    , @NamedQuery(name = "Document.findByTypeDocument", query = "SELECT d FROM Document d WHERE d.typeDocument = :typeDocument")
    , @NamedQuery(name = "Document.findByStatus", query = "SELECT d FROM Document d WHERE d.status = :status")
    , @NamedQuery(name = "Document.findByLikeIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument like :idDocument")
    , @NamedQuery(name = "Document.findByLikeTypeDocument", query = "SELECT d FROM Document d WHERE d.typeDocument like :typeDocument")
    , @NamedQuery(name = "Document.updatePrimaryKey", query = "UPDATE Document d SET d.idDocument = :newKey WHERE d.idDocument = :oldKey")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_document", nullable = false, length = 20)
    private String idDocument;
    @Basic(optional = false)
    @Column(name = "type_document", nullable = false, length = 45)
    private String typeDocument;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document1")
    private Collection<Customer> customerCollection;

    public Document() {
    }

    public Document(String idDocument) {
        this.idDocument = idDocument;
    }

    public Document(String idDocument, String typeDocument) {
        this.idDocument = idDocument;
        this.typeDocument = typeDocument;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Document[ idDocument=" + idDocument + " ]";
    }

}
