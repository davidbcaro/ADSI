/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "speciality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s")
    , @NamedQuery(name = "Speciality.findByName", query = "SELECT s FROM Speciality s WHERE s.name = :name")
    , @NamedQuery(name = "Speciality.findByState", query = "SELECT s FROM Speciality s WHERE s.state = :state")
    , @NamedQuery(name = "Speciality.findByLikeName", query = "SELECT s FROM Speciality s WHERE s.name LIKE :name")})
public class Speciality implements Serializable {

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialityName")
    private Collection<Instructor> instructorCollection;

    public Speciality() {
    }

    public Speciality(String name) {
        this.name = name;
    }

    public Speciality(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Speciality[ name=" + name + " ]";
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

}
