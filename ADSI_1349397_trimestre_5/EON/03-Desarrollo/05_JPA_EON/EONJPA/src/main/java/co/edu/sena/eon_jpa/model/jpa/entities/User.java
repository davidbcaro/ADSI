/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
      , @NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :mail")
      , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
      , @NamedQuery(name = "User.findByDateEndind", query = "SELECT u FROM User u WHERE u.dateendind = :dateendind")
      , @NamedQuery(name = "User.findByDocumentNumber", query = "SELECT u FROM User u WHERE u.userPK.documentNumber = :documentNumber")
      , @NamedQuery(name = "User.findByIdDocument", query = "SELECT u FROM User u WHERE u.userPK.idDocument = :idDocument")
      , @NamedQuery(name = "User.findByLikeMail", query = "SELECT u FROM User u WHERE u.mail LIKE :mail")
      , @NamedQuery(name = "User.findByLikePassword", query = "SELECT u FROM User u WHERE u.password LIKE :password")
      , @NamedQuery(name = "User.findByLikeDateEndind", query = "SELECT u FROM User u WHERE u.dateendind LIKE :dateendind")
      , @NamedQuery(name = "User.findByLikeDocumentNumber", query = "SELECT u FROM User u WHERE u.userPK.documentNumber LIKE :documentNumber")
      , @NamedQuery(name = "User.findByLikeIdDocument", query = "SELECT u FROM User u WHERE u.userPK.idDocument LIKE :idDocument")
      ,@NamedQuery(name = "User.updatePrimaryKey", query = "UPDATE User u set u.userPK.documentNumber = :newNDocument,  u.userPK.idDocument = :newIdDocument WHERE u.userPK.documentNumber = :oldNDocument AND u.userPK.idDocument = :oldIdDocument")
})

public class User implements Serializable {

      private static final long serialVersionUID = 1L;
      @EmbeddedId
      protected UserPK userPK;
      @Basic(optional = false)
      @Column(name = "Mail", nullable = false, length = 60)
      private String mail;
      @Basic(optional = false)
      @Column(name = "Password", nullable = false, length = 20)
      private String password;
      @Column(name = "Date_endind")
      @Temporal(TemporalType.DATE)
      private Date dateendind;
      @JoinColumns({
            @JoinColumn(name = "document_Number", referencedColumnName = "document_Number", nullable = false, insertable = false, updatable = false)
            , @JoinColumn(name = "id_Document", referencedColumnName = "id_Document", nullable = false, insertable = false, updatable = false)})
      @OneToOne(optional = false)
      private Client client;

      public User() {
      }

      public User(UserPK userPK) {
            this.userPK = userPK;
      }

      public User(UserPK userPK, String mail, String password) {
            this.userPK = userPK;
            this.mail = mail;
            this.password = password;
      }

      public User(String documentNumber, String idDocument) {
            this.userPK = new UserPK(documentNumber, idDocument);
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

      public Date getDateendind() {
            return dateendind;
      }

      public void setDateendind(Date dateendind) {
            this.dateendind = dateendind;
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
            return "co.edu.sena.eon_jpa.model.jpa.entities.User[ userPK=" + userPK + " ]";
      }

}
