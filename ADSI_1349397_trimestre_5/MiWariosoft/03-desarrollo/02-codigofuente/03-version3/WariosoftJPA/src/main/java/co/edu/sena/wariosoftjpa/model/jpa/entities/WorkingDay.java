/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
    @NamedQuery(name = "WorkingDay.findAll", query = "SELECT wd FROM WorkingDay wd")
        ,@NamedQuery(name = "WorkingDay.findByInitialsWorkingDay", query = "SELECT wd FROM WorkingDay wd WHERE wd.initialsWorkingDay = :InitialsWorkingDay")
        ,@NamedQuery(name = "WorkingDay.findByName", query = "SELECT wd FROM WorkingDay wd WHERE wd.name = :Name")
        ,@NamedQuery(name = "WorkingDay.findByDescription", query = "SELECT wd FROM WorkingDay wd WHERE wd.description = :Description")
        ,@NamedQuery(name = "WorkingDay.findByState", query = "SELECT wd FROM WorkingDay wd WHERE wd.state = :State")
        ,@NamedQuery(name = "WorkingDay.findByLikeInitialsWorkingDay", query = "SELECT wd FROM WorkingDay wd WHERE wd.initialsWorkingDay LIKE :InitialsWorkingDay")
        ,@NamedQuery(name = "WorkingDay.updatePrimaryKey", query = "UPDATE WorkingDay wd SET wd.initialsWorkingDay = :inicialesDeJornadaLaboralNuevas WHERE wd.initialsWorkingDay = :inicialesDeJornadaLaboralViejas")
})
public class WorkingDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "initials_Working_Day", nullable = false, length = 10)
    private String initialsWorkingDay;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "description", length = 400)
    private String description;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay")
    private Collection<Availability> availabilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingDay")
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.WorkingDay[ initialsWorkingDay=" + initialsWorkingDay + " ]";
    }
    
}
