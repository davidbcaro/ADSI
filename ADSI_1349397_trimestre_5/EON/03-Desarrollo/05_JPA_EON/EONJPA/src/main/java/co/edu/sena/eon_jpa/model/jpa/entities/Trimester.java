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
 @NamedQuery(name= "Trimester.findAll", query = "SELECT t FROM Trimester t")
//,@NamedQuery(name= "Trimester.findByQuarterName" , query = "SELECT t FROM Trimester t WHERE t.trimesterPK.quarterName =:quarterName")
//,@NamedQuery(name= "Trimester.findByAcronymsWorkingDay" , query = "SELECT t FROM Trimester t WHERE t.trimesterPK.acronymsWorkingDay =:acronymsWorkingDay")
//,@NamedQuery(name= "Trimester.findBySpecialityName" , query = "SELECT t FROM Trimester t WHERE t.trimesterPK.specialityName =:specialityName")
//,@NamedQuery(name= "Trimester.findByLikeQuarterName" , query = "SELECT t FROM Trimester t WHERE t.trimesterPK.quarterName LIKE :quarterName")
//,@NamedQuery(name= "Trimester.findByLikeAcronymsWorkingDay" , query = "SELECT t FROM Trimester t WHERE t.trimesterPK.acronymsWorkingDay =:acronymsWorkingDay")
//,@NamedQuery(name= "Trimester.findByLikeSpecialityName" , query = "SELECT t FROM Trimester t WHERE t.trimesterPK.specialityName LIKE :specialityName")
,@NamedQuery(name= "Trimester.updatePrimaryKey" , query = "UPDATE Trimester t SET t.trimesterPK.acronymsWorkingDay = :nuevoAcronymsWorkingDay,t.trimesterPK.quarterName =:nuevoQuarterName, t.trimesterPK.specialityName=:nuevoSpecialityName  WHERE t.trimesterPK.acronymsWorkingDay =:viejoAcronymsWorkingDay AND t.trimesterPK.quarterName =:viejoQuarterName AND t.trimesterPK.specialityName =:viejoSpecialityName")
})
public class Trimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimesterPK trimesterPK;
    @ManyToMany(mappedBy = "trimesterCollection")
    private Collection<LearningResult> learningResultCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimester")
    private Collection<FichaHasTrimester> fichaHasTrimesterCollection;
    @JoinColumn(name = "speciality_Name", referencedColumnName = "speciality_Name", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Speciality speciality;
    @JoinColumn(name = "acronyms_Working_Day", referencedColumnName = "acronyms_Working_Day", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Trimester() {
    }

    public Trimester(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
    }

    public Trimester(String quarterName, String acronymsWorkingDay, String specialityName) {
        this.trimesterPK = new TrimesterPK(quarterName, acronymsWorkingDay, specialityName);
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

    public Collection<FichaHasTrimester> getFichaHasTrimesterCollection() {
        return fichaHasTrimesterCollection;
    }

    public void setFichaHasTrimesterCollection(Collection<FichaHasTrimester> fichaHasTrimesterCollection) {
        this.fichaHasTrimesterCollection = fichaHasTrimesterCollection;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
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
        return "co.edu.sena.eon_jpa.model.jpa.entities.Trimester[ trimesterPK=" + trimesterPK + " ]";
    }
    
}
