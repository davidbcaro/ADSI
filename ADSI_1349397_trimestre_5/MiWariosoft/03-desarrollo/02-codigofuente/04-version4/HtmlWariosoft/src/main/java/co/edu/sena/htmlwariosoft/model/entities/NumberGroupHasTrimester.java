/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "number_group_has_trimester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumberGroupHasTrimester.findAll", query = "SELECT n FROM NumberGroupHasTrimester n")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByNumberGroup", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.numberGroup = :numberGroup")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByNameTrimester", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.nameTrimester = :nameTrimester")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByInitialsWorkingDay", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.initialsWorkingDay = :initialsWorkingDay")
    , @NamedQuery(name = "NumberGroupHasTrimester.findByTrainingLevel", query = "SELECT n FROM NumberGroupHasTrimester n WHERE n.numberGroupHasTrimesterPK.trainingLevel = :trainingLevel")})
public class NumberGroupHasTrimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumberGroupHasTrimesterPK numberGroupHasTrimesterPK;
    @ManyToMany(mappedBy = "numberGroupHasTrimesterCollection", fetch = FetchType.LAZY)
    private Collection<LearningOutcome> learningOutcomeCollection;
    @JoinColumn(name = "number_Group", referencedColumnName = "number_Group", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NumberGroup numberGroup1;
    @JoinColumns({
        @JoinColumn(name = "name_Trimester", referencedColumnName = "name_Trimester", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "initials_Working_Day", referencedColumnName = "initials_Working_Day", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "training_Level", referencedColumnName = "training_Level", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trimester trimester;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numberGroupHasTrimester", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public NumberGroupHasTrimester() {
    }

    public NumberGroupHasTrimester(NumberGroupHasTrimesterPK numberGroupHasTrimesterPK) {
        this.numberGroupHasTrimesterPK = numberGroupHasTrimesterPK;
    }

    public NumberGroupHasTrimester(String numberGroup, String nameTrimester, String initialsWorkingDay, String trainingLevel) {
        this.numberGroupHasTrimesterPK = new NumberGroupHasTrimesterPK(numberGroup, nameTrimester, initialsWorkingDay, trainingLevel);
    }

    public NumberGroupHasTrimesterPK getNumberGroupHasTrimesterPK() {
        return numberGroupHasTrimesterPK;
    }

    public void setNumberGroupHasTrimesterPK(NumberGroupHasTrimesterPK numberGroupHasTrimesterPK) {
        this.numberGroupHasTrimesterPK = numberGroupHasTrimesterPK;
    }

    @XmlTransient
    public Collection<LearningOutcome> getLearningOutcomeCollection() {
        return learningOutcomeCollection;
    }

    public void setLearningOutcomeCollection(Collection<LearningOutcome> learningOutcomeCollection) {
        this.learningOutcomeCollection = learningOutcomeCollection;
    }

    public NumberGroup getNumberGroup1() {
        return numberGroup1;
    }

    public void setNumberGroup1(NumberGroup numberGroup1) {
        this.numberGroup1 = numberGroup1;
    }

    public Trimester getTrimester() {
        return trimester;
    }

    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberGroupHasTrimesterPK != null ? numberGroupHasTrimesterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberGroupHasTrimester)) {
            return false;
        }
        NumberGroupHasTrimester other = (NumberGroupHasTrimester) object;
        if ((this.numberGroupHasTrimesterPK == null && other.numberGroupHasTrimesterPK != null) || (this.numberGroupHasTrimesterPK != null && !this.numberGroupHasTrimesterPK.equals(other.numberGroupHasTrimesterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimester[ numberGroupHasTrimesterPK=" + numberGroupHasTrimesterPK + " ]";
    }
    
}
