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
@Table(name = "formation_level")
@NamedQueries({
    @NamedQuery(name = "FormationLevel.findAll", query = "SELECT f FROM FormationLevel f")
    , @NamedQuery(name = "FormationLevel.findByLevelFormation", query = "SELECT f FROM FormationLevel f WHERE f.levelFormation = :levelFormation")
    , @NamedQuery(name = "FormationLevel.findByLikeLevelFormation", query = "SELECT f FROM FormationLevel f WHERE f.levelFormation like :levelFormation")
    , @NamedQuery(name = "FormationLevel.findByStatus", query = "SELECT f FROM FormationLevel f WHERE f.status = :status")
    , @NamedQuery(name = "FormationLevel.updatePrimaryKey", query =  "UPDATE FormationLevel f SET f.levelFormation = :lfNew WHERE f.levelFormation = :lfOld")})

public class FormationLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "level_formation", nullable = false, length = 45)
    private String levelFormation;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formationLevel")
    private Collection<Trimester> trimesterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelFormation")
    private Collection<TrainingProgram> trainingProgramCollection;

    public FormationLevel() {
    }

    public FormationLevel(String levelFormation) {
        this.levelFormation = levelFormation;
    }

    public FormationLevel(String levelFormation, boolean status) {
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

    public Collection<Trimester> getTrimesterCollection() {
        return trimesterCollection;
    }

    public void setTrimesterCollection(Collection<Trimester> trimesterCollection) {
        this.trimesterCollection = trimesterCollection;
    }

    public Collection<TrainingProgram> getTrainingProgramCollection() {
        return trainingProgramCollection;
    }

    public void setTrainingProgramCollection(Collection<TrainingProgram> trainingProgramCollection) {
        this.trainingProgramCollection = trainingProgramCollection;
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
        if (!(object instanceof FormationLevel)) {
            return false;
        }
        FormationLevel other = (FormationLevel) object;
        if ((this.levelFormation == null && other.levelFormation != null) || (this.levelFormation != null && !this.levelFormation.equals(other.levelFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.FormationLevel[ levelFormation=" + levelFormation + " ]";
    }

}
