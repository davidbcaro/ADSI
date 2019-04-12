/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
@Table(name = "document", catalog = "EON", schema = "")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByidDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
    , @NamedQuery(name = "Document.findByname", query = "SELECT d FROM Document d WHERE d.name = :name")
    , @NamedQuery(name = "Document.findBystatus", query = "SELECT d FROM Document d WHERE d.status = :status")
    ,@NamedQuery(name = "Document.findBylikeidDocument", query = "SELECT d FROM Document d WHERE d.idDocument LIKE :idDocument")
    ,@NamedQuery(name = "Document.findByLikename", query = "SELECT d FROM Document d WHERE d.name LIKE :name")
    ,@NamedQuery(name = "Document.updatePrimaryKey", query = "UPDATE Document d SET d.idDocument = :idDocumentNuevo WHERE d.idDocument = :idDocumentViejo")
})
public class Document implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<Client> clientCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Document", nullable = false, length = 100)
    private String idDocument;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 45)
    private String name;
    @Column(name = "Status")
    private Boolean status;

    public Document() {
    }

    public Document(String idDocument) {
        this.idDocument = idDocument;
    }

    public Document(String idDocument, String name) {
        this.idDocument = idDocument;
        this.name = name;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Document[ idDocument=" + idDocument + " ]";
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

}
