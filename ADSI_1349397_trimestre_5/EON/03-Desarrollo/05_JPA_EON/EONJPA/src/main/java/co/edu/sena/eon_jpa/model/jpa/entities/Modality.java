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
    ,@NamedQuery(name ="Modality.findByNameModality",query="SELECT m FROM Modality m WHERE m.modalityName = :name")
    ,@NamedQuery(name = "Modality.findByLikeNameModality",query = "SELECT m FROM Modality m WHERE m.modalityName LIKE :name")
    ,@NamedQuery(name = "Modality.findByState", query = "SELECT m FROM Modality m WHERE m.state =:state")
  ,@NamedQuery(name = "Modality.updatePrimaryKey",query ="UPDATE Modality m SET m.modalityName = :nuevoModality WHERE  m.modalityName = :viejoModality")
})
public class Modality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "modality_Name", nullable = false, length = 20)
    private String modalityName;
    @Column(name = "State")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalityName")
    private Collection<Schedule> scheduleCollection;

    public Modality() {
    }

    public Modality(String modalityName) {
        this.modalityName = modalityName;
    }

    public String getModalityName() {
        return modalityName;
    }

    public void setModalityName(String modalityName) {
        this.modalityName = modalityName;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
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
        hash += (modalityName != null ? modalityName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modality)) {
            return false;
        }
        Modality other = (Modality) object;
        if ((this.modalityName == null && other.modalityName != null) || (this.modalityName != null && !this.modalityName.equals(other.modalityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Modality[ modalityName=" + modalityName + " ]";
    }
    
}
