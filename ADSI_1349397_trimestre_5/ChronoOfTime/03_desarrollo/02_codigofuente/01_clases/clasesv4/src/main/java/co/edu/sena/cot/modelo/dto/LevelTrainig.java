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
@Table(name = "level_trainig")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LevelTrainig.findAll", query = "SELECT l FROM LevelTrainig l")
    , @NamedQuery(name = "LevelTrainig.findByCode", query = "SELECT l FROM LevelTrainig l WHERE l.code = :code")
    , @NamedQuery(name = "LevelTrainig.findByLikePK", query = "SELECT l FROM LevelTrainig l WHERE l.code LIKE :code")
    , @NamedQuery(name = "LevelTrainig.findByState", query = "SELECT l FROM LevelTrainig l WHERE l.state = :state")
    , @NamedQuery(name = "LevelTrainig.updatePK", query = "UPDATE LevelTrainig l SET l.code = :llaveNueva WHERE l.code = :llaveVieja")})

public class LevelTrainig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelTraCode")
    private Collection<Program> programCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelTrainig")
    private Collection<Trimester> trimesterCollection;

    public LevelTrainig() {
    }

    public LevelTrainig(String code) {
        this.code = code;
    }

    public LevelTrainig(String code, boolean state) {
        this.code = code;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    @XmlTransient
    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LevelTrainig)) {
            return false;
        }
        LevelTrainig other = (LevelTrainig) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.LevelTrainig[ code=" + code + " ]";
    }
    
}
