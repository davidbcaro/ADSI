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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "status_group_number")
@NamedQueries({
    @NamedQuery(name = "StatusGroupNumber.findAll", query = "SELECT s FROM StatusGroupNumber s")
    , @NamedQuery(name = "StatusGroupNumber.findByStatusName", query = "SELECT s FROM StatusGroupNumber s WHERE s.statusName = :statusName")
    , @NamedQuery(name = "StatusGroupNumber.findByStatus", query = "SELECT s FROM StatusGroupNumber s WHERE s.status = :status")
    , @NamedQuery(name = "StatusGroupNumber.findByLikeStatusName", query = "SELECT s FROM StatusGroupNumber s WHERE s.statusName LIKE :statusName")
    ,  @NamedQuery(name = "StatusGroupNumber.updatePrimaryKey", query = "UPDATE StatusGroupNumber s SET s.statusName = :estadoNuevo WHERE s.statusName = :estadoAntiguo")
})
public class StatusGroupNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status_name", nullable = false, length = 20)
    private String statusName;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusGroupNumber")
    private Collection<GroupNumber> groupNumberCollection;

    public StatusGroupNumber() {
    }

    public StatusGroupNumber(String statusName) {
        this.statusName = statusName;
    }

    public StatusGroupNumber(String statusName, boolean status) {
        this.statusName = statusName;
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<GroupNumber> getGroupNumberCollection() {
        return groupNumberCollection;
    }

    public void setGroupNumberCollection(Collection<GroupNumber> groupNumberCollection) {
        this.groupNumberCollection = groupNumberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusName != null ? statusName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusGroupNumber)) {
            return false;
        }
        StatusGroupNumber other = (StatusGroupNumber) object;
        if ((this.statusName == null && other.statusName != null) || (this.statusName != null && !this.statusName.equals(other.statusName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.StatusGroupNumber[ statusName=" + statusName + " ]";
    }
    
}
