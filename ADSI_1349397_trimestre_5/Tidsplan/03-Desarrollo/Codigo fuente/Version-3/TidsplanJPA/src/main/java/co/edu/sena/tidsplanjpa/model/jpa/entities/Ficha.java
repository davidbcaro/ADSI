/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
@Table(name = "ficha")
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f")
    , @NamedQuery(name = "Ficha.findByNumberGroup", query = "SELECT f FROM Ficha f WHERE f.numberGroup = :numberGroup")
    , @NamedQuery(name = "Ficha.findByLikeNumberGroup", query = "SELECT f FROM Ficha f WHERE f.numberGroup like :numberGroup")
    , @NamedQuery(name = "Ficha.findByEndDate", query = "SELECT f FROM Ficha f WHERE f.endDate = :endDate")
    , @NamedQuery(name = "Ficha.findByLikeEndDate", query = "SELECT f FROM Ficha f WHERE f.endDate like :endDate")
    , @NamedQuery(name = "Ficha.findByRoute", query = "SELECT f FROM Ficha f WHERE f.route = :route")
    , @NamedQuery(name = "Ficha.findByLikeRoute", query = "SELECT f FROM Ficha f WHERE f.route like :route")
    , @NamedQuery(name = "Ficha.findByStartDate", query = "SELECT f FROM Ficha f WHERE f.startDate = :startDate")
    , @NamedQuery(name = "Ficha.findByLikeStartDate", query = "SELECT f FROM Ficha f WHERE f.startDate like :startDate")
    , @NamedQuery(name = "Ficha.findByNameState", query = "SELECT f FROM Ficha f WHERE f.nameState.nameState = :nameState")
    , @NamedQuery(name = "Ficha.findByLikeNameState", query = "SELECT f FROM Ficha f WHERE f.nameState.nameState like :nameState")
    , @NamedQuery(name = "Ficha.findByVersion", query = "SELECT f FROM Ficha f WHERE f.trainingProgram.trainingProgramPK.version = :version")
    , @NamedQuery(name = "Ficha.findByLikeVersion", query = "SELECT f FROM Ficha f WHERE f.trainingProgram.trainingProgramPK.version like :version")
    , @NamedQuery(name = "Ficha.findByProgramCode", query = "SELECT f FROM Ficha f WHERE f.trainingProgram.trainingProgramPK.idCode = :programCode")
    , @NamedQuery(name = "Ficha.findByLikeProgramCode", query = "SELECT f FROM Ficha f WHERE f.trainingProgram.trainingProgramPK.idCode like :programCode")
    , @NamedQuery(name = "Ficha.updatePrimaryKey", query = "UPDATE Ficha f set f.numberGroup = :newNumberGroup WHERE f.numberGroup =:oldNumberGroup")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "number_group", nullable = false, length = 100)
    private String numberGroup;
    @Basic(optional = false)
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "route", nullable = false, length = 15)
    private String route;
    @Basic(optional = false)
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
    private Collection<GroupHasTrimester> groupHasTrimesterCollection;
    @JoinColumn(name = "name_state", referencedColumnName = "name_state", nullable = false)
    @ManyToOne(optional = false)
    private StateGroup nameState;
    @JoinColumns({
        @JoinColumn(name = "program_code", referencedColumnName = "id_code", nullable = false)
        , @JoinColumn(name = "version", referencedColumnName = "version", nullable = false)})
    @ManyToOne(optional = false)
    private TrainingProgram trainingProgram;

    public Ficha() {
    }

    public Ficha(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Ficha(String numberGroup, Date endDate, String route, Date startDate) {
        this.numberGroup = numberGroup;
        this.endDate = endDate;
        this.route = route;
        this.startDate = startDate;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Collection<GroupHasTrimester> getGroupHasTrimesterCollection() {
        return groupHasTrimesterCollection;
    }

    public void setGroupHasTrimesterCollection(Collection<GroupHasTrimester> groupHasTrimesterCollection) {
        this.groupHasTrimesterCollection = groupHasTrimesterCollection;
    }

    public StateGroup getNameState() {
        return nameState;
    }

    public void setNameState(StateGroup nameState) {
        this.nameState = nameState;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
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
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.numberGroup == null && other.numberGroup != null) || (this.numberGroup != null && !this.numberGroup.equals(other.numberGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.Ficha[ numberGroup=" + numberGroup + " ]";
    }
    
}
