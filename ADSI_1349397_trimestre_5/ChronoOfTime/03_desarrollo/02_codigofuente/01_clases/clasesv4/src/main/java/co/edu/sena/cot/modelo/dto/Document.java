/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByDocument", query = "SELECT d FROM Document d WHERE d.document = :document")
    , @NamedQuery(name = "Document.findByName", query = "SELECT d FROM Document d WHERE d.name = :name")
    , @NamedQuery(name = "Document.findByState", query = "SELECT d FROM Document d WHERE d.state = :state")
    , @NamedQuery(name = "Document.findByLikeDocument", query = "SELECT d FROM Document d WHERE d.document LIKE :document")
    , @NamedQuery(name = "Document.findByLikeName", query = "SELECT d FROM Document d WHERE d.name LIKE :name")
    ,@NamedQuery(name = "Document.updatePK", query = "UPDATE Document d SET d.document = :llaveNueva WHERE d.document = :llaveVieja")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "document", nullable = false, length = 10)
    private String document;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document1")
    private Collection<Person> personCollection;

    public Document() {
    }

    public Document(String document) {
        this.document = document;
    }

    public Document(String document, String name, boolean state) {
        this.document = document;
        this.name = name;
        this.state = state;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Document[ document=" + document + " ]";
    }

}
