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
@Table(name = "working_day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkingDay.findAll", query = "SELECT w FROM WorkingDay w")
    , @NamedQuery(name = "WorkingDay.findByInitials", query = "SELECT w FROM WorkingDay w WHERE w.initials = :initials")
    , @NamedQuery(name = "WorkingDay.findByName", query = "SELECT w FROM WorkingDay w WHERE w.name = :name")
    , @NamedQuery(name = "WorkingDay.findByDescription", query = "SELECT w FROM WorkingDay w WHERE w.description = :description")
    , @NamedQuery(name = "WorkingDay.findByLikeInitials", query = "SELECT w FROM WorkingDay w WHERE w.initials LIKE :initials")
    , @NamedQuery(name = "WorkingDay.findByLikeName", query = "SELECT w FROM WorkingDay w WHERE w.name LIKE :name")
    , @NamedQuery(name = "WorkingDay.findByLikeDescription", query = "SELECT w FROM WorkingDay w WHERE w.description LIKE :description")
    ,@NamedQuery (name = "WorkingDay.updatePK", query = "UPDATE WorkingDay w SET w.initials = :WorkingNew WHERE w.initials = :WorkingOld")})
public class WorkingDay implements Serializable {

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 10)
    private String initials;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay")
    private Collection<Disponibility> disponibilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay")
    private Collection<Trimester> trimesterCollection;

    public WorkingDay() {
    }

    public WorkingDay(String initials) {
        this.initials = initials;
    }

    public WorkingDay(String initials, String name, String description) {
        this.initials = initials;
        this.name = name;
        this.description = description;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @XmlTransient
    public Collection<Disponibility> getDisponibilityCollection() {
        return disponibilityCollection;
    }

    public void setDisponibilityCollection(Collection<Disponibility> disponibilityCollection) {
        this.disponibilityCollection = disponibilityCollection;
    }

    @XmlTransient
    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (initials != null ? initials.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingDay)) {
            return false;
        }
        WorkingDay other = (WorkingDay) object;
        if ((this.initials == null && other.initials != null) || (this.initials != null && !this.initials.equals(other.initials))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.WorkingDay[ initials=" + initials + " ]";
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
}
