/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
@Table(name = "trimester_current")
@NamedQueries({
    @NamedQuery(name = "TrimesterCurrent.findAll", query = "SELECT t FROM TrimesterCurrent t")
    , @NamedQuery(name = "TrimesterCurrent.findByIdTrimester", query = "SELECT t FROM TrimesterCurrent t WHERE t.idTrimester = :idTrimester")
    , @NamedQuery(name = "TrimesterCurrent.findByLikeIdTrimester", query = "SELECT t FROM TrimesterCurrent t WHERE t.idTrimester like :idTrimester")
    , @NamedQuery(name = "TrimesterCurrent.findByStartDate", query = "SELECT t FROM TrimesterCurrent t WHERE t.startDate = :startDate")
    , @NamedQuery(name = "TrimesterCurrent.findByLikeStartDate", query = "SELECT t FROM TrimesterCurrent t WHERE t.startDate like :startDate")
    , @NamedQuery(name = "TrimesterCurrent.findByEndDate", query = "SELECT t FROM TrimesterCurrent t WHERE t.endDate = :endDate")
    , @NamedQuery(name = "TrimesterCurrent.findByLikeEndDate", query = "SELECT t FROM TrimesterCurrent t WHERE t.endDate like :endDate")
    , @NamedQuery(name = "TrimesterCurrent.updatePrimaryKey", query = "UPDATE TrimesterCurrent t set t.idTrimester = :newTrimesterCurrent WHERE t.idTrimester = :oldTrimesterCurrent")})
public class TrimesterCurrent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_trimester", nullable = false, length = 10)
    private String idTrimester;
    @Basic(optional = false)
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimesterCurrent")
    private Collection<Version> versionCollection;

    public TrimesterCurrent() {
    }

    public TrimesterCurrent(String idTrimester) {
        this.idTrimester = idTrimester;
    }

    public TrimesterCurrent(String idTrimester, Date startDate, Date endDate) {
        this.idTrimester = idTrimester;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getIdTrimester() {
        return idTrimester;
    }

    public void setIdTrimester(String idTrimester) {
        this.idTrimester = idTrimester;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Collection<Version> getVersionCollection() {
        return versionCollection;
    }

    public void setVersionCollection(Collection<Version> versionCollection) {
        this.versionCollection = versionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimester != null ? idTrimester.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimesterCurrent)) {
            return false;
        }
        TrimesterCurrent other = (TrimesterCurrent) object;
        if ((this.idTrimester == null && other.idTrimester != null) || (this.idTrimester != null && !this.idTrimester.equals(other.idTrimester))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.TrimesterCurrent[ idTrimester=" + idTrimester + " ]";
    }

    public void getStartDate(Date parse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
