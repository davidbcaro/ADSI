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
@Table(name = "version")
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v")
    , @NamedQuery(name = "Version.findByStatus", query = "SELECT v FROM Version v WHERE v.status = :status")
    , @NamedQuery(name = "Version.findByIdVersion", query = "SELECT v FROM Version v WHERE v.versionPK.idVersion = :idVersion")
    , @NamedQuery(name = "Version.findByLikeIdVersion", query = "SELECT v FROM Version v WHERE v.versionPK.idVersion like :idVersion")
    , @NamedQuery(name = "Version.findByIdTrimesterCurrent", query = "SELECT v FROM Version v WHERE v.versionPK.idTrimesterCurrent = :idTrimesterCurrent")
    , @NamedQuery(name = "Version.findByLikeIdTrimesterCurrent", query = "SELECT v FROM Version v WHERE v.versionPK.idTrimesterCurrent like :idTrimesterCurrent")
    , @NamedQuery(name = "Version.updatePrimaryKey", query = "UPDATE Version v set v.versionPK.idVersion = :newIdVersion, v.versionPK.idTrimesterCurrent = :newIdTrimesterCurrent WHERE v.versionPK.idVersion = :oldIdVersion and v.versionPK.idTrimesterCurrent = :oldIdTrimesterCurrent")})
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VersionPK versionPK;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "id_trimester_current", referencedColumnName = "id_trimester", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrimesterCurrent trimesterCurrent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "version")
    private Collection<Schedule> scheduleCollection;

    public Version() {
    }

    public Version(VersionPK versionPK) {
        this.versionPK = versionPK;
    }

    public Version(int idVersion, String idTrimesterCurrent) {
        this.versionPK = new VersionPK(idVersion, idTrimesterCurrent);
    }

    public VersionPK getVersionPK() {
        return versionPK;
    }

    public void setVersionPK(VersionPK versionPK) {
        this.versionPK = versionPK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TrimesterCurrent getTrimesterCurrent() {
        return trimesterCurrent;
    }

    public void setTrimesterCurrent(TrimesterCurrent trimesterCurrent) {
        this.trimesterCurrent = trimesterCurrent;
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
        hash += (versionPK != null ? versionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.versionPK == null && other.versionPK != null) || (this.versionPK != null && !this.versionPK.equals(other.versionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Version[ versionPK=" + versionPK + " ]";
    }
    
}
