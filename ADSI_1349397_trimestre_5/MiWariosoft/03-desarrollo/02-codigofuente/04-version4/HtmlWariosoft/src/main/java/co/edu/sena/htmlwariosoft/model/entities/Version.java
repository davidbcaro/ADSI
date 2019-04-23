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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v")
    , @NamedQuery(name = "Version.findByIdVersion", query = "SELECT v FROM Version v WHERE v.versionPK.idVersion = :idVersion")
    , @NamedQuery(name = "Version.findByActive", query = "SELECT v FROM Version v WHERE v.active = :active")
    , @NamedQuery(name = "Version.findByIdCurrentQuarter", query = "SELECT v FROM Version v WHERE v.versionPK.idCurrentQuarter = :idCurrentQuarter")})
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VersionPK versionPK;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "id_Current_Quarter", referencedColumnName = "id_Current_Quarter", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CurrentQuarter currentQuarter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "version", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public Version() {
    }

    public Version(VersionPK versionPK) {
        this.versionPK = versionPK;
    }

    public Version(int idVersion, String idCurrentQuarter) {
        this.versionPK = new VersionPK(idVersion, idCurrentQuarter);
    }

    public VersionPK getVersionPK() {
        return versionPK;
    }

    public void setVersionPK(VersionPK versionPK) {
        this.versionPK = versionPK;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CurrentQuarter getCurrentQuarter() {
        return currentQuarter;
    }

    public void setCurrentQuarter(CurrentQuarter currentQuarter) {
        this.currentQuarter = currentQuarter;
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
        return "co.edu.sena.htmlwariosoft.model.entities.Version[ versionPK=" + versionPK + " ]";
    }
    
}
