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
import javax.persistence.Lob;
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
@Table(name = "working_day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkingDay.findAll", query = "SELECT w FROM WorkingDay w")
    , @NamedQuery(name = "WorkingDay.findByInitialsWorkingDay", query = "SELECT w FROM WorkingDay w WHERE w.initialsWorkingDay = :initialsWorkingDay")
    , @NamedQuery(name = "WorkingDay.findByName", query = "SELECT w FROM WorkingDay w WHERE w.name = :name")
    , @NamedQuery(name = "WorkingDay.findByDescription", query = "SELECT w FROM WorkingDay w WHERE w.description = :description")
    , @NamedQuery(name = "WorkingDay.findByState", query = "SELECT w FROM WorkingDay w WHERE w.state = :state")})
public class WorkingDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "initials_Working_Day", nullable = false, length = 10)
    private String initialsWorkingDay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Size(max = 400)
    @Column(name = "description", length = 400)
    private String description;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay", fetch = FetchType.LAZY)
    private Collection<Availability> availabilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay", fetch = FetchType.LAZY)
    private Collection<Trimester> trimesterCollection;

    public WorkingDay() {
    }

    public WorkingDay(String initialsWorkingDay) {
        this.initialsWorkingDay = initialsWorkingDay;
    }

    public WorkingDay(String initialsWorkingDay, String name) {
        this.initialsWorkingDay = initialsWorkingDay;
        this.name = name;
    }

    public String getInitialsWorkingDay() {
        return initialsWorkingDay;
    }

    public void setInitialsWorkingDay(String initialsWorkingDay) {
        this.initialsWorkingDay = initialsWorkingDay;
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

    @XmlTransient
    public Collection<Availability> getAvailabilityCollection() {
        return availabilityCollection;
    }

    public void setAvailabilityCollection(Collection<Availability> availabilityCollection) {
        this.availabilityCollection = availabilityCollection;
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
        hash += (initialsWorkingDay != null ? initialsWorkingDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingDay)) {
            return false;
        }
        WorkingDay other = (WorkingDay) object;
        if ((this.initialsWorkingDay == null && other.initialsWorkingDay != null) || (this.initialsWorkingDay != null && !this.initialsWorkingDay.equals(other.initialsWorkingDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.WorkingDay[ initialsWorkingDay=" + initialsWorkingDay + " ]";
    }
    
}
