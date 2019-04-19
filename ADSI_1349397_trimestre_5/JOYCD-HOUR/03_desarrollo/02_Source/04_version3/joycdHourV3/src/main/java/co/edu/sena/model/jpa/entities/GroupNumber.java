/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "group_number")
@NamedQueries({
    @NamedQuery(name = "GroupNumber.findAll", query = "SELECT g FROM GroupNumber g")
    , @NamedQuery(name = "GroupNumber.findByGroupsNumber", query = "SELECT g FROM GroupNumber g WHERE g.groupsNumber = :groupsNumber")
    , @NamedQuery(name = "GroupNumber.findByLikeGroupsNumber", query = "SELECT g FROM GroupNumber g WHERE g.groupsNumber LIKE :groupsNumber")
    , @NamedQuery(name = "GroupNumber.findByStartDate", query = "SELECT g FROM GroupNumber g WHERE g.startDate = :startDate")
    , @NamedQuery(name = "GroupNumber.findByFinishDate", query = "SELECT g FROM GroupNumber g WHERE g.finishDate = :finishDate")
    , @NamedQuery(name = "GroupNumber.findByRoute", query = "SELECT g FROM GroupNumber g WHERE g.route = :route")
    // campos foraneos 
    , @NamedQuery(name = "GroupNumber.findByProgramCode", query = "SELECT g FROM GroupNumber g WHERE g.program.programPK.programCode = :programCode")
    , @NamedQuery(name = "GroupNumber.findByLikeProgramCode", query = "SELECT g FROM GroupNumber g WHERE g.program.programPK.programCode LIKE :programCode")

    , @NamedQuery(name = "GroupNumber.findByVersionCode", query = "SELECT g FROM GroupNumber g WHERE g.program.programPK.version = :versionCode")
    , @NamedQuery(name = "GroupNumber.findByLikeVersionCode", query = "SELECT g FROM GroupNumber g WHERE g.program.programPK.version LIKE :versionCode")

    , @NamedQuery(name = "GroupNumber.findByStatusGroupNumber", query = "SELECT g FROM GroupNumber g WHERE g.statusGroupNumber.statusName = :statusGroupNumber")
    , @NamedQuery(name = "GroupNumber.findByLikeStatusGroupNumber", query = "SELECT g FROM GroupNumber g WHERE g.statusGroupNumber.statusName LIKE :statusGroupNumber")
     , @NamedQuery(name = "GroupNumber.updatePrimaryKey", query = "UPDATE GroupNumber g set g.groupsNumber = :groupsNumberNew WHERE g.groupsNumber = :groupsNumberOld")
        
})

public class GroupNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "groups_number", nullable = false, length = 20)
    private String groupsNumber;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "finish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    @Column(name = "route", length = 4)
    private String route;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupNumber")
    private Collection<GroupNumberHasTrimester> groupNumberHasTrimesterCollection;
    @JoinColumns({
        @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false)
        , @JoinColumn(name = "version_code", referencedColumnName = "version", nullable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "status_group_number", referencedColumnName = "status_name", nullable = false)
    @ManyToOne(optional = false)
    private StatusGroupNumber statusGroupNumber;

    public GroupNumber() {
    }

    public GroupNumber(String groupsNumber) {
        this.groupsNumber = groupsNumber;
    }

    public String getGroupsNumber() {
        return groupsNumber;
    }

    public void setGroupsNumber(String groupsNumber) {
        this.groupsNumber = groupsNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Collection<GroupNumberHasTrimester> getGroupNumberHasTrimesterCollection() {
        return groupNumberHasTrimesterCollection;
    }

    public void setGroupNumberHasTrimesterCollection(Collection<GroupNumberHasTrimester> groupNumberHasTrimesterCollection) {
        this.groupNumberHasTrimesterCollection = groupNumberHasTrimesterCollection;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public StatusGroupNumber getStatusGroupNumber() {
        return statusGroupNumber;
    }

    public void setStatusGroupNumber(StatusGroupNumber statusGroupNumber) {
        this.statusGroupNumber = statusGroupNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupsNumber != null ? groupsNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupNumber)) {
            return false;
        }
        GroupNumber other = (GroupNumber) object;
        if ((this.groupsNumber == null && other.groupsNumber != null) || (this.groupsNumber != null && !this.groupsNumber.equals(other.groupsNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.GroupNumber[ groupsNumber=" + groupsNumber + " ]";
    }

}
