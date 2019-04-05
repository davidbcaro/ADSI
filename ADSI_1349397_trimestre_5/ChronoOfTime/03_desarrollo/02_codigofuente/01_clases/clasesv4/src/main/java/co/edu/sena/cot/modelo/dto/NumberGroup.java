/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "number_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumberGroup.findAll", query = "SELECT n FROM NumberGroup n")
    , @NamedQuery(name = "NumberGroup.findByNumberGroup", query = "SELECT n FROM NumberGroup n WHERE n.numberGroup = :numberGroup")
    , @NamedQuery(name = "NumberGroup.findByDateStart", query = "SELECT n FROM NumberGroup n WHERE n.dateStart = :dateStart")
    , @NamedQuery(name = "NumberGroup.findByDateEnd", query = "SELECT n FROM NumberGroup n WHERE n.dateEnd = :dateEnd")
    , @NamedQuery(name = "NumberGroup.findByRoute", query = "SELECT n FROM NumberGroup n WHERE n.route = :route")
    , @NamedQuery(name = "NumberGroup.findByLikeRoute", query = "SELECT n FROM NumberGroup n WHERE n.route LIKE :route")
    , @NamedQuery(name = "NumberGroup.findByLikeProgramEdition", query = "SELECT n FROM NumberGroup n WHERE n.program.programPK.edition LIKE :programEdition")
    , @NamedQuery(name = "NumberGroup.findByProgramCode", query = "SELECT n FROM NumberGroup n WHERE n.program.programPK.codeProgram = :codeProgram")
    , @NamedQuery(name = "NumberGroup.findByProgramEdition", query = "SELECT n FROM NumberGroup n WHERE n.program.programPK.edition = :edition")
    , @NamedQuery(name = "NumberGroup.updatePk", query = "UPDATE NumberGroup n set n.numberGroup = :GroupNew WHERE n.numberGroup = :GroupOld")
    , @NamedQuery(name = "NumberGroup.findByState", query = "SELECT n FROM NumberGroup n WHERE n.state.state = :state")})
public class NumberGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "number_group", nullable = false)
    private Integer numberGroup;
    @Basic(optional = false)
    @Column(name = "date_start", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Basic(optional = false)
    @Column(name = "date_end", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @Column(name = "route", nullable = false, length = 100)
    private String route;
    @JoinTable(name = "number_group_has_trimester_has_learning_result", joinColumns = {
        @JoinColumn(name = "number_group", referencedColumnName = "number_group", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "competence_code", referencedColumnName = "competence_code", nullable = false)
        , @JoinColumn(name = "levelt_code", referencedColumnName = "levelt_code", nullable = false)
        , @JoinColumn(name = "number_lear", referencedColumnName = "learningr_code", nullable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "program_code", nullable = false)
        , @JoinColumn(name = "learningtri_edition", referencedColumnName = "learning_edition", nullable = false)
        , @JoinColumn(name = "initials_dw", referencedColumnName = "tri_work_initials", nullable = false)
        , @JoinColumn(name = "number_trimester", referencedColumnName = "trimester_number", nullable = false)})
    @ManyToMany
    private Collection<TrimesterHasLearningResult> trimesterHasLearningResultCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numberGroup1")
    private Collection<NumberGroupHasTrimester> numberGroupHasTrimesterCollection;
    @JoinColumns({
        @JoinColumn(name = "program_code", referencedColumnName = "code_program", nullable = false)
        , @JoinColumn(name = "program_edition", referencedColumnName = "edition", nullable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "state", referencedColumnName = "state", nullable = false)
    @ManyToOne(optional = false)
    private StateNumberGroup state;

    public NumberGroup() {
    }

    public NumberGroup(Integer numberGroup) {
        this.numberGroup = numberGroup;
    }

    public NumberGroup(Integer numberGroup, Date dateStart, Date dateEnd, String route) {
        this.numberGroup = numberGroup;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.route = route;
    }

    public Integer getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(Integer numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @XmlTransient
    public Collection<TrimesterHasLearningResult> getTrimesterHasLearningResultCollection() {
        return trimesterHasLearningResultCollection;
    }

    public void setTrimesterHasLearningResultCollection(Collection<TrimesterHasLearningResult> trimesterHasLearningResultCollection) {
        this.trimesterHasLearningResultCollection = trimesterHasLearningResultCollection;
    }

    @XmlTransient
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

    public StateNumberGroup getState() {
        return state;
    }

    public void setState(StateNumberGroup state) {
        this.state = state;
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
        return "co.edu.sena.cot.modelo.dto.NumberGroup[ numberGroup=" + numberGroup + " ]";
    }
    
}
