/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByLikeEmail", query = "SELECT u FROM User u WHERE u.email LIKE :email")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByLikePassword", query = "SELECT u FROM User u WHERE u.password LIKE :password")
    , @NamedQuery(name = "User.findByDocumentType", query = "SELECT u FROM User u WHERE u.userPK.documentType = :documentType")
    , @NamedQuery(name = "User.findByLikeDocumentType", query = "SELECT u FROM User u WHERE u.userPK.documentType LIKE :documentType")
    , @NamedQuery(name = "User.findByIdentificationCardNumber", query = "SELECT u FROM User u WHERE u.userPK.identificationCardNumber = :identificationCardNumber")
    , @NamedQuery(name = "User.findByLikeIdentificationCardNumber", query = "SELECT u FROM User u WHERE u.userPK.identificationCardNumber LIKE :identificationCardNumber")
    ,@NamedQuery(name= "User.updatePrimaryKey", query = "UPDATE User u set u.userPK.documentType = :documentTypeNew,  u.userPK.identificationCardNumber = :identificationCardNumberNew WHERE u.userPK.documentType = :documentTypeOld and  u.userPK.identificationCardNumber = :identificationCardNumberOld")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @JoinColumns({
        @JoinColumn(name = "document_type", referencedColumnName = "document_type", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "identification_card_number", referencedColumnName = "identification_card_number", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Customer customer;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(UserPK userPK, String email, String password) {
        this.userPK = userPK;
        this.email = email;
        this.password = password;
    }

    public User(String documentType, String identificationCardNumber) {
        this.userPK = new UserPK(documentType, identificationCardNumber);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        return "co.edu.sena.model.jpa.entities.User[ userPK=" + userPK + " ]";
    }
    
}
