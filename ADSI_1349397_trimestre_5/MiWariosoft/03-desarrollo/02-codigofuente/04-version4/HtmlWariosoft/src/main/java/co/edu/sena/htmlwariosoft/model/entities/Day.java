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
@Table(name = "day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Day.findAll", query = "SELECT d FROM Day d")
    , @NamedQuery(name = "Day.findByNameDay", query = "SELECT d FROM Day d WHERE d.nameDay = :nameDay")
    , @NamedQuery(name = "Day.findByState", query = "SELECT d FROM Day d WHERE d.state = :state")})
public class Day implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "name_Day", nullable = false, length = 10)
    private String nameDay;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "day", fetch = FetchType.LAZY)
    private Collection<Availability> availabilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "day", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public Day() {
    }

    public Day(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
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
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameDay != null ? nameDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Day)) {
            return false;
        }
        Day other = (Day) object;
        if ((this.nameDay == null && other.nameDay != null) || (this.nameDay != null && !this.nameDay.equals(other.nameDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.Day[ nameDay=" + nameDay + " ]";
    }
    
}
