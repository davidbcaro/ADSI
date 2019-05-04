/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
@Table(name = "environment")
@NamedQueries({
    @NamedQuery(name = "Environment.findAll", query = "SELECT e FROM Environment e")
    , @NamedQuery(name = "Environment.findByNumberEnvironment", query = "SELECT e FROM Environment e WHERE e.environmentPK.numberEnvironment = :numberEnvironment")
    , @NamedQuery(name = "Environment.findByLikeNumberEnvironment", query = "SELECT e FROM Environment e WHERE e.environmentPK.numberEnvironment like :numberEnvironment")
    , @NamedQuery(name = "Environment.findByDescription", query = "SELECT e FROM Environment e WHERE e.description = :description")
    , @NamedQuery(name = "Environment.findByLikeDescription", query = "SELECT e FROM Environment e WHERE e.description like :description")
    , @NamedQuery(name = "Environment.findByStatus", query = "SELECT e FROM Environment e WHERE e.status = :status")
    , @NamedQuery(name = "Environment.findByNameHeadquartes", query = "SELECT e FROM Environment e WHERE e.environmentPK.nameHeadquartes = :nameHeadquartes")
    , @NamedQuery(name = "Environment.findByLikeNameHeadquartes", query = "SELECT e FROM Environment e WHERE e.environmentPK.nameHeadquartes like :nameHeadquartes")
    , @NamedQuery(name = "Environment.updatePrimaryKey", query = "UPDATE Environment e set e.environmentPK.nameHeadquartes = :newNameHeadquartes, e.environmentPK.numberEnvironment = :newNumberEnvironment WHERE e.environmentPK.nameHeadquartes = :oldNameHeadquartes and e.environmentPK.numberEnvironment = :oldNumberEnvironment")})

public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnvironmentPK environmentPK;
    @Column(name = "description", length = 45)
    private String description;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "environment")
    private Collection<Schedule> scheduleCollection;
    @JoinColumn(name = "name_headquartes", referencedColumnName = "name_headquartes", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Headquartes headquartes;

    public Environment() {
    }

    public Environment(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    public Environment(String numberEnvironment, String nameHeadquartes) {
        this.environmentPK = new EnvironmentPK(numberEnvironment, nameHeadquartes);
    }

    public EnvironmentPK getEnvironmentPK() {
        return environmentPK;
    }

    public void setEnvironmentPK(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
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

    public Headquartes getHeadquartes() {
        return headquartes;
    }

    public void setHeadquartes(Headquartes headquartes) {
        this.headquartes = headquartes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (environmentPK != null ? environmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) object;
        if ((this.environmentPK == null && other.environmentPK != null) || (this.environmentPK != null && !this.environmentPK.equals(other.environmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Environment[ environmentPK=" + environmentPK + " ]";
    }

}
