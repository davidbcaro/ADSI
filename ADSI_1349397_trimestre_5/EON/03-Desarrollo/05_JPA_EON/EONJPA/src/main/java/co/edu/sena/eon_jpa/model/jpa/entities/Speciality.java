/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
    ,@NamedQuery(name = "Speciality.findByspecialityName", query = "SELECT s FROM Speciality s WHERE s.specialityName = :specialityName")
    ,@NamedQuery(name = "Speciality.findByStatus", query = "SELECT s FROM Speciality s WHERE s.status = :status")
    ,@NamedQuery(name = "Speciality.findByLikespecialityName", query = "SELECT s FROM Speciality s WHERE s.specialityName LIKE :specialityName")
    ,@NamedQuery(name = "Speciality.updatePrimaryKey", query = "UPDATE Speciality s SET s.specialityName = :specialityNameNuevo WHERE s.specialityName = :specialityNameViejo")
})
public class Speciality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "speciality_Name", nullable = false, length = 30)
    private String specialityName;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciality")
    private Collection<Trimester> trimesterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialityName")
    private Collection<Instructor> instructorCollection;

    public Speciality() {
    }

    public Speciality(String specialityName) {
        this.specialityName = specialityName;
    }

    public Speciality(String specialityName, boolean status) {
        this.specialityName = specialityName;
        this.status = status;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
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
        hash += (specialityName != null ? specialityName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.specialityName == null && other.specialityName != null) || (this.specialityName != null && !this.specialityName.equals(other.specialityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Speciality[ specialityName=" + specialityName + " ]";
    }

}
