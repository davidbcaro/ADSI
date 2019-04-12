/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "phase")
@NamedQueries({
    @NamedQuery(name = "Phase.findAll", query = "SELECT p FROM Phase p"),
    @NamedQuery(name = "Phase.findByNamePhase", query = "SELECT p FROM Phase p WHERE p.phasePK.namePhase = :namePhase"),
    @NamedQuery(name = "Phase.findByState", query = "SELECT p FROM Phase p WHERE p.state = :State"),
    @NamedQuery(name = "Phase.findByCode", query = "SELECT p FROM Phase P WHERE p.phasePK.code = :Code"),
    @NamedQuery(name = "Phase.findByLikeNamePhase", query = "SELECT p FROM Phase p WHERE p.phasePK.namePhase LIKE :namePhase"),
    @NamedQuery(name = "Phase.findByLikeCode", query = "SELECT p FROM Phase p WHERE p.phasePK.code LIKE :Code"),
    @NamedQuery(name = "Phase.updatePrimaryKey", query = "UPDATE Phase p SET p.phasePK.namePhase = :nameNuevo, p.phasePK.code = :CodeNuevo WHERE p.phasePK.namePhase = :nameViejo AND p.phasePK.code = :CodeViejo")
})
public class Phase implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PhasePK phasePK;
    @Column(name = "State")
    private Boolean state;
    @JoinColumn(name = "Code", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public Phase() {
    }

    public Phase(PhasePK phasePK) {
        this.phasePK = phasePK;
    }

    public Phase(String namePhase, String code) {
        this.phasePK = new PhasePK(namePhase, code);
    }

    public PhasePK getPhasePK() {
        return phasePK;
    }

    public void setPhasePK(PhasePK phasePK) {
        this.phasePK = phasePK;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phasePK != null ? phasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phase)) {
            return false;
        }
        Phase other = (Phase) object;
        if ((this.phasePK == null && other.phasePK != null) || (this.phasePK != null && !this.phasePK.equals(other.phasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Phase[ phasePK=" + phasePK + " ]";
    }
    
}
