/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "modality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modality.findAll", query = "SELECT m FROM Modality m")
    , @NamedQuery(name = "Modality.findByNameModality", query = "SELECT m FROM Modality m WHERE m.nameModality = :nameModality")
    , @NamedQuery(name = "Modality.findByState", query = "SELECT m FROM Modality m WHERE m.state = :state")})
public class Modality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name_Modality", nullable = false, length = 20)
    private String nameModality;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(mappedBy = "nameModality", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public Modality() {
    }

    public Modality(String nameModality) {
        this.nameModality = nameModality;
    }

    public String getNameModality() {
        return nameModality;
    }

    public void setNameModality(String nameModality) {
        this.nameModality = nameModality;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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
        return "co.edu.sena.htmlwariosoft.model.entities.Modality[ nameModality=" + nameModality + " ]";
    }
    
}
