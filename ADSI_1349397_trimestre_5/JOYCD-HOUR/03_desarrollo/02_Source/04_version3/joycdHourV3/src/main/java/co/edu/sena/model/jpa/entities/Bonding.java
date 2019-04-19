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
@Table(name = "bonding")
@NamedQueries({
    @NamedQuery(name = "Bonding.findAll", query = "SELECT b FROM Bonding b")
    , @NamedQuery(name = "Bonding.findByTypeBonding", query = "SELECT b FROM Bonding b WHERE b.typeBonding = :typeBonding")
    , @NamedQuery(name = "Bonding.findByHours", query = "SELECT b FROM Bonding b WHERE b.hours = :hours")
    , @NamedQuery(name = "Bonding.findByStatus", query = "SELECT b FROM Bonding b WHERE b.status = :status")
    , @NamedQuery(name = "Bonding.findByLikeTypeBonding", query = "SELECT b FROM Bonding b WHERE b.typeBonding LIKE :typeBonding")
    , @NamedQuery(name = "Bonding.updatePrimaryKey", query = "UPDATE Bonding b SET b.typeBonding = :bondingNew WHERE b.typeBonding = :bondingOld")
})
public class Bonding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_bonding", nullable = false, length = 20)
    private String typeBonding;
    @Basic(optional = false)
    @Column(name = "hours", nullable = false)
    private int hours;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeBonding")
    private Collection<Instructor> instructorCollection;

    public Bonding() {
    }

    public Bonding(String typeBonding) {
        this.typeBonding = typeBonding;
    }

    public Bonding(String typeBonding, int hours, boolean status) {
        this.typeBonding = typeBonding;
        this.hours = hours;
        this.status = status;
    }

    public String getTypeBonding() {
        return typeBonding;
    }

    public void setTypeBonding(String typeBonding) {
        this.typeBonding = typeBonding;
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
        hash += (typeBonding != null ? typeBonding.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonding)) {
            return false;
        }
        Bonding other = (Bonding) object;
        if ((this.typeBonding == null && other.typeBonding != null) || (this.typeBonding != null && !this.typeBonding.equals(other.typeBonding))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.Bonding[ typeBonding=" + typeBonding + " ]";
    }

}
