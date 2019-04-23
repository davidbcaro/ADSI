/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "specialty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialty.findAll", query = "SELECT s FROM Specialty s")
    , @NamedQuery(name = "Specialty.findByNameSpecialty", query = "SELECT s FROM Specialty s WHERE s.nameSpecialty = :nameSpecialty")
    , @NamedQuery(name = "Specialty.findByState", query = "SELECT s FROM Specialty s WHERE s.state = :state")})
public class Specialty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name_Specialty", nullable = false, length = 100)
    private String nameSpecialty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameSpecialty", fetch = FetchType.LAZY)
    private Collection<Teacher> teacherCollection;

    public Specialty() {
    }

    public Specialty(String nameSpecialty) {
        this.nameSpecialty = nameSpecialty;
    }

    public Specialty(String nameSpecialty, boolean state) {
        this.nameSpecialty = nameSpecialty;
        this.state = state;
    }

    public String getNameSpecialty() {
        return nameSpecialty;
    }

    public void setNameSpecialty(String nameSpecialty) {
        this.nameSpecialty = nameSpecialty;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameSpecialty != null ? nameSpecialty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialty)) {
            return false;
        }
        Specialty other = (Specialty) object;
        if ((this.nameSpecialty == null && other.nameSpecialty != null) || (this.nameSpecialty != null && !this.nameSpecialty.equals(other.nameSpecialty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.Specialty[ nameSpecialty=" + nameSpecialty + " ]";
    }
    
}
