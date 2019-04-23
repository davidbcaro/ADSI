/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "trimester")
@NamedQueries({
    @NamedQuery(name = "Trimester.findAll", query = "SELECT t FROM Trimester t")})
public class Trimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimesterPK trimesterPK;
    @ManyToMany(mappedBy = "trimesterCollection")
    private Collection<LearningOutcome> learningOutcomeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimester")
    private Collection<NumberGroupHasTrimester> numberGroupHasTrimesterCollection;
    @JoinColumn(name = "training_Level", referencedColumnName = "training_Level", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrainingLevel trainingLevel1;
    @JoinColumn(name = "initials_Working_Day", referencedColumnName = "initials_Working_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Trimester() {
    }

    public Trimester(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
    }

    public Trimester(String nameTrimester, String trainingLevel, String initialsWorkingDay) {
        this.trimesterPK = new TrimesterPK(nameTrimester, trainingLevel, initialsWorkingDay);
    }

    public TrimesterPK getTrimesterPK() {
        return trimesterPK;
    }

    public void setTrimesterPK(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
    }

    public Collection<LearningOutcome> getLearningOutcomeCollection() {
        return learningOutcomeCollection;
    }

    public void setLearningOutcomeCollection(Collection<LearningOutcome> learningOutcomeCollection) {
        this.learningOutcomeCollection = learningOutcomeCollection;
    }

    public Collection<NumberGroupHasTrimester> getNumberGroupHasTrimesterCollection() {
        return numberGroupHasTrimesterCollection;
    }

    public void setNumberGroupHasTrimesterCollection(Collection<NumberGroupHasTrimester> numberGroupHasTrimesterCollection) {
        this.numberGroupHasTrimesterCollection = numberGroupHasTrimesterCollection;
    }

    public TrainingLevel getTrainingLevel1() {
        return trainingLevel1;
    }

    public void setTrainingLevel1(TrainingLevel trainingLevel1) {
        this.trainingLevel1 = trainingLevel1;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trimesterPK != null ? trimesterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimester)) {
            return false;
        }
        Trimester other = (Trimester) object;
        if ((this.trimesterPK == null && other.trimesterPK != null) || (this.trimesterPK != null && !this.trimesterPK.equals(other.trimesterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Trimester[ trimesterPK=" + trimesterPK + " ]";
    }
    
}
