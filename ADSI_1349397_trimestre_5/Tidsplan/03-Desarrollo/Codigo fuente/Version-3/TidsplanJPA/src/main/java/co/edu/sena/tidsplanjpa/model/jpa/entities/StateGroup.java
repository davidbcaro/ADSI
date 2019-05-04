/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
@Table(name = "state_group")
@NamedQueries({
    @NamedQuery(name = "StateGroup.findAll", query = "SELECT s FROM StateGroup s")
    , @NamedQuery(name = "StateGroup.findByNameState", query = "SELECT s FROM StateGroup s WHERE s.nameState = :nameState")
    , @NamedQuery(name = "StateGroup.findByLikeNameState", query = "SELECT s FROM StateGroup s WHERE s.nameState like  :nameState")
    , @NamedQuery(name = "StateGroup.findByStatus", query = "SELECT s FROM StateGroup s WHERE s.status = :status")
    , @NamedQuery(name = "StateGroup.updatePrimaryKey", query = "UPDATE StateGroup s SET s.nameState = :nsNew WHERE s.nameState = :nsOld")})
public class StateGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_state", nullable = false, length = 15)
    private String nameState;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameState")
    private Collection<Ficha> fichaCollection;

    public StateGroup() {
    }

    public StateGroup(String nameState) {
        this.nameState = nameState;
    }

    public StateGroup(String nameState, boolean status) {
        this.nameState = nameState;
        this.status = status;
    }

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameState != null ? nameState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateGroup)) {
            return false;
        }
        StateGroup other = (StateGroup) object;
        if ((this.nameState == null && other.nameState != null) || (this.nameState != null && !this.nameState.equals(other.nameState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.StateGroup[ nameState=" + nameState + " ]";
    }

}
