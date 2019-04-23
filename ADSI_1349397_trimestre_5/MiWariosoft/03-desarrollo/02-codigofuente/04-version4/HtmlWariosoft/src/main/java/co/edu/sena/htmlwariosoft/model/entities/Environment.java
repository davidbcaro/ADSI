/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "environment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Environment.findAll", query = "SELECT e FROM Environment e")
    , @NamedQuery(name = "Environment.findByNumberEnvironment", query = "SELECT e FROM Environment e WHERE e.environmentPK.numberEnvironment = :numberEnvironment")
    , @NamedQuery(name = "Environment.findByDescription", query = "SELECT e FROM Environment e WHERE e.description = :description")
    , @NamedQuery(name = "Environment.findByState", query = "SELECT e FROM Environment e WHERE e.state = :state")
    , @NamedQuery(name = "Environment.findByNameHeadquarters", query = "SELECT e FROM Environment e WHERE e.environmentPK.nameHeadquarters = :nameHeadquarters")})
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnvironmentPK environmentPK;
    @Size(max = 400)
    @Column(name = "description", length = 400)
    private String description;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "environment", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;
    @JoinColumn(name = "name_Headquarters", referencedColumnName = "name_Headquarters", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Headquarters headquarters;

    public Environment() {
    }

    public Environment(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    public Environment(String numberEnvironment, String nameHeadquarters) {
        this.environmentPK = new EnvironmentPK(numberEnvironment, nameHeadquarters);
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
        return "co.edu.sena.htmlwariosoft.model.entities.Environment[ environmentPK=" + environmentPK + " ]";
    }
    
}
