/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "actuality_trimester")
@NamedQueries({
    @NamedQuery(name = "ActualityTrimester.findAll", query = "SELECT a FROM ActualityTrimester a")
    , @NamedQuery(name = "ActualityTrimester.findByActualityTrimester", query = "SELECT a FROM ActualityTrimester a WHERE a.actualityTrimester = :actualityTrimester")
    , @NamedQuery(name = "ActualityTrimester.findByDateStart", query = "SELECT a FROM ActualityTrimester a WHERE a.dateStart = :dateStart")
    , @NamedQuery(name = "ActualityTrimester.findByDateFinish", query = "SELECT a FROM ActualityTrimester a WHERE a.dateFinish = :dateFinish")})
public class ActualityTrimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "actuality_trimester", nullable = false, length = 12)
    private String actualityTrimester;
    @Basic(optional = false)
    @Column(name = "date_start", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Basic(optional = false)
    @Column(name = "date_finish", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinish;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actualityTrimester1")
    private Collection<VersionSchedule> versionScheduleCollection;

    public ActualityTrimester() {
    }

    public ActualityTrimester(String actualityTrimester) {
        this.actualityTrimester = actualityTrimester;
    }

    public ActualityTrimester(String actualityTrimester, Date dateStart, Date dateFinish) {
        this.actualityTrimester = actualityTrimester;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public String getActualityTrimester() {
        return actualityTrimester;
    }

    public void setActualityTrimester(String actualityTrimester) {
        this.actualityTrimester = actualityTrimester;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Collection<VersionSchedule> getVersionScheduleCollection() {
        return versionScheduleCollection;
    }

    public void setVersionScheduleCollection(Collection<VersionSchedule> versionScheduleCollection) {
        this.versionScheduleCollection = versionScheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actualityTrimester != null ? actualityTrimester.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActualityTrimester)) {
            return false;
        }
        ActualityTrimester other = (ActualityTrimester) object;
        if ((this.actualityTrimester == null && other.actualityTrimester != null) || (this.actualityTrimester != null && !this.actualityTrimester.equals(other.actualityTrimester))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.ActualityTrimester[ actualityTrimester=" + actualityTrimester + " ]";
    }
    
}
