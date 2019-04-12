/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
//    ,@NamedQuery(name = "Ficha.findByNumberFicha", query = "SELECT f FROM Ficha f WHERE f.numberFicha =:numberFicha")
//    ,@NamedQuery(name = "Ficha.findByStart", query = "SELECT f FROM Ficha f WHERE f.startDate = :startDate")
//    ,@NamedQuery(name = "Ficha.findByEnd", query = "SELECT f FROM Ficha f WHERE f.endDate = :endDate")
//    ,@NamedQuery(name = "Ficha.findByRoute", query = "SELECT f FROM Ficha f WHERE f.route = :route")
//    ,@NamedQuery(name = "Ficha.findByProgramCode", query = "SELECT f FROM Ficha f WHERE f.program.programPK.programCode = :programCode")
//    ,@NamedQuery(name = "Ficha.findByProgramVersion", query = "SELECT f FROM Ficha f WHERE f.program.programPK.version = :version")
//    ,@NamedQuery(name = "Ficha.findByNameState", query = "SELECT f FROM Ficha f WHERE f.nameState = :nameState")
//    ,@NamedQuery(name = "Ficha.findByLikeNumberFicha", query = "SELECT f FROM Ficha f WHERE f.numberFicha LIKE :number ")
//    ,@NamedQuery(name = "Ficha.findByLikeStart", query = "SELECT f FROM Ficha f WHERE f.startDate LIKE :startDate")
//    ,@NamedQuery(name = "Ficha.findByLikeEnd", query = "SELECT f FROM Ficha f  WHERE f.endDate LIKE :endDate")
//    ,@NamedQuery(name = "Ficha.findByLikeRoute", query = "SELECT f FROM Ficha f WHERE f.route LIKE :route")
//    ,@NamedQuery(name = "Ficha.findByLikeProgramCode", query = "SELECT f FROM Ficha f WHERE f.program.programPK.programCode LIKE :programcode")
//    ,@NamedQuery(name = "Ficha.findByLikeProgramVersion", query = "SELECT f FROM Ficha f WHERE f.program.programPK.version LIKE")
//    ,@NamedQuery(name = "Ficha.findByLikeNameState", query = "SELECT f FROM Ficha f WHERE f.nameState =:nameState")
     ,@NamedQuery(name = "Ficha.updatePrimaryKey", query = "UPDATE Ficha f SET f.numberFicha =:nuevoNumberFicha  WHERE f.numberFicha = :viejonumberFicha" )    



})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "number_Ficha", nullable = false, length = 60)
    private String numberFicha;
    @Basic(optional = false)
    @Column(name = "start_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "Route", nullable = false, length = 50)
    private String route;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
    private Collection<FichaHasTrimester> fichaHasTrimesterCollection;
    @JoinColumns({
        @JoinColumn(name = "Program_Code", referencedColumnName = "Program_Code", nullable = false)
        , @JoinColumn(name = "Version", referencedColumnName = "Version", nullable = false)})
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "name_State", referencedColumnName = "name_State", nullable = false)
    @ManyToOne(optional = false)
    private StatusFicha nameState;

    public Ficha() {
    }

    public Ficha(String numberFicha) {
        this.numberFicha = numberFicha;
    }

    public Ficha(String numberFicha, Date startDate, Date endDate, String route) {
        this.numberFicha = numberFicha;
        this.startDate = startDate;
        this.endDate = endDate;
        this.route = route;
    }

    public String getNumberFicha() {
        return numberFicha;
    }

    public void setNumberFicha(String numberFicha) {
        this.numberFicha = numberFicha;
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

    public Collection<FichaHasTrimester> getFichaHasTrimesterCollection() {
        return fichaHasTrimesterCollection;
    }

    public void setFichaHasTrimesterCollection(Collection<FichaHasTrimester> fichaHasTrimesterCollection) {
        this.fichaHasTrimesterCollection = fichaHasTrimesterCollection;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public StatusFicha getNameState() {
        return nameState;
    }

    public void setNameState(StatusFicha nameState) {
        this.nameState = nameState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberFicha != null ? numberFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.numberFicha == null && other.numberFicha != null) || (this.numberFicha != null && !this.numberFicha.equals(other.numberFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.Ficha[ numberFicha=" + numberFicha + " ]";
    }

   
    
}
