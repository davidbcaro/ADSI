/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "trimester_term")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrimesterTerm.findAll", query = "SELECT t FROM TrimesterTerm t")
    , @NamedQuery(name = "TrimesterTerm.findByIdTrimester", query = "SELECT t FROM TrimesterTerm t WHERE t.idTrimester = :idTrimester")
    , @NamedQuery(name = "TrimesterTerm.findByStartDate", query = "SELECT t FROM TrimesterTerm t WHERE t.startDate = :startDate")
    , @NamedQuery(name = "TrimesterTerm.findByEndDate", query = "SELECT t FROM TrimesterTerm t WHERE t.endDate = :endDate")})
public class TrimesterTerm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_trimester", nullable = false, length = 25)
    private String idTrimester;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimesterTerm")
    private Collection<Edition> editionCollection;

    public TrimesterTerm() {
    }

    public TrimesterTerm(String idTrimester) {
        this.idTrimester = idTrimester;
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

    @XmlTransient
    public Collection<Edition> getEditionCollection() {
        return editionCollection;
    }

    public void setEditionCollection(Collection<Edition> editionCollection) {
        this.editionCollection = editionCollection;
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
        if (!(object instanceof TrimesterTerm)) {
            return false;
        }
        TrimesterTerm other = (TrimesterTerm) object;
        if ((this.idTrimester == null && other.idTrimester != null) || (this.idTrimester != null && !this.idTrimester.equals(other.idTrimester))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.TrimesterTerm[ idTrimester=" + idTrimester + " ]";
    }
    
}
