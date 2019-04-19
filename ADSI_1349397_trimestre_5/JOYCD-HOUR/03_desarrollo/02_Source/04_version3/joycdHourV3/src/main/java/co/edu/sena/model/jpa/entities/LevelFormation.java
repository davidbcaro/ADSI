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
@Table(name = "level_formation")
@NamedQueries({
    @NamedQuery(name = "LevelFormation.findAll", query = "SELECT l FROM LevelFormation l")
    , @NamedQuery(name = "LevelFormation.findByLevelFormation", query = "SELECT l FROM LevelFormation l WHERE l.levelFormation = :levelFormation")
    , @NamedQuery(name = "LevelFormation.findByLikeLevelFormation", query = "SELECT l FROM LevelFormation l WHERE l.levelFormation LIKE :levelFormation")
    , @NamedQuery(name = "LevelFormation.findByStatus", query = "SELECT l FROM LevelFormation l WHERE l.status = :status")
    , @NamedQuery(name = "LevelFormation.updatePrimaryKey", query = "UPDATE LevelFormation l SET l.levelFormation = :levelFormationNew WHERE l.levelFormation = :levelFormationOld")})
public class LevelFormation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "level_formation", nullable = false, length = 20)
    private String levelFormation;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelFormation")
    private Collection<Program> programCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelFormation1")
    private Collection<Trimester> trimesterCollection;

    public LevelFormation() {
    }

    public LevelFormation(String levelFormation) {
        this.levelFormation = levelFormation;
    }

    public LevelFormation(String levelFormation, boolean status) {
        this.levelFormation = levelFormation;
        this.status = status;
    }

    public String getLevelFormation() {
        return levelFormation;
    }

    public void setLevelFormation(String levelFormation) {
        this.levelFormation = levelFormation;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (levelFormation != null ? levelFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LevelFormation)) {
            return false;
        }
        LevelFormation other = (LevelFormation) object;
        if ((this.levelFormation == null && other.levelFormation != null) || (this.levelFormation != null && !this.levelFormation.equals(other.levelFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.LevelFormation[ levelFormation=" + levelFormation + " ]";
    }

}
