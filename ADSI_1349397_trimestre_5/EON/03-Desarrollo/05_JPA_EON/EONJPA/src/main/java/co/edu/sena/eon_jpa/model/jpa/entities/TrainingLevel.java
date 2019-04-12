/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author LUISBERNARDO
 */
@Entity
@Table(name = "training_level")
@NamedQueries({
    @NamedQuery(name = "TrainingLevel.findAll", query = "SELECT t FROM TrainingLevel t"),
    @NamedQuery(name = "TrainingLevel.findByTrainingLevel", query = "SELECT t FROM TrainingLevel t WHERE t.trainingLevel = :trainingLevel"),
    @NamedQuery(name = "TrainingLevel.findByState", query = "SELECT t FROM TrainingLevel t WHERE t.state = :State"),
    @NamedQuery(name = "TrainingLevel.findByLikeTrainingLevel", query = "SELECT t FROM TrainingLevel T WHERE t.trainingLevel LIKE :trainingLevel"),
    @NamedQuery(name = "TrainingLevel.updatePrimaryKey", query = "UPDATE TrainingLevel t SET t.trainingLevel = :TrainingLevelNuevo WHERE t.trainingLevel = :TrainingLevelViejo")
})
public class TrainingLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "training_Level", nullable = false, length = 20)
    private String trainingLevel;
    @Basic(optional = false)
    @Column(name = "State", nullable = false)
    private boolean state;

    public TrainingLevel() {
    }

    public TrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public TrainingLevel(String trainingLevel, boolean state) {
        this.trainingLevel = trainingLevel;
        this.state = state;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingLevel != null ? trainingLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingLevel)) {
            return false;
        }
        TrainingLevel other = (TrainingLevel) object;
        if ((this.trainingLevel == null && other.trainingLevel != null) || (this.trainingLevel != null && !this.trainingLevel.equals(other.trainingLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.TrainingLevel[ trainingLevel=" + trainingLevel + " ]";
    }
    
}
