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
@Table(name = "training_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingLevel.findAll", query = "SELECT t FROM TrainingLevel t")
    , @NamedQuery(name = "TrainingLevel.findByTrainingLevel", query = "SELECT t FROM TrainingLevel t WHERE t.trainingLevel = :trainingLevel")
    , @NamedQuery(name = "TrainingLevel.findByState", query = "SELECT t FROM TrainingLevel t WHERE t.state = :state")})
public class TrainingLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "training_Level", nullable = false, length = 20)
    private String trainingLevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state", nullable = false)
    private boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingLevel", fetch = FetchType.LAZY)
    private Collection<Program> programCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingLevel1", fetch = FetchType.LAZY)
    private Collection<Trimester> trimesterCollection;

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
        return "co.edu.sena.htmlwariosoft.model.entities.TrainingLevel[ trainingLevel=" + trainingLevel + " ]";
    }
    
}
