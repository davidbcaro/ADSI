/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
    @NamedQuery(name = "Trimester.findAll", query = "SELECT t FROM Trimester t")
    , @NamedQuery(name = "Trimester.findByTrimesterName", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.trimesterName = :trimesterName")
    , @NamedQuery(name = "Trimester.findByLikeTrimesterName", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.trimesterName LIKE :trimesterName")
    , @NamedQuery(name = "Trimester.findByWorkingDayInitials", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.workingDayInitials = :workingDayInitials")
    , @NamedQuery(name = "Trimester.findByLikeWorkingDayInitials", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.workingDayInitials LIKE :workingDayInitials")
    , @NamedQuery(name = "Trimester.findByLevelFormation", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.levelFormation = :levelFormation")
    , @NamedQuery(name = "Trimester.findByLikeLevelFormation", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.levelFormation LIKE :levelFormation")
    , @NamedQuery(name = "Trimester.updatePrimaryKey", query = "UPDATE Trimester t set t.trimesterPK.trimesterName = :trimesterNameNew,  t.trimesterPK.workingDayInitials = :workingDayInitialsNew, t.trimesterPK.levelFormation = :levelFormationNew WHERE t.trimesterPK.trimesterName = :trimesterNameOld and t.trimesterPK.workingDayInitials = :workingDayInitialsOld and t.trimesterPK.levelFormation = :levelFormationOld")

})
public class Trimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimesterPK trimesterPK;
    @ManyToMany(mappedBy = "trimesterCollection")
    private Collection<LearningResult> learningResultCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimester")
    private Collection<GroupNumberHasTrimester> groupNumberHasTrimesterCollection;
    @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LevelFormation levelFormation1;
    @JoinColumn(name = "working_day_initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Trimester() {
    }

    public Trimester(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
    }

    public Trimester(String trimesterName, String workingDayInitials, String levelFormation) {
        this.trimesterPK = new TrimesterPK(trimesterName, workingDayInitials, levelFormation);
    }

    public TrimesterPK getTrimesterPK() {
        return trimesterPK;
    }

    public void setTrimesterPK(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
    }

    public Collection<LearningResult> getLearningResultCollection() {
        return learningResultCollection;
    }

    public void setLearningResultCollection(Collection<LearningResult> learningResultCollection) {
        this.learningResultCollection = learningResultCollection;
    }

    public Collection<GroupNumberHasTrimester> getGroupNumberHasTrimesterCollection() {
        return groupNumberHasTrimesterCollection;
    }

    public void setGroupNumberHasTrimesterCollection(Collection<GroupNumberHasTrimester> groupNumberHasTrimesterCollection) {
        this.groupNumberHasTrimesterCollection = groupNumberHasTrimesterCollection;
    }

    public LevelFormation getLevelFormation1() {
        return levelFormation1;
    }

    public void setLevelFormation1(LevelFormation levelFormation1) {
        this.levelFormation1 = levelFormation1;
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
        return "co.edu.sena.model.jpa.entities.Trimester[ trimesterPK=" + trimesterPK + " ]";
    }

}
