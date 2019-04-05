/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "trimester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimester.findAll", query = "SELECT t FROM Trimester t")
    , @NamedQuery(name = "Trimester.findByNumber", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.number = :number")
    , @NamedQuery(name = "Trimester.findByInitials", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.initials = :initials")
    , @NamedQuery(name = "Trimester.findByCode", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.code = :code")
    , @NamedQuery(name = "Trimester.updatePK", query = "UPDATE Trimester t SET t.trimesterPK.number = :NumberNew,  t.trimesterPK.initials = :InitialsNew,  t.trimesterPK.code = :CodeNew WHERE t.trimesterPK.number = :NumberOld and t.trimesterPK.initials = :InitialsOld and t.trimesterPK.code = :CodeOld")
    , @NamedQuery(name = "Trimester.findByLikeNumber", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.number LIKE :number")
    , @NamedQuery(name = "Trimester.findByLikeInitials", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.initials LIKE :initials")
    , @NamedQuery(name = "Trimester.findByLikeCode", query = "SELECT t FROM Trimester t WHERE t.trimesterPK.code LIKE :code")})
public class Trimester implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimesterPK trimesterPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimester")
    private Collection<TrimesterHasLearningResult> trimesterHasLearningResultCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimester")
    private Collection<NumberGroupHasTrimester> numberGroupHasTrimesterCollection;
    @JoinColumn(name = "code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LevelTrainig levelTrainig;
    @JoinColumn(name = "initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkingDay workingDay;

    public Trimester() {
    }

    public Trimester(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
    }

    public Trimester(int number, String initials, String code) {
        this.trimesterPK = new TrimesterPK(number, initials, code);
    }

    public TrimesterPK getTrimesterPK() {
        return trimesterPK;
    }

    public void setTrimesterPK(TrimesterPK trimesterPK) {
        this.trimesterPK = trimesterPK;
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

    public LevelTrainig getLevelTrainig() {
        return levelTrainig;
    }

    public void setLevelTrainig(LevelTrainig levelTrainig) {
        this.levelTrainig = levelTrainig;
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
        return "co.edu.sena.cot.modelo.dto.Trimester[ trimesterPK=" + trimesterPK + " ]";
    }
    
}
