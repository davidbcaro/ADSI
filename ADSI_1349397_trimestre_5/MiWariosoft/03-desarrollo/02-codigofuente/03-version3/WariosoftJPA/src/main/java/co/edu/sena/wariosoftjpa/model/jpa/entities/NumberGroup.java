/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
@Table(name = "number_group")
@NamedQueries({
    @NamedQuery(name = "NumberGroup.findAll", query = "SELECT s FROM NumberGroup s ")
    ,@NamedQuery(name = "NumberGroup.findByNumberGroup", query = "SELECT s FROM NumberGroup s WHERE s.numberGroup = :numberGroup ")
    ,
     @NamedQuery(name = "NumberGroup.findByStartDate", query = "SELECT s FROM NumberGroup s WHERE s.startDate = :startDate ")
    ,
    @NamedQuery(name = "NumberGroup.findByEndDate", query = "SELECT s FROM NumberGroup s WHERE s.endDate = :endDate")
    ,
     @NamedQuery(name = "NumberGroup.findByRoute", query = "SELECT s FROM NumberGroup s WHERE s.route = :route ")
    , 
     
      @NamedQuery(name = "NumberGroup.findByNameState", query = "SELECT s FROM NumberGroup s WHERE s.nameState.nameState = :nameState ")
    ,
    @NamedQuery(name = "NumberGroup.findByProgramCode", query = "SELECT s FROM NumberGroup s WHERE s.program.programPK.programCode = :programCode ")
    ,
     @NamedQuery(name = "NumberGroup.findByVersion", query = "SELECT s FROM NumberGroup s WHERE s.program.programPK.version = :version ")
    , 
             @NamedQuery(name = "NumberGroup.findByLikeNameState", query = "SELECT s FROM NumberGroup s WHERE s.nameState.nameState LIKE :nameState")
    ,
             @NamedQuery(name = "NumberGroup.findByLikeProgramCode", query = "SELECT s FROM NumberGroup s WHERE s.program.programPK.programCode LIKE :programCode")
    ,
             @NamedQuery(name = "NumberGroup.findByLikeNumberGroup", query = "SELECT s FROM NumberGroup s WHERE s.numberGroup LIKE :numberGroup")
    ,
             @NamedQuery(name = "NumberGroup.findByLikeVersion", query = "SELECT s FROM NumberGroup s WHERE s.program.programPK.version LIKE :version")
    ,
             
                    @NamedQuery(name = "NumberGroup.updatePk", query = "UPDATE NumberGroup s SET s.numberGroup = :documentoNuevo WHERE s.numberGroup = :documentoViejo")
})
public class NumberGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "number_Group", nullable = false, length = 100)
    private String numberGroup;
    @Basic(optional = false)
    @Column(name = "start_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "route", nullable = false, length = 4)
    private String route;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numberGroup1")
    private Collection<NumberGroupHasTrimester> numberGroupHasTrimesterCollection;
    @JoinColumns({
        @JoinColumn(name = "program_Code", referencedColumnName = "program_Code", nullable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "name_State", referencedColumnName = "name_State", nullable = false)
    @ManyToOne(optional = false)
    private StateNumberGroup nameState;

    public NumberGroup() {
    }

    public NumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public NumberGroup(String numberGroup, Date startDate, Date endDate, String route) {
        this.numberGroup = numberGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.route = route;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Collection<NumberGroupHasTrimester> getNumberGroupHasTrimesterCollection() {
        return numberGroupHasTrimesterCollection;
    }

    public void setNumberGroupHasTrimesterCollection(Collection<NumberGroupHasTrimester> numberGroupHasTrimesterCollection) {
        this.numberGroupHasTrimesterCollection = numberGroupHasTrimesterCollection;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public StateNumberGroup getNameState() {
        return nameState;
    }

    public void setNameState(StateNumberGroup nameState) {
        this.nameState = nameState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberGroup != null ? numberGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumberGroup)) {
            return false;
        }
        NumberGroup other = (NumberGroup) object;
        if ((this.numberGroup == null && other.numberGroup != null) || (this.numberGroup != null && !this.numberGroup.equals(other.numberGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroup[ numberGroup=" + numberGroup + " ]";
    }

}
