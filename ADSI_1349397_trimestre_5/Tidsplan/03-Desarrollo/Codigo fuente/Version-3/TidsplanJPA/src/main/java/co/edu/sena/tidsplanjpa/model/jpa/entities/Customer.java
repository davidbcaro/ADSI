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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
        , @NamedQuery(name = "Customer.findByDocument", query = "SELECT c FROM Customer c WHERE c.customerPK.document = :document " )
        , @NamedQuery(name = "Customer.findByLikeDocument", query = "SELECT c FROM Customer c WHERE c.customerPK.document  like :document")
        , @NamedQuery(name = "Customer.findByDocumentNumber", query = "SELECT c FROM Customer c WHERE c.customerPK.documentNumber = :documentNumber")
        , @NamedQuery(name = "Customer.findByLikeDocumentNumber", query = "SELECT c FROM Customer c WHERE c.customerPK.documentNumber like :documentNumber")
        , @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName")
        , @NamedQuery(name = "Customer.findByLikeFirstName", query = "SELECT c FROM Customer c WHERE c.firstName like :firstName")
        , @NamedQuery(name = "Customer.findBySecondName", query = "SELECT c FROM Customer c WHERE c.secondName = :secondName")
        , @NamedQuery(name = "Customer.findByLikeSecondName", query = "SELECT c FROM Customer c WHERE c.secondName like :secondName")
        , @NamedQuery(name = "Customer.findBySurname", query = "SELECT c FROM Customer c WHERE c.surname = :surname")
        , @NamedQuery(name = "Customer.findByLikeSurname", query = "SELECT c FROM Customer c WHERE c.surname like :surname")
        , @NamedQuery(name = "Customer.findBySecondSurname", query = "SELECT c FROM Customer c WHERE c.secondSurname = :secondSurname")
        , @NamedQuery(name = "Customer.findByLikeSecondSurname", query = "SELECT c FROM Customer c WHERE c.secondSurname like :secondSurname")
        , @NamedQuery(name = "Customer.updatePrimaryKey", query = "UPDATE Customer c set c.customerPK.document = :newDocument, c.customerPK.documentNumber = :newDocumentNumber WHERE c.customerPK.document = :oldDocument and c.customerPK.documentNumber = :oldDocumentNumber")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerPK customerPK;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Column(name = "second_name", length = 20)
    private String secondName;
    @Basic(optional = false)
    @Column(name = "surname", nullable = false, length = 20)
    private String surname;
    @Column(name = "second_surname", length = 20)
    private String secondSurname;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<CustomerHasRole> customerHasRoleCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Instructor instructor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private User user;
    @JoinColumn(name = "document", referencedColumnName = "id_document", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document1;

    public Customer() {
    }

    public Customer(CustomerPK customerPK) {
        this.customerPK = customerPK;
    }

    public Customer(CustomerPK customerPK, String firstName, String surname) {
        this.customerPK = customerPK;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Customer(String document, String documentNumber) {
        this.customerPK = new CustomerPK(document, documentNumber);
    }

    public CustomerPK getCustomerPK() {
        return customerPK;
    }

    public void setCustomerPK(CustomerPK customerPK) {
        this.customerPK = customerPK;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Collection<CustomerHasRole> getCustomerHasRoleCollection() {
        return customerHasRoleCollection;
    }

    public void setCustomerHasRoleCollection(Collection<CustomerHasRole> customerHasRoleCollection) {
        this.customerHasRoleCollection = customerHasRoleCollection;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getDocument1() {
        return document1;
    }

    public void setDocument1(Document document1) {
        this.document1 = document1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerPK != null ? customerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerPK == null && other.customerPK != null) || (this.customerPK != null && !this.customerPK.equals(other.customerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Customer[ customerPK=" + customerPK + " ]";
    }

}
