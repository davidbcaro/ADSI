/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
    , @NamedQuery(name = "Environment.findByDescription", query = "SELECT e FROM Environment e WHERE e.description = :description")
    , @NamedQuery(name = "Environment.findByLikeDescription", query = "SELECT e FROM Environment e WHERE e.description Like :description")
    , @NamedQuery(name = "Environment.findByLikeHeadQuartersName", query = "SELECT e FROM Environment e WHERE e.environmentPK.headquartersName Like :headquartersName")
    , @NamedQuery(name = "Environment.findByStatus", query = "SELECT e FROM Environment e WHERE e.status = :status")
    , @NamedQuery(name = "Environment.findByHeadquartersName", query = "SELECT e FROM Environment e WHERE e.environmentPK.headquartersName = :headquartersName")
    ,@NamedQuery(name = "Environment.updatePrimaryKey", query = "UPDATE Environment e set e.environmentPK.headquartersName = :headquartersNameNew,  e.environmentPK.numberEnvironment = :numberEnvironmentNew WHERE e.environmentPK.headquartersName = :headquartersNameOld and e.environmentPK.numberEnvironment = :numberEnvironmentOld")        
    })
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnvironmentPK environmentPK;
    @Column(name = "description", length = 150)
    private String description;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "environment")
    private Collection<Schedule> scheduleCollection;
    @JoinColumn(name = "headquarters_name", referencedColumnName = "name_headquarters", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Headquarters headquarters;

    public Environment() {
    }

    public Environment(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    public Environment(String numberEnvironment, String headquartersName) {
        this.environmentPK = new EnvironmentPK(numberEnvironment, headquartersName);
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

    public Headquarters getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(Headquarters headquarters) {
        this.headquarters = headquarters;
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
        return "co.edu.sena.model.jpa.entities.Environment[ environmentPK=" + environmentPK + " ]";
    }

}
