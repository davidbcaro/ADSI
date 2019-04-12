/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByDocumentNumber", query = "SELECT c FROM Client c WHERE c.clientPK.documentNumber = :documentNumber")
    , @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Client.findBySecondName", query = "SELECT c FROM Client c WHERE c.secondName = :secondName")
    , @NamedQuery(name = "Client.findByFirstLastName", query = "SELECT c FROM Client c WHERE c.firstLastname = :firstLastname")
    , @NamedQuery(name = "Client.findBySecondLastName", query = "SELECT c FROM Client c WHERE c.secondLastname = :secondLastname")
    , @NamedQuery(name = "Client.findByIdDocument", query = "SELECT c FROM Client c WHERE c.clientPK.idDocument = :idDocument")
        
    , @NamedQuery(name = "Client.findByLikeDocumentNumber", query = "SELECT c FROM Client c WHERE c.clientPK.documentNumber LIKE :documentNumber")
    , @NamedQuery(name = "Client.findByLikeFirstName", query = "SELECT c FROM Client c WHERE c.firstName LIKE :firstName")
    , @NamedQuery(name = "Client.findByLikeFecondName", query = "SELECT c FROM Client c WHERE c.secondName LIKE :secondName")
    , @NamedQuery(name = "Client.findByLikeFirstLastName", query = "SELECT c FROM Client c WHERE c.firstLastname LIKE :firstLastname")
    , @NamedQuery(name = "Client.findByLikeSecondLastName", query = "SELECT c FROM Client c WHERE c.secondLastname LIKE :secondLastname")
    , @NamedQuery(name = "Client.findByLikeIdDocument", query = "SELECT c FROM Client c WHERE c.clientPK.idDocument LIKE :idDocument")

      ,@NamedQuery(name= "Client.updatePrimarykey", query = "UPDATE Client c set c.clientPK.documentNumber = :newNDocument,  c.clientPK.idDocument = :newIdDocument WHERE c.clientPK.documentNumber = :oldNDocument and  c.clientPK.idDocument = :oldIdDocument")})



public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientPK clientPK;
    @Basic(optional = false)
    @Column(name = "first_Name", nullable = false, length = 15)
    private String firstName;
    @Column(name = "second_Name", length = 20)
    private String secondName;
    @Basic(optional = false)
    @Column(name = "first_Last_name", nullable = false, length = 20)
    private String firstLastname;
    @Column(name = "second_Last_name", length = 20)
    private String secondLastname;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;

    public Client() {
    }

    public Client(ClientPK clientPK) {
        this.clientPK = clientPK;
    }

    public Client(ClientPK clientPK, String firstName, String firstLastname) {
        this.clientPK = clientPK;
        this.firstName = firstName;
        this.firstLastname = firstLastname;
    }

    public Client(String documentNumber, String idDocument) {
        this.clientPK = new ClientPK(documentNumber, idDocument);
    }

    public ClientPK getClientPK() {
        return clientPK;
    }

    public void setClientPK(ClientPK clientPK) {
        this.clientPK = clientPK;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientPK != null ? clientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientPK == null && other.clientPK != null) || (this.clientPK != null && !this.clientPK.equals(other.clientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Client[ clientPK=" + clientPK + " ]";
    }
    
}
