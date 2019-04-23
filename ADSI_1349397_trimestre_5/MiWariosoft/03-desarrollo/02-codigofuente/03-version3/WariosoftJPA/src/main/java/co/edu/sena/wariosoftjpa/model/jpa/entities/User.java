/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT c FROM User c")
    ,@NamedQuery(name = "User.findByEmail", query = "SELECT c FROM User c WHERE c.email = :email ")
    ,@NamedQuery(name = "User.findByPassword", query = "SELECT c FROM User c WHERE c.password = :password ")
    ,@NamedQuery(name = "User.findByDateTerminate", query = "SELECT c FROM User c WHERE c.dateTerminate = :dateTerminate ")
    ,@NamedQuery(name = "User.findByIdDocument", query = "SELECT c FROM User c WHERE c.userPK.idDocument = :idDocument ")
    ,@NamedQuery(name = "User.findByDocumentNumber", query = "SELECT c FROM User c WHERE c.userPK.documentNumber = :documentNumber ")

    , @NamedQuery(name = "User.findByLikeIdDocument", query = "SELECT c FROM User c WHERE c.userPK.idDocument LIKE :idDocument ")
    , @NamedQuery(name = "User.findByLikeDocumentNumber", query = "SELECT c FROM User c WHERE c.userPK.documentNumber LIKE :documentNumber ")

    ,@NamedQuery(name = "User.updatePk", query = "UPDATE User c set c.userPK.idDocument = :idNuevo,  c.userPK.documentNumber = :documentoNuevo WHERE  c.userPK.idDocument = :idViejo and c.userPK.documentNumber = :documentoViejo ")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 70)
    private String password;
    @Basic(optional = false)
    @Column(name = "date_Terminate", nullable = false, length = 45)
    private String dateTerminate;
    @JoinColumns({
        @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Client client;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(UserPK userPK, String email, String password, String dateTerminate) {
        this.userPK = userPK;
        this.email = email;
        this.password = password;
        this.dateTerminate = dateTerminate;
    }

    public User(String idDocument, String documentNumber) {
        this.userPK = new UserPK(idDocument, documentNumber);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateTerminate() {
        return dateTerminate;
    }

    public void setDateTerminate(String dateTerminate) {
        this.dateTerminate = dateTerminate;
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
        hash += (userPK != null ? userPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userPK == null && other.userPK != null) || (this.userPK != null && !this.userPK.equals(other.userPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.User[ userPK=" + userPK + " ]";
    }
    
}
