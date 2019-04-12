/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
@Table(name = "status_ficha")
@NamedQueries({
    @NamedQuery(name = "StatusFicha.findAll", query = "SELECT s FROM StatusFicha s")
    ,@NamedQuery(name = "StatusFicha.findByNameState", query = "SELECT s FROM StatusFicha s WHERE s.nameState = :nameState")
//    ,@NamedQuery(name = "StatusFicha.findByState", query = "SELECT s FROM StatusFicha s WHERE s.state = :state")
    ,@NamedQuery(name = "StatusFicha.updatePrimaryKey", query = "UPDATE StatusFicha s SET s.nameState = :nameStateNuevo WHERE s.nameState = :nameStateViejo")
    ,@NamedQuery(name ="StatusFicha.findByLikeNameState",query="SELECT s FROM StatusFicha s WHERE s.nameState LIKE :nameState")
})
public class StatusFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_State", nullable = false, length = 20)
    private String nameState;
    @Basic(optional = false)
    @Column(name = "State", nullable = false, length = 45)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nameState")
    private Collection<Ficha> fichaCollection;

    public StatusFicha() {
    }

    public StatusFicha(String nameState) {
        this.nameState = nameState;
    }

    public StatusFicha(String nameState, boolean state) {
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
        if (!(object instanceof StatusFicha)) {
            return false;
        }
        StatusFicha other = (StatusFicha) object;
        if ((this.nameState == null && other.nameState != null) || (this.nameState != null && !this.nameState.equals(other.nameState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.StatusFicha[ nameState=" + nameState + " ]";
    }
    
}
