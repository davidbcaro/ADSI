/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
@Table(name = "current_quarter")
@NamedQueries({
     @NamedQuery(name = "CurrentQuarter.findAll", query = "SELECT s FROM CurrentQuarter s")
    ,@NamedQuery(name = "CurrentQuarter.findByIdCurrentQuarter", query = "SELECT s FROM CurrentQuarter s WHERE s.idCurrentQuarter = :IdCurrentQuarter")
    ,@NamedQuery(name = "CurrentQuarter.findByLikeIdCurrentQuarter", query = "SELECT s FROM CurrentQuarter s WHERE s.idCurrentQuarter LIKE :IdCurrentQuarter")
    ,@NamedQuery(name = "CurrentQuarter.findByStartDate", query = "SELECT s FROM CurrentQuarter s WHERE s.startDate = :StartDate")
    ,
     @NamedQuery(name = "CurrentQuarter.findByEndDate", query = "SELECT s FROM CurrentQuarter s WHERE s.endDate = :EndDate")
    ,
 
    @NamedQuery(name = "CurrentQuarter.updatePk", query = "UPDATE CurrentQuarter s SET s.idCurrentQuarter = :documentoNuevo WHERE s.idCurrentQuarter = :documentoViejo")})
public class CurrentQuarter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Current_Quarter", nullable = false, length = 12)
    private String idCurrentQuarter;
    @Column(name = "start_Date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_Date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentQuarter")
    private Collection<Version> versionCollection;

    public CurrentQuarter() {
    }

    public CurrentQuarter(String idCurrentQuarter) {
        this.idCurrentQuarter = idCurrentQuarter;
    }

    public String getIdCurrentQuarter() {
        return idCurrentQuarter;
    }

    public void setIdCurrentQuarter(String idCurrentQuarter) {
        this.idCurrentQuarter = idCurrentQuarter;
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
        hash += (idCurrentQuarter != null ? idCurrentQuarter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrentQuarter)) {
            return false;
        }
        CurrentQuarter other = (CurrentQuarter) object;
        if ((this.idCurrentQuarter == null && other.idCurrentQuarter != null) || (this.idCurrentQuarter != null && !this.idCurrentQuarter.equals(other.idCurrentQuarter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.CurrentQuarter[ idCurrentQuarter=" + idCurrentQuarter + " ]";
    }
    
}
