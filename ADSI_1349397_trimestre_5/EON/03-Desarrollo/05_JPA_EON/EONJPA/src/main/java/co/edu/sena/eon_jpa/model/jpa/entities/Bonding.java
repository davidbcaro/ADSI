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
@Table(name = "bonding")
@NamedQueries({
     @NamedQuery(name = "Bonding.findAll", query = "SELECT b FROM Bonding b")
    ,@NamedQuery(name = "Bonding.findByTypeLinkage", query = "SELECT b FROM Bonding b WHERE b.typeLinkage = :typeLinkage")
    ,@NamedQuery(name = "Bonding.findByHours", query = "SELECT b FROM Bonding b WHERE b.hours = :hours")
    ,@NamedQuery(name = "Bonding.findByStatus", query = "SELECT b FROM Bonding b WHERE b.status = :status")
    ,@NamedQuery(name = "Bonding.findByliketypeLinkage", query = "SELECT b FROM Bonding b WHERE b.typeLinkage LIKE :typeLinkage")
    ,@NamedQuery(name = "Bonding.updatePrimaryKey", query = "UPDATE Bonding b SET b.typeLinkage = :typeLinkageNuevo WHERE b.typeLinkage = :typeLinkageViejo")

})
public class Bonding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_Linkage", nullable = false, length = 30)
    private String typeLinkage;
    @Basic(optional = false)
    @Column(name = "Hours", nullable = false)
    private int hours;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeLinkage")
    private Collection<Instructor> instructorCollection;

    public Bonding() {
    }

    public Bonding(String typeLinkage) {
        this.typeLinkage = typeLinkage;
    }

    public Bonding(String typeLinkage, int hours, boolean status) {
        this.typeLinkage = typeLinkage;
        this.hours = hours;
        this.status = status;
    }

    public String getTypeLinkage() {
        return typeLinkage;
    }

    public void setTypeLinkage(String typeLinkage) {
        this.typeLinkage = typeLinkage;
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
        hash += (typeLinkage != null ? typeLinkage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonding)) {
            return false;
        }
        Bonding other = (Bonding) object;
        if ((this.typeLinkage == null && other.typeLinkage != null) || (this.typeLinkage != null && !this.typeLinkage.equals(other.typeLinkage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Bonding[ typeLinkage=" + typeLinkage + " ]";
    }

}
