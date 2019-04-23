/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByDocumentNumber", query = "SELECT c FROM Client c WHERE c.clientPK.documentNumber = :documentNumber")
    , @NamedQuery(name = "Client.findByIdDocument", query = "SELECT c FROM Client c WHERE c.clientPK.idDocument = :idDocument")
    , @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Client.findBySecondName", query = "SELECT c FROM Client c WHERE c.secondName = :secondName")
    , @NamedQuery(name = "Client.findByFirstLastname", query = "SELECT c FROM Client c WHERE c.firstLastname = :firstLastname")
    , @NamedQuery(name = "Client.findBySecondLastname", query = "SELECT c FROM Client c WHERE c.secondLastname = :secondLastname")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientPK clientPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "first_Name", nullable = false, length = 20)
    private String firstName;
    @Size(max = 20)
    @Column(name = "second_Name", length = 20)
    private String secondName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "first_Lastname", nullable = false, length = 20)
    private String firstLastname;
    @Size(max = 20)
    @Column(name = "second_Lastname", length = 20)
    private String secondLastname;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private Teacher teacher;
    @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Document document;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<RoleHasClient> roleHasClientCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private User user;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @XmlTransient
    public Collection<RoleHasClient> getRoleHasClientCollection() {
        return roleHasClientCollection;
    }

    public void setRoleHasClientCollection(Collection<RoleHasClient> roleHasClientCollection) {
        this.roleHasClientCollection = roleHasClientCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "co.edu.sena.htmlwariosoft.model.entities.Client[ clientPK=" + clientPK + " ]";
    }
    
}
