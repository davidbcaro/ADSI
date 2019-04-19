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
@Table(name = "group_number_has_trimester")
@NamedQueries({
    @NamedQuery(name = "GroupNumberHasTrimester.findAll", query = "SELECT g FROM GroupNumberHasTrimester g")
    , @NamedQuery(name = "GroupNumberHasTrimester.findByGroupsNumber", query = "SELECT g FROM GroupNumberHasTrimester g WHERE g.groupNumberHasTrimesterPK.groupsNumber = :groupsNumber")
    , @NamedQuery(name = "GroupNumberHasTrimester.findByTrimesterName", query = "SELECT g FROM GroupNumberHasTrimester g WHERE g.groupNumberHasTrimesterPK.trimesterName = :trimesterName")
    , @NamedQuery(name = "GroupNumberHasTrimester.findByWorkingDayInitials", query = "SELECT g FROM GroupNumberHasTrimester g WHERE g.groupNumberHasTrimesterPK.workingDayInitials = :workingDayInitials")
    , @NamedQuery(name = "GroupNumberHasTrimester.findByLevelFormation", query = "SELECT g FROM GroupNumberHasTrimester g WHERE g.groupNumberHasTrimesterPK.levelFormation = :levelFormation")})
public class GroupNumberHasTrimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupNumberHasTrimesterPK groupNumberHasTrimesterPK;
    @JoinTable(name = "group_number_has_trimester_has_learning_result", joinColumns = {
        @JoinColumn(name = "group_number", referencedColumnName = "groups_number", nullable = false)
        , @JoinColumn(name = "trimester_name", referencedColumnName = "trimester_name", nullable = false)
        , @JoinColumn(name = "working_day_initials", referencedColumnName = "working_day_initials", nullable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "learning_result_code", referencedColumnName = "learning_result_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "Program_code", nullable = false)
        , @JoinColumn(name = "competence_code", referencedColumnName = "competence_code", nullable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false)})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumn(name = "groups_number", referencedColumnName = "groups_number", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupNumber groupNumber;
    @JoinColumns({
        @JoinColumn(name = "trimester_name", referencedColumnName = "trimester_name", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "working_day_initials", referencedColumnName = "working_day_initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Trimester trimester;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupNumberHasTrimester")
    private Collection<Schedule> scheduleCollection;

    public GroupNumberHasTrimester() {
    }

    public GroupNumberHasTrimester(GroupNumberHasTrimesterPK groupNumberHasTrimesterPK) {
        this.groupNumberHasTrimesterPK = groupNumberHasTrimesterPK;
    }

    public GroupNumberHasTrimester(String groupsNumber, String trimesterName, String workingDayInitials, String levelFormation) {
        this.groupNumberHasTrimesterPK = new GroupNumberHasTrimesterPK(groupsNumber, trimesterName, workingDayInitials, levelFormation);
    }

    public GroupNumberHasTrimesterPK getGroupNumberHasTrimesterPK() {
        return groupNumberHasTrimesterPK;
    }

    public void setGroupNumberHasTrimesterPK(GroupNumberHasTrimesterPK groupNumberHasTrimesterPK) {
        this.groupNumberHasTrimesterPK = groupNumberHasTrimesterPK;
    }

    public Collection<LearningResult> getLearningResultCollection() {
        return learningResultCollection;
    }

    public void setLearningResultCollection(Collection<LearningResult> learningResultCollection) {
        this.learningResultCollection = learningResultCollection;
    }

    public GroupNumber getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(GroupNumber groupNumber) {
        this.groupNumber = groupNumber;
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
        hash += (groupNumberHasTrimesterPK != null ? groupNumberHasTrimesterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupNumberHasTrimester)) {
            return false;
        }
        GroupNumberHasTrimester other = (GroupNumberHasTrimester) object;
        if ((this.groupNumberHasTrimesterPK == null && other.groupNumberHasTrimesterPK != null) || (this.groupNumberHasTrimesterPK != null && !this.groupNumberHasTrimesterPK.equals(other.groupNumberHasTrimesterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.GroupNumberHasTrimester[ groupNumberHasTrimesterPK=" + groupNumberHasTrimesterPK + " ]";
    }
    
}
