/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByDocument", query = "SELECT u FROM User u WHERE u.userPK.document = :document")
    , @NamedQuery(name = "User.findByLikeDocument", query = "SELECT u FROM User u WHERE u.userPK.document like :document")
    , @NamedQuery(name = "User.findByDocumentNumber", query = "SELECT u FROM User u WHERE u.userPK.documentNumber = :documentNumber")
    , @NamedQuery(name = "User.findByLikeDocumentNumber", query = "SELECT u FROM User u WHERE u.userPK.documentNumber like :documentNumber")
    , @NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :mail")
    , @NamedQuery(name = "User.findByLikeMail", query = "SELECT u FROM User u WHERE u.mail like :mail")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByLikePassword", query = "SELECT u FROM User u WHERE u.password like :password")
    , @NamedQuery(name = "User.findByEndDate", query = "SELECT u FROM User u WHERE u.endDate = :endDate")
    , @NamedQuery(name = "User.updatePrimaryKey", query = "UPDATE User u set u.userPK.documentNumber = :newDocumentNumber, u.userPK.document = :newDocument WHERE u.userPK.documentNumber = :oldDocumentNumber and u.userPK.document = :oldDocument")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @Column(name = "mail", nullable = false, length = 100)
    private String mail;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic(optional = false)
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumns({
        @JoinColumn(name = "document_number", referencedColumnName = "document_number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Customer customer;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(UserPK userPK, String mail, String password, Date endDate) {
        this.userPK = userPK;
        this.mail = mail;
        this.password = password;
        this.endDate = endDate;
    }

    public User(String document, String documentNumber) {
        this.userPK = new UserPK(document, documentNumber);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.User[ userPK=" + userPK + " ]";
    }
    
}
