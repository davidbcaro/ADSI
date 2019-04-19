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
@Table(name = "speciality")
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s")
    , @NamedQuery(name = "Speciality.findByNameSpeciality", query = "SELECT s FROM Speciality s WHERE s.nameSpeciality = :nameSpeciality")
    , @NamedQuery(name = "Speciality.findByStatus", query = "SELECT s FROM Speciality s WHERE s.status = :status")
    ,@NamedQuery(name = "Speciality.findByLikeNameSpeciality", query = "SELECT s FROM Speciality s WHERE s.nameSpeciality LIKE :nameSpeciality")
    , @NamedQuery(name = "Speciality.updatePrimaryKey", query = "UPDATE Speciality s SET s.nameSpeciality = :specialityNew WHERE s.nameSpeciality = :specialityOld")
})

public class Speciality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_speciality", nullable = false, length = 45)
    private String nameSpeciality;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameSpeciality")
    private Collection<Instructor> instructorCollection;

    public Speciality() {
    }

    public Speciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameSpeciality != null ? nameSpeciality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.nameSpeciality == null && other.nameSpeciality != null) || (this.nameSpeciality != null && !this.nameSpeciality.equals(other.nameSpeciality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Speciality[ nameSpeciality=" + nameSpeciality + " ]";
    }

}
