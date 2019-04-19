/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "modality")
@NamedQueries({
    @NamedQuery(name = "Modality.findAll", query = "SELECT m FROM Modality m")
    , @NamedQuery(name = "Modality.findByNameModality", query = "SELECT m FROM Modality m WHERE m.nameModality = :nameModality")
    , @NamedQuery(name = "Modality.findByStatus", query = "SELECT m FROM Modality m WHERE m.status = :status")
    , @NamedQuery(name = "Modality.findByLikeNameModality", query = "SELECT m FROM Modality m WHERE m.nameModality LIKE :nameModality")
    , @NamedQuery(name = "Modality.updatePrimaryKey", query = "UPDATE Modality m SET m.nameModality = :modalityNew WHERE m.nameModality = :modalityOld")
})
public class Modality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_modality", nullable = false, length = 100)
    private String nameModality;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameModality")
    private Collection<Schedule> scheduleCollection;

    public Modality() {
    }

    public Modality(String nameModality) {
        this.nameModality = nameModality;
    }

    public Modality(String nameModality, boolean status) {
        this.nameModality = nameModality;
        this.status = status;
    }

    public String getNameModality() {
        return nameModality;
    }

    public void setNameModality(String nameModality) {
        this.nameModality = nameModality;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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
        return "co.edu.sena.model.jpa.entities.Modality[ nameModality=" + nameModality + " ]";
    }

}
