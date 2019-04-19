/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    , @NamedQuery(name = "Customer.findByDocumentType", query = "SELECT c FROM Customer c WHERE c.customerPK.documentType = :documentType")
    , @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Customer.findBySecondName", query = "SELECT c FROM Customer c WHERE c.secondName = :secondName")
    , @NamedQuery(name = "Customer.findByFirstLastName", query = "SELECT c FROM Customer c WHERE c.firstLastName = :firstLastName")
    , @NamedQuery(name = "Customer.findBySecondLastName", query = "SELECT c FROM Customer c WHERE c.secondLastName = :secondLastName")
    , @NamedQuery(name = "Customer.findByIdentificationCardNumber", query = "SELECT c FROM Customer c WHERE c.customerPK.identificationCardNumber = :identificationCardNumber")
    , @NamedQuery(name = "Customer.findByLikeDocumentType", query = "SELECT c FROM Customer c WHERE c.customerPK.documentType LIKE :documentType")
    , @NamedQuery(name = "Customer.findByLikeFirstName", query = "SELECT c FROM Customer c WHERE c.firstName LIKE :firstName")
    , @NamedQuery(name = "Customer.findByLikeSecondName", query = "SELECT c FROM Customer c WHERE c.secondName LIKE :secondName")
    , @NamedQuery(name = "Customer.findByLikeFirstLastName", query = "SELECT c FROM Customer c WHERE c.firstLastName LIKE :firstLastName")
    , @NamedQuery(name = "Customer.findByLikeSecondLastName", query = "SELECT c FROM Customer c WHERE c.secondLastName LIKE :secondLastName")
    , @NamedQuery(name = "Customer.findByLikeIdentificationCardNumber", query = "SELECT c FROM Customer c WHERE c.customerPK.identificationCardNumber LIKE :identificationCardNumber")    
    , @NamedQuery(name = "Customer.UpdatePK", query = "UPDATE Customer c SET c.customerPK.documentType  = :documentoNuevo, c.customerPK.identificationCardNumber = :TarjetadeIdentificaciónNuevo WHERE c.customerPK.documentType = :documentoViejo and c.customerPK.identificationCardNumber = :TarjetadeIdentificaciónViejo" )})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerPK customerPK;
//    @Basic(optional = false)
//    @Column(name = "document_type", nullable = false, length = 25)
//    private String documentType;
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Column(name = "second_name", length = 45)
    private String secondName;
    @Basic(optional = false)
    @Column(name = "first_last_name", nullable = false, length = 45)
    private String firstLastName;
    @Column(name = "second_last_name", length = 45)
    private String secondLastName;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @JoinTable(name = "customer_has_role", joinColumns = {
        @JoinColumn(name = "person_document_type", referencedColumnName = "document_type", nullable = false)
        , @JoinColumn(name = "identification_card_number", referencedColumnName = "identification_card_number", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)})
    @ManyToMany
    private Collection<Role> roleCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Instructor instructor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private User user;
    @JoinColumn(name = "identification_card_number", referencedColumnName = "id_identification_card_number", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IdentificationCard identificationCard;

    public Customer() {
    }

    public Customer(CustomerPK customerPK) {
        this.customerPK = customerPK;
    }

    public Customer(CustomerPK customerPK, String firstName, String firstLastName) {
        this.customerPK = customerPK;
        this.firstName = firstName;
        this.firstLastName = firstLastName;
    }

    public Customer(String documentType, String identificationCardNumber) {
        this.customerPK = new CustomerPK(documentType, identificationCardNumber);
    }

    public CustomerPK getCustomerPK() {
        return customerPK;
    }

    public void setCustomerPK(CustomerPK customerPK) {
        this.customerPK = customerPK;
    }
//     public String getDocumentType() {
//        return documentType;
//    }
//
//    public void setDocumentType(String documentType) {
//        this.documentType = documentType;
//    }

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

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
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

    public IdentificationCard getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(IdentificationCard identificationCard) {
        this.identificationCard = identificationCard;
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
        return "co.edu.sena.model.jpa.entities.Customer[ customerPK=" + customerPK + " ]";
    }
    
}
