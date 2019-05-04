/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
    , @NamedQuery(name = "Instructor.findByDocument", query = "SELECT i FROM Instructor i WHERE i.instructorPK.document = :document")
    , @NamedQuery(name = "Instructor.findByLikeDocument", query = "SELECT i FROM Instructor i WHERE i.instructorPK.document like :document")
    , @NamedQuery(name = "Instructor.findByDocumentNumber", query = "SELECT i FROM Instructor i WHERE i.instructorPK.documentNumber = :documentNumber")
    , @NamedQuery(name = "Instructor.findByLikeDocumentNumber", query = "SELECT i FROM Instructor i WHERE i.instructorPK.documentNumber like :documentNumber")
    , @NamedQuery(name = "Instructor.findByTypeEmploymentRelationship", query = "SELECT i FROM Instructor i WHERE i.typeEmploymentRelationship.typeEmploymentRelationship = :typeEmploymentRelationship")
    , @NamedQuery(name = "Instructor.findByLikeTypeEmploymentRelationship", query = "SELECT i FROM Instructor i WHERE i.typeEmploymentRelationship.typeEmploymentRelationship like :typeEmploymentRelationship")
    , @NamedQuery(name = "Instructor.findByNameSpeciality", query = "SELECT i FROM Instructor i WHERE i.nameSpeciality.nameSpeciality = :nameSpeciality")
    , @NamedQuery(name = "Instructor.findByLikeNameSpeciality", query = "SELECT i FROM Instructor i WHERE i.nameSpeciality.nameSpeciality like :nameSpeciality")
    , @NamedQuery(name = "Instructor.updatePrimaryKey", query = "UPDATE Instructor i set i.instructorPK.documentNumber = :newDocumentNumber, i.instructorPK.document = :newDocument WHERE i.instructorPK.documentNumber = :oldDocumentNumber and i.instructorPK.document = :oldDocument")})
    
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstructorPK instructorPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Disponibility> disponibilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Schedule> scheduleCollection;
    @JoinColumns({
        @JoinColumn(name = "document_number", referencedColumnName = "document_number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "document", referencedColumnName = "document", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "type_employment_relationship", referencedColumnName = "type_employment_relationship", nullable = false)
    @ManyToOne(optional = false)
    private EmploymentRelationship typeEmploymentRelationship;
    @JoinColumn(name = "name_speciality", referencedColumnName = "name_speciality", nullable = false)
    @ManyToOne(optional = false)
    private Speciality nameSpeciality;

    public Instructor() {
    }

    public Instructor(InstructorPK instructorPK) {
        this.instructorPK = instructorPK;
    }

    public Instructor(String document, String documentNumber) {
        this.instructorPK = new InstructorPK(document, documentNumber);
    }

    public InstructorPK getInstructorPK() {
        return instructorPK;
    }

    public void setInstructorPK(InstructorPK instructorPK) {
        this.instructorPK = instructorPK;
    }

    public Collection<Disponibility> getDisponibilityCollection() {
        return disponibilityCollection;
    }

    public void setDisponibilityCollection(Collection<Disponibility> disponibilityCollection) {
        this.disponibilityCollection = disponibilityCollection;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public EmploymentRelationship getTypeEmploymentRelationship() {
        return typeEmploymentRelationship;
    }

    public void setTypeEmploymentRelationship(EmploymentRelationship typeEmploymentRelationship) {
        this.typeEmploymentRelationship = typeEmploymentRelationship;
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
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Instructor[ instructorPK=" + instructorPK + " ]";
    }
    
}
