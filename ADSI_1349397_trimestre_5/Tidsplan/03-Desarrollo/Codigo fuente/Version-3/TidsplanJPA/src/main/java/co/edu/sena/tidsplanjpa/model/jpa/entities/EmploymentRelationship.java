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
@Table(name = "employment_relationship")
@NamedQueries({
    @NamedQuery(name = "EmploymentRelationship.findAll", query = "SELECT e FROM EmploymentRelationship e")
    , @NamedQuery(name = "EmploymentRelationship.findByTypeEmploymentRelationship", query = "SELECT e FROM EmploymentRelationship e WHERE e.typeEmploymentRelationship = :typeEmploymentRelationship")
    , @NamedQuery(name = "EmploymentRelationship.findByLikeTypeEmploymentRelationship", query = "SELECT e FROM EmploymentRelationship e WHERE e.typeEmploymentRelationship like :typeEmploymentRelationship")
    , @NamedQuery(name = "EmploymentRelationship.findByHours", query = "SELECT e FROM EmploymentRelationship e WHERE e.hours = :hours")
    , @NamedQuery(name = "EmploymentRelationship.findByStatus", query = "SELECT e FROM EmploymentRelationship e WHERE e.status = :status")
    , @NamedQuery(name = "EmploymentRelationship.updatePrimaryKey", query = "UPDATE EmploymentRelationship e SET e.typeEmploymentRelationship = :newRela WHERE e.typeEmploymentRelationship = :oldRela")})
    
public class EmploymentRelationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_employment_relationship", nullable = false, length = 20)
    private String typeEmploymentRelationship;
    @Basic(optional = false)
    @Column(name = "hours", nullable = false)
    private int hours;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeEmploymentRelationship")
    private Collection<Instructor> instructorCollection;

    public EmploymentRelationship() {
    }

    public EmploymentRelationship(String typeEmploymentRelationship) {
        this.typeEmploymentRelationship = typeEmploymentRelationship;
    }

    public EmploymentRelationship(String typeEmploymentRelationship, int hours, boolean status) {
        this.typeEmploymentRelationship = typeEmploymentRelationship;
        this.hours = hours;
        this.status = status;
    }

    public String getTypeEmploymentRelationship() {
        return typeEmploymentRelationship;
    }

    public void setTypeEmploymentRelationship(String typeEmploymentRelationship) {
        this.typeEmploymentRelationship = typeEmploymentRelationship;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
        hash += (typeEmploymentRelationship != null ? typeEmploymentRelationship.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmploymentRelationship)) {
            return false;
        }
        EmploymentRelationship other = (EmploymentRelationship) object;
        if ((this.typeEmploymentRelationship == null && other.typeEmploymentRelationship != null) || (this.typeEmploymentRelationship != null && !this.typeEmploymentRelationship.equals(other.typeEmploymentRelationship))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.EmploymentRelationship[ typeEmploymentRelationship=" + typeEmploymentRelationship + " ]";
    }
    
}
