/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

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
@Table(name = "ficha_has_trimester")
@NamedQueries({
    @NamedQuery(name = "FichaHasTrimester.findAll", query = "SELECT f FROM FichaHasTrimester f")})
public class FichaHasTrimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FichaHasTrimesterPK fichaHasTrimesterPK;
    @JoinTable(name = "viewed_results", joinColumns = {
        @JoinColumn(name = "number_Ficha", referencedColumnName = "number_Ficha", nullable = false)
        , @JoinColumn(name = "quarter_Name", referencedColumnName = "quarter_Name", nullable = false)
        , @JoinColumn(name = "acronyms_Working_Day", referencedColumnName = "acronyms_working_Day", nullable = false)
        , @JoinColumn(name = "speciality_Name", referencedColumnName = "speciality_Name", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "Learning_Result_Code", referencedColumnName = "Code", nullable = false)
        , @JoinColumn(name = "Program_Code", referencedColumnName = "Program_Code", nullable = false)
        , @JoinColumn(name = "Version", referencedColumnName = "Version", nullable = false)
        , @JoinColumn(name = "Competition_Code", referencedColumnName = "Competition_Code", nullable = false)})
    @ManyToMany
    private Collection<LearningResult> learningResultCollection;
    @JoinColumn(name = "number_Ficha", referencedColumnName = "number_Ficha", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficha ficha;
    @JoinColumns({
        @JoinColumn(name = "quarter_Name", referencedColumnName = "quarter_Name", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "acronyms_working_Day", referencedColumnName = "acronyms_Working_Day", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "speciality_Name", referencedColumnName = "speciality_Name", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Trimester trimester;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaHasTrimester")
    private Collection<Schedule> scheduleCollection;

    public FichaHasTrimester() {
    }

    public FichaHasTrimester(FichaHasTrimesterPK fichaHasTrimesterPK) {
        this.fichaHasTrimesterPK = fichaHasTrimesterPK;
    }

    public FichaHasTrimester(String numberFicha, String quarterName, String acronymsworkingDay, String specialityName) {
        this.fichaHasTrimesterPK = new FichaHasTrimesterPK(numberFicha, quarterName, acronymsworkingDay, specialityName);
    }

    public FichaHasTrimesterPK getFichaHasTrimesterPK() {
        return fichaHasTrimesterPK;
    }

    public void setFichaHasTrimesterPK(FichaHasTrimesterPK fichaHasTrimesterPK) {
        this.fichaHasTrimesterPK = fichaHasTrimesterPK;
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
        hash += (fichaHasTrimesterPK != null ? fichaHasTrimesterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaHasTrimester)) {
            return false;
        }
        FichaHasTrimester other = (FichaHasTrimester) object;
        if ((this.fichaHasTrimesterPK == null && other.fichaHasTrimesterPK != null) || (this.fichaHasTrimesterPK != null && !this.fichaHasTrimesterPK.equals(other.fichaHasTrimesterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimester[ fichaHasTrimesterPK=" + fichaHasTrimesterPK + " ]";
    }
    
}
