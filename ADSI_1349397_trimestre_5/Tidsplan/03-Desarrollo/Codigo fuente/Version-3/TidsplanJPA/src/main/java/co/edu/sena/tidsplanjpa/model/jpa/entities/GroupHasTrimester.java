/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
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
@Table(name = "group_has_trimester")
@NamedQueries({
    @NamedQuery(name = "GroupHasTrimester.findAll", query = "SELECT g FROM GroupHasTrimester g")
    , @NamedQuery(name = "GroupHasTrimester.findByNumberGroup", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.numberGroup = :numberGroup")
    , @NamedQuery(name = "GroupHasTrimester.findByLikeNumberGroup", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.numberGroup like :numberGroup")
    , @NamedQuery(name = "GroupHasTrimester.findByNameTrimester", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.nameTrimester = :nameTrimester")
    , @NamedQuery(name = "GroupHasTrimester.findByLikeNameTrimester", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.nameTrimester like :nameTrimester")
    , @NamedQuery(name = "GroupHasTrimester.findByWorkingdayInitials", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.workingdayInitials = :workingdayInitials")
    , @NamedQuery(name = "GroupHasTrimester.findByLikeWorkingdayInitials", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.workingdayInitials like :workingdayInitials")
    , @NamedQuery(name = "GroupHasTrimester.findByLevelFormation", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.levelFormation = :levelFormation")
    , @NamedQuery(name = "GroupHasTrimester.findByLikeLevelFormation", query = "SELECT g FROM GroupHasTrimester g WHERE g.groupHasTrimesterPK.levelFormation like :levelFormation")
    , @NamedQuery(name = "GroupHasTrimester.updatePrimaryKey", query = "UPDATE GroupHasTrimester ght set ght.groupHasTrimesterPK.numberGroup =:newNumberGroup, ght.groupHasTrimesterPK.nameTrimester =:newNameTrimester, ght.groupHasTrimesterPK.workingdayInitials =:newWorkingDayInitials, ght.groupHasTrimesterPK.levelFormation =:newLevelFormation WHERE ght.groupHasTrimesterPK.numberGroup =:oldNumberGroup and ght.groupHasTrimesterPK.nameTrimester = :oldNameTrimester and ght.groupHasTrimesterPK.workingdayInitials =:oldWorkingDayInitials and ght.groupHasTrimesterPK.levelFormation =:oldLevelFormation")})
public class GroupHasTrimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupHasTrimesterPK groupHasTrimesterPK;
    @JoinTable(name = "results_viewed", joinColumns = {
        @JoinColumn(name = "number_group", referencedColumnName = "number_group", nullable = false)
        , @JoinColumn(name = "name_trimester", referencedColumnName = "name_trimester", nullable = false)
        , @JoinColumn(name = "workingday_initials", referencedColumnName = "workingday_initials", nullable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "lr_code", referencedColumnName = "id_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false)
        , @JoinColumn(name = "competition_code", referencedColumnName = "competition_code", nullable = false)
        , @JoinColumn(name = "program_version", referencedColumnName = "program_version", nullable = false)})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumn(name = "number_group", referencedColumnName = "number_group", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficha ficha;
    @JoinColumns({
        @JoinColumn(name = "name_trimester", referencedColumnName = "name_trimester", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "workingday_initials", referencedColumnName = "workingday_initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Trimester trimester;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupHasTrimester")
    private Collection<Schedule> scheduleCollection;

    public GroupHasTrimester() {
    }

    public GroupHasTrimester(GroupHasTrimesterPK groupHasTrimesterPK) {
        this.groupHasTrimesterPK = groupHasTrimesterPK;
    }

    public GroupHasTrimester(String numberGroup, String nameTrimester, String workingdayInitials, String levelFormation) {
        this.groupHasTrimesterPK = new GroupHasTrimesterPK(numberGroup, nameTrimester, workingdayInitials, levelFormation);
    }

    public GroupHasTrimesterPK getGroupHasTrimesterPK() {
        return groupHasTrimesterPK;
    }

    public void setGroupHasTrimesterPK(GroupHasTrimesterPK groupHasTrimesterPK) {
        this.groupHasTrimesterPK = groupHasTrimesterPK;
    }

    public Collection<LearningResult> getLearningResultCollection() {
        return learningResultCollection;
    }

    public void setLearningResultCollection(Collection<LearningResult> learningResultCollection) {
        this.learningResultCollection = learningResultCollection;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Trimester getTrimester() {
        return trimester;
    }

    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupHasTrimesterPK != null ? groupHasTrimesterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupHasTrimester)) {
            return false;
        }
        GroupHasTrimester other = (GroupHasTrimester) object;
        if ((this.groupHasTrimesterPK == null && other.groupHasTrimesterPK != null) || (this.groupHasTrimesterPK != null && !this.groupHasTrimesterPK.equals(other.groupHasTrimesterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimester[ groupHasTrimesterPK=" + groupHasTrimesterPK + " ]";
    }
    
}
