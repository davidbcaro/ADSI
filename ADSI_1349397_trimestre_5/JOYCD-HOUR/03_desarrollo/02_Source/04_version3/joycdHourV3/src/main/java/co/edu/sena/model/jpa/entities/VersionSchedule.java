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
@Table(name = "version_schedule")
@NamedQueries({
    @NamedQuery(name = "VersionSchedule.findAll", query = "SELECT v FROM VersionSchedule v")
//    , @NamedQuery(name = "VersionSchedule.findByVersion", query = "SELECT v FROM VersionSchedule v WHERE v.versionSchedulePK.version = :version")
    , @NamedQuery(name = "VersionSchedule.findByStatusVersion", query = "SELECT v FROM VersionSchedule v WHERE v.statusVersion = :statusVersion")
    , @NamedQuery(name = "VersionSchedule.findByActualityTrimester", query = "SELECT v FROM VersionSchedule v WHERE v.versionSchedulePK.actualityTrimester = :actualityTrimester")
    , @NamedQuery(name = "VersionSchedule.UpdatePrimaryKey", query = "UPDATE VersionSchedule v SET v.versionSchedulePK.version = :versionNueva, v.versionSchedulePK.actualityTrimester = :actualityTrimesterNueva WHERE v.versionSchedulePK.version = :versionVieja and v.versionSchedulePK.actualityTrimester = :actualityTrimesterVieja")
})
public class VersionSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VersionSchedulePK versionSchedulePK;
    @Basic(optional = false)
    @Column(name = "status_version", nullable = false)
    private boolean statusVersion;
    @JoinColumn(name = "actuality_trimester", referencedColumnName = "actuality_trimester", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActualityTrimester actualityTrimester1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "versionSchedule")
    private Collection<Schedule> scheduleCollection;

    public VersionSchedule() {
    }

    public VersionSchedule(VersionSchedulePK versionSchedulePK) {
        this.versionSchedulePK = versionSchedulePK;
    }

    public VersionSchedule(VersionSchedulePK versionSchedulePK, boolean statusVersion) {
        this.versionSchedulePK = versionSchedulePK;
        this.statusVersion = statusVersion;
    }

    public VersionSchedule(int version, String actualityTrimester) {
        this.versionSchedulePK = new VersionSchedulePK(version, actualityTrimester);
    }

    public VersionSchedulePK getVersionSchedulePK() {
        return versionSchedulePK;
    }

    public void setVersionSchedulePK(VersionSchedulePK versionSchedulePK) {
        this.versionSchedulePK = versionSchedulePK;
    }

    public boolean getStatusVersion() {
        return statusVersion;
    }

    public void setStatusVersion(boolean statusVersion) {
        this.statusVersion = statusVersion;
    }

    public ActualityTrimester getActualityTrimester1() {
        return actualityTrimester1;
    }

    public void setActualityTrimester1(ActualityTrimester actualityTrimester1) {
        this.actualityTrimester1 = actualityTrimester1;
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
        hash += (versionSchedulePK != null ? versionSchedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionSchedule)) {
            return false;
        }
        VersionSchedule other = (VersionSchedule) object;
        if ((this.versionSchedulePK == null && other.versionSchedulePK != null) || (this.versionSchedulePK != null && !this.versionSchedulePK.equals(other.versionSchedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.VersionSchedule[ versionSchedulePK=" + versionSchedulePK + " ]";
    }

}
