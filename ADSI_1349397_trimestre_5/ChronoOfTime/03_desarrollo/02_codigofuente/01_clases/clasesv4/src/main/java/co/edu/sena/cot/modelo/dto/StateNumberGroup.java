/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "state_number_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateNumberGroup.findAll", query = "SELECT s FROM StateNumberGroup s")
    , @NamedQuery(name = "StateNumberGroup.findByState", query = "SELECT s FROM StateNumberGroup s WHERE s.state = :state")
    ,@NamedQuery(name= "StateNumberGroup.updatePk", query = "UPDATE StateNumberGroup s set s.state = :GroupNew WHERE s.state = :GroupOld")})
public class StateNumberGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<NumberGroup> numberGroupCollection;

    public StateNumberGroup() {
    }

    public StateNumberGroup(Boolean state) {
        this.state = state;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
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
        hash += (state != null ? state.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateNumberGroup)) {
            return false;
        }
        StateNumberGroup other = (StateNumberGroup) object;
        if ((this.state == null && other.state != null) || (this.state != null && !this.state.equals(other.state))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.StateNumberGroup[ state=" + state + " ]";
    }
    
}
