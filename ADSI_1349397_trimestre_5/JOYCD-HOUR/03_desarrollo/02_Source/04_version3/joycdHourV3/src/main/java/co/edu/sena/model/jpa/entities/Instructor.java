/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "instructor")
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findByDocumentType", query = "SELECT i FROM Instructor i WHERE i.instructorPK.documentType = :documentType")
    , @NamedQuery(name = "Instructor.findByIdentificationCard", query = "SELECT i FROM Instructor i WHERE i.instructorPK.identificationCard = :identificationCard")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstructorPK instructorPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Availability> availabilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Schedule> scheduleCollection;
    @JoinColumn(name = "type_bonding", referencedColumnName = "type_bonding", nullable = false)
    @ManyToOne(optional = false)
    private Bonding typeBonding;
    @JoinColumns({
        @JoinColumn(name = "document_type", referencedColumnName = "document_type", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "identification_card", referencedColumnName = "identification_card_number", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "name_speciality", referencedColumnName = "name_speciality", nullable = false)
    @ManyToOne(optional = false)
    private Speciality nameSpeciality;

    public Instructor() {
    }

    public Instructor(InstructorPK instructorPK) {
        this.instructorPK = instructorPK;
    }

    public Instructor(String documentType, String identificationCard) {
        this.instructorPK = new InstructorPK(documentType, identificationCard);
    }

    public InstructorPK getInstructorPK() {
        return instructorPK;
    }

    public void setInstructorPK(InstructorPK instructorPK) {
        this.instructorPK = instructorPK;
    }

    public Collection<Availability> getAvailabilityCollection() {
        return availabilityCollection;
    }

    public void setAvailabilityCollection(Collection<Availability> availabilityCollection) {
        this.availabilityCollection = availabilityCollection;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    public Bonding getTypeBonding() {
        return typeBonding;
    }

    public void setTypeBonding(Bonding typeBonding) {
        this.typeBonding = typeBonding;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Speciality getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(Speciality nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorPK != null ? instructorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorPK == null && other.instructorPK != null) || (this.instructorPK != null && !this.instructorPK.equals(other.instructorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Instructor[ instructorPK=" + instructorPK + " ]";
    }
    
}
