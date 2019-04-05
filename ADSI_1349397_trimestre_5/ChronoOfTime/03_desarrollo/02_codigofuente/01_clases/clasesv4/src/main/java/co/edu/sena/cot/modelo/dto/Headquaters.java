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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "headquaters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headquaters.findAll", query = "SELECT h FROM Headquaters h")
    , @NamedQuery(name = "Headquaters.findByNameHead", query = "SELECT h FROM Headquaters h WHERE h.headquatersPK.nameHead = :nameHead")
    , @NamedQuery(name = "Headquaters.findByDirection", query = "SELECT h FROM Headquaters h WHERE h.direction = :direction")
    , @NamedQuery(name = "Headquaters.findByState", query = "SELECT h FROM Headquaters h WHERE h.state = :state")
    , @NamedQuery(name = "Headquaters.findByNumEnvironment", query = "SELECT h FROM Headquaters h WHERE h.headquatersPK.numEnvironment = :numEnvironment")})
public class Headquaters implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HeadquatersPK headquatersPK;
    @Column(name = "direction", length = 45)
    private String direction;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @JoinColumn(name = "num_environment", referencedColumnName = "num_environment", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Environment environment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headquaters")
    private Collection<Timetable> timetableCollection;

    public Headquaters() {
    }

    public Headquaters(HeadquatersPK headquatersPK) {
        this.headquatersPK = headquatersPK;
    }

    public Headquaters(HeadquatersPK headquatersPK, boolean state) {
        this.headquatersPK = headquatersPK;
        this.state = state;
    }

    public Headquaters(String nameHead, String numEnvironment) {
        this.headquatersPK = new HeadquatersPK(nameHead, numEnvironment);
    }

    public HeadquatersPK getHeadquatersPK() {
        return headquatersPK;
    }

    public void setHeadquatersPK(HeadquatersPK headquatersPK) {
        this.headquatersPK = headquatersPK;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @XmlTransient
    public Collection<Timetable> getTimetableCollection() {
        return timetableCollection;
    }

    public void setTimetableCollection(Collection<Timetable> timetableCollection) {
        this.timetableCollection = timetableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (headquatersPK != null ? headquatersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Headquaters)) {
            return false;
        }
        Headquaters other = (Headquaters) object;
        if ((this.headquatersPK == null && other.headquatersPK != null) || (this.headquatersPK != null && !this.headquatersPK.equals(other.headquatersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Headquaters[ headquatersPK=" + headquatersPK + " ]";
    }
    
}
