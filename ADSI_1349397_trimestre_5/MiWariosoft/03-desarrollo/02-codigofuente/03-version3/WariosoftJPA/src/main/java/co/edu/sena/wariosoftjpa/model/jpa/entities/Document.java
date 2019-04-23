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
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    
    , @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
    , @NamedQuery(name = "Document.findByName", query = "SELECT d FROM Document d WHERE d.name = :name")
    , @NamedQuery(name = "Document.findByState", query = "SELECT d FROM Document d WHERE d.state = :state")
    , @NamedQuery(name = "Document.findByLikeIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument LIKE :idDocument")
    , @NamedQuery(name = "Document.findByLikeName", query = "SELECT d FROM Document d WHERE d.name LIKE :name")
    , @NamedQuery(name = "Document.updatePrimaryKey", query = "UPDATE Document d SET d.idDocument = :documentoNuevo WHERE d.idDocument = :documentoViejo")
})

public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Document", nullable = false, length = 10)
    private String idDocument;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<Client> clientCollection;

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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Document[ idDocument=" + idDocument + " ]";
    }

}
