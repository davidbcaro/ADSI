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
@Table(name = "identification_card")
@NamedQueries({
    @NamedQuery(name = "IdentificationCard.findAll", query = "SELECT i FROM IdentificationCard i")
    , @NamedQuery(name = "IdentificationCard.findByIdIdentificationCardNumber", query = "SELECT i FROM IdentificationCard i WHERE i.idIdentificationCardNumber = :idIdentificationCardNumber")
    , @NamedQuery(name = "IdentificationCard.findByName", query = "SELECT i FROM IdentificationCard i WHERE i.name = :name")
    , @NamedQuery(name = "IdentificationCard.findByStatus", query = "SELECT i FROM IdentificationCard i WHERE i.status = :status")
    , @NamedQuery(name = "IdentificationCard.findByLikeIdIdentificationCardNumber", query = "SELECT i FROM IdentificationCard i WHERE i.idIdentificationCardNumber LIKE :idIdentificationCardNumber")
    , @NamedQuery(name = "IdentificationCard.findByLikeName", query = "SELECT i FROM IdentificationCard i WHERE i.name LIKE :name ")    
    , @NamedQuery(name = "IdentificationCard.updatePrimaryKey", query = "UPDATE IdentificationCard i SET i.idIdentificationCardNumber= :ccNuevo WHERE i.idIdentificationCardNumber = :ccAntiguo")})
public class IdentificationCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_identification_card_number", nullable = false, length = 15)
    private String idIdentificationCardNumber;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationCard")
    private Collection<Customer> customerCollection;

    public IdentificationCard() {
    }

    public IdentificationCard(String idIdentificationCardNumber) {
        this.idIdentificationCardNumber = idIdentificationCardNumber;
    }

    public IdentificationCard(String idIdentificationCardNumber, String name) {
        this.idIdentificationCardNumber = idIdentificationCardNumber;
        this.name = name;
    }

    public String getIdIdentificationCardNumber() {
        return idIdentificationCardNumber;
    }

    public void setIdIdentificationCardNumber(String idIdentificationCardNumber) {
        this.idIdentificationCardNumber = idIdentificationCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdentificationCardNumber != null ? idIdentificationCardNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationCard)) {
            return false;
        }
        IdentificationCard other = (IdentificationCard) object;
        if ((this.idIdentificationCardNumber == null && other.idIdentificationCardNumber != null) || (this.idIdentificationCardNumber != null && !this.idIdentificationCardNumber.equals(other.idIdentificationCardNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.IdentificationCard[ idIdentificationCardNumber=" + idIdentificationCardNumber + " ]";
    }
    
}
