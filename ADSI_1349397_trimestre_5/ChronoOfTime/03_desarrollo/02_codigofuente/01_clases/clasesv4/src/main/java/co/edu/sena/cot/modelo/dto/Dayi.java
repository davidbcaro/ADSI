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
@Table(name = "dayi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dayi.findAll", query = "SELECT d FROM Dayi d")
    , @NamedQuery(name = "Dayi.findByNameDayi", query = "SELECT d FROM Dayi d WHERE d.nameDayi = :nameDayi")
        , @NamedQuery(name = "Dayi.findByLikeName", query = "SELECT d FROM Dayi d WHERE d.nameDayi LIKE :nameDayi")
    , @NamedQuery(name = "Dayi.findByState", query = "SELECT d FROM Dayi d WHERE d.state = :state")})
public class Dayi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_dayi", nullable = false, length = 10)
    private String nameDayi;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dayi")
    private Collection<Disponibility> disponibilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dayi")
    private Collection<Timetable> timetableCollection;

    public Dayi() {
    }

    public Dayi(String nameDayi) {
        this.nameDayi = nameDayi;
    }

    public Dayi(String nameDayi, boolean state) {
        this.nameDayi = nameDayi;
        this.state = state;
    }

    public String getNameDayi() {
        return nameDayi;
    }

    public void setNameDayi(String nameDayi) {
        this.nameDayi = nameDayi;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Disponibility> getDisponibilityCollection() {
        return disponibilityCollection;
    }

    public void setDisponibilityCollection(Collection<Disponibility> disponibilityCollection) {
        this.disponibilityCollection = disponibilityCollection;
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
        hash += (nameDayi != null ? nameDayi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dayi)) {
            return false;
        }
        Dayi other = (Dayi) object;
        if ((this.nameDayi == null && other.nameDayi != null) || (this.nameDayi != null && !this.nameDayi.equals(other.nameDayi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Dayi[ nameDayi=" + nameDayi + " ]";
    }
    
}
