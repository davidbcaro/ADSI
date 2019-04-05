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
@Table(name = "modality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modality.findAll", query = "SELECT m FROM Modality m")
    , @NamedQuery(name = "Modality.findByNameModality", query = "SELECT m FROM Modality m WHERE m.nameModality = :nameModality")
    , @NamedQuery(name = "Modality.findByLikeNameModality", query = "SELECT m FROM Modality m WHERE m.nameModality LIKE  :nameModality")
    , @NamedQuery(name = "Modality.findByState", query = "SELECT m FROM Modality m WHERE m.state = :state")})
public class Modality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_modality", nullable = false, length = 20)
    private String nameModality;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameModality")
    private Collection<Timetable> timetableCollection;

    public Modality() {
    }

    public Modality(String nameModality) {
        this.nameModality = nameModality;
    }

    public Modality(String nameModality, boolean state) {
        this.nameModality = nameModality;
        this.state = state;
    }

    public String getNameModality() {
        return nameModality;
    }

    public void setNameModality(String nameModality) {
        this.nameModality = nameModality;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
        hash += (nameModality != null ? nameModality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modality)) {
            return false;
        }
        Modality other = (Modality) object;
        if ((this.nameModality == null && other.nameModality != null) || (this.nameModality != null && !this.nameModality.equals(other.nameModality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.Modality[ nameModality=" + nameModality + " ]";
    }

}
