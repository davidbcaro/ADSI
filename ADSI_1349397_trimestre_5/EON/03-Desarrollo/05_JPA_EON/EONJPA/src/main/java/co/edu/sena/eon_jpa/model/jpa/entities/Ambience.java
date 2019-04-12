/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "ambience")
@NamedQueries({
     @NamedQuery(name = "Ambience.findAll", query = "SELECT a FROM Ambience a")
    ,@NamedQuery(name = "Ambience.findByDescription", query = "SELECT a FROM Ambience a WHERE a.description = :description")
    ,@NamedQuery(name = "Ambience.findByStatus", query = "SELECT a FROM Ambience a WHERE a.status = :status")
    ,@NamedQuery(name = "Ambience.findByNumberAmbience", query = "SELECT a FROM Ambience a WHERE a.ambiencePK.numberAmbience =:numberAmbience")
    ,@NamedQuery(name = "Ambience.findByNameHeadquarters", query = "SELECT a FROM Ambience a WHERE a.ambiencePK.nameHeadquarters =:nameHeadquarters")
    ,@NamedQuery(name = "Ambience.findByLikeDescription", query = "SELECT a FROM Ambience a WHERE a.description LIKE :description")
    ,@NamedQuery(name = "Ambience.findByLikeNumberAmbience", query = "SELECT a FROM Ambience a WHERE a.ambiencePK.numberAmbience LIKE :numberAmbience")
    ,@NamedQuery(name = "Ambience.findByLikeNameHeadquarters", query = "SELECT a FROM Ambience a WHERE a.ambiencePK.nameHeadquarters LIKE :nameHeadquarters")
    ,@NamedQuery(name = "Ambience.updatePrimaryKey", query = "UPDATE Ambience a SET a.ambiencePK.numberAmbience =:nuevoNumber ,a.ambiencePK.nameHeadquarters =:nuevoHeadquarters WHERE a.ambiencePK.numberAmbience =:viejoNumber AND a.ambiencePK.nameHeadquarters=:viejoHeadquarters")
})
public class Ambience implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmbiencePK ambiencePK;
    @Column(name = "Description", length = 100)
    private String description;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambience")
    private Collection<Schedule> scheduleCollection;
    @JoinColumn(name = "name_Headquarters", referencedColumnName = "name_Headquarters", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Headquarters headquarters;

    public Ambience() {
    }

    public Ambience(AmbiencePK ambiencePK) {
        this.ambiencePK = ambiencePK;
    }

    public Ambience(String numberAmbience, String nameHeadquarters) {
        this.ambiencePK = new AmbiencePK(numberAmbience, nameHeadquarters);
    }

    public AmbiencePK getAmbiencePK() {
        return ambiencePK;
    }

    public void setAmbiencePK(AmbiencePK ambiencePK) {
        this.ambiencePK = ambiencePK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    public Headquarters getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(Headquarters headquarters) {
        this.headquarters = headquarters;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ambiencePK != null ? ambiencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambience)) {
            return false;
        }
        Ambience other = (Ambience) object;
        if ((this.ambiencePK == null && other.ambiencePK != null) || (this.ambiencePK != null && !this.ambiencePK.equals(other.ambiencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Ambience[ ambiencePK=" + ambiencePK + " ]";
    }
    
}
