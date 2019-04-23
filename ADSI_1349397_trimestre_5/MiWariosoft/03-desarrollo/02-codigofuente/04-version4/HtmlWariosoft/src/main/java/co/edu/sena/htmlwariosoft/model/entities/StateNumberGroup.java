/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "state_number_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateNumberGroup.findAll", query = "SELECT s FROM StateNumberGroup s")
    , @NamedQuery(name = "StateNumberGroup.findByNameState", query = "SELECT s FROM StateNumberGroup s WHERE s.nameState = :nameState")
    , @NamedQuery(name = "StateNumberGroup.findByState", query = "SELECT s FROM StateNumberGroup s WHERE s.state = :state")})
public class StateNumberGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name_State", nullable = false, length = 20)
    private String nameState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameState", fetch = FetchType.LAZY)
    private Collection<NumberGroup> numberGroupCollection;

    public StateNumberGroup() {
    }

    public StateNumberGroup(String nameState) {
        this.nameState = nameState;
    }

    public StateNumberGroup(String nameState, boolean state) {
        this.nameState = nameState;
        this.state = state;
    }

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<NumberGroup> getNumberGroupCollection() {
        return numberGroupCollection;
    }

    public void setNumberGroupCollection(Collection<NumberGroup> numberGroupCollection) {
        this.numberGroupCollection = numberGroupCollection;
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
        if (!(object instanceof StateNumberGroup)) {
            return false;
        }
        StateNumberGroup other = (StateNumberGroup) object;
        if ((this.nameState == null && other.nameState != null) || (this.nameState != null && !this.nameState.equals(other.nameState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.StateNumberGroup[ nameState=" + nameState + " ]";
    }
    
}
