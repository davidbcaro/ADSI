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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "working_day")
@NamedQueries({
    @NamedQuery(name = "WorkingDay.findAll", query = "SELECT w FROM WorkingDay w")
    ,@NamedQuery(name = "WorkingDay.findByName", query = "SELECT w FROM WorkingDay w WHERE w.name = :name")
    ,@NamedQuery(name = "WorkingDay.findByLikeName",query="SELECT w FROM WorkingDay w WHERE w.name LIKE :name")
    ,@NamedQuery(name = "WorkingDay.findByDescription" , query = "SELECT w FROM WorkingDay w WHERE w.description = :description")
    ,@NamedQuery(name = "WorkingDay.findByLikeDescription",query="SELECT w FROM WorkingDay w WHERE w.description LIKE :description")    
    ,@NamedQuery(name = "WorkingDay.findByState",query = "SELECT W FROM WorkingDay w WHERE w.state = :state")
    ,@NamedQuery(name = "WorkingDay.findByAcronymsWorkingDay", query = "SELECT w FROM WorkingDay w WHERE w.acronymsWorkingDay = :acronymsWorkingDay")
    ,@NamedQuery(name = "WorkingDay.findByLikeAcronymsWorkingDay",query = "SELECT w FROM WorkingDay w WHERE w.acronymsWorkingDay LIKE :acronymsWorkingDay")
    ,@NamedQuery(name = "WorkingDay.updatePrimaryKey", query = "UPDATE WorkingDay w SET w.acronymsWorkingDay = :NuevoAcronim WHERE w.acronymsWorkingDay = :ViejoAcronim")
})
public class WorkingDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acronyms_Working_Day", nullable = false, length = 20)
    private String acronymsWorkingDay;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description", length = 45)
    private String description;
    @Lob
    @Column(name = "Image")
    private byte[] image;
    @Column(name = "State")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay")
    private Collection<Availability> availabilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay")
    private Collection<Trimester> trimesterCollection;

    public WorkingDay() {
    }

    public WorkingDay(String acronymsWorkingDay) {
        this.acronymsWorkingDay = acronymsWorkingDay;
    }

    public WorkingDay(String acronymsWorkingDay, String name) {
        this.acronymsWorkingDay = acronymsWorkingDay;
        this.name = name;
    }

    public String getAcronymsWorkingDay() {
        return acronymsWorkingDay;
    }

    public void setAcronymsWorkingDay(String acronymsWorkingDay) {
        this.acronymsWorkingDay = acronymsWorkingDay;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Collection<Availability> getAvailabilityCollection() {
        return availabilityCollection;
    }

    public void setAvailabilityCollection(Collection<Availability> availabilityCollection) {
        this.availabilityCollection = availabilityCollection;
    }

    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acronymsWorkingDay != null ? acronymsWorkingDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingDay)) {
            return false;
        }
        WorkingDay other = (WorkingDay) object;
        if ((this.acronymsWorkingDay == null && other.acronymsWorkingDay != null) || (this.acronymsWorkingDay != null && !this.acronymsWorkingDay.equals(other.acronymsWorkingDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.WorkingDay[ acronymsWorkingDay=" + acronymsWorkingDay + " ]";
    }
    
}
