/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
@Table(name = "state_number_group")
@NamedQueries({
    @NamedQuery(name = "StateNumberGroup.findAll", query = "SELECT s FROM StateNumberGroup s")
    ,@NamedQuery(name = "StateNumberGroup.findByNameState", query = "SELECT s FROM StateNumberGroup s WHERE s.nameState = :NameState")
    ,@NamedQuery(name = "StateNumberGroup.findByLikeNameState", query = "SELECT s FROM StateNumberGroup s WHERE s.nameState LIKE :NameState"),
     @NamedQuery(name = "StateNumberGroup.findByState", query = "SELECT s FROM StateNumberGroup s WHERE s.state = :state"),
     @NamedQuery(name = "StateNumberGroup.updatePk", query = "UPDATE StateNumberGroup s SET s.nameState = :documentoNuevo WHERE s.nameState = :documentoViejo")

})
public class StateNumberGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_State", nullable = false, length = 20)
    private String nameState;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameState")
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
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup[ nameState=" + nameState + " ]";
    }

}
