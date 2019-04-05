/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "trimester_has_learning_result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrimesterHasLearningResult.findAll", query = "SELECT t FROM TrimesterHasLearningResult t")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByTrimesterNumber", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.trimesterNumber = :trimesterNumber")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByTriWorkInitials", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.triWorkInitials = :triWorkInitials")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLearningrCode", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.learningrCode = :learningrCode")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLikeLearningrCode", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.learningrCode LIKE :learningrCode")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLeveltCode", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.leveltCode = :leveltCode")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLikeLeveltCode", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.leveltCode LIKE :leveltCode")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLearningEdition", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.learningEdition = :learningEdition")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLikeLearningEdition", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.learningEdition LIKE :learningEdition")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByProgramCode", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.programCode = :programCode")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByCompetenceCode", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.competenceCode = :competenceCode")
    , @NamedQuery(name = "TrimesterHasLearningResult.findByLikeTriWorkInitials", query = "SELECT t FROM TrimesterHasLearningResult t WHERE t.trimesterHasLearningResultPK.triWorkInitials LIKE :triWorkInitials")
    , @NamedQuery(name = "TrimesterHasLearningResult.updatePK", query ="UPDATE TrimesterHasLearningResult t SET t.trimesterHasLearningResultPK.trimesterNumber = :TrimesterNumberNew, t.trimesterHasLearningResultPK.triWorkInitials = :TriWorkInitialsNew, t.trimesterHasLearningResultPK.leveltCode = :LeveltCodeNew, t.trimesterHasLearningResultPK.learningrCode = :LearningrCodeNew, t.trimesterHasLearningResultPK.competenceCode = :CompetenceCodeNew, t.trimesterHasLearningResultPK.programCode = :ProgramCodeNew, t.trimesterHasLearningResultPK.learningEdition = :LearningEditionNew WHERE t.trimesterHasLearningResultPK.trimesterNumber = :TrimesterNumberOld and t.trimesterHasLearningResultPK.triWorkInitials = :TriWorkInitialsOld and t.trimesterHasLearningResultPK.leveltCode = :LeveltCodeNewOld and t.trimesterHasLearningResultPK.learningrCode = :LearningrCodeNewOld and t.trimesterHasLearningResultPK.competenceCode = :CompetenceCodeNewOld and t.trimesterHasLearningResultPK.programCode = :ProgramCodeNewOld and t.trimesterHasLearningResultPK.learningEdition = :LearningEditionNewOld")})
public class TrimesterHasLearningResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimesterHasLearningResultPK trimesterHasLearningResultPK;
    @ManyToMany(mappedBy = "trimesterHasLearningResultCollection")
    private Collection<NumberGroup> numberGroupCollection;
    @JoinColumns({
        @JoinColumn(name = "learningr_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "competence_code", referencedColumnName = "code_competence", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "program_code", referencedColumnName = "code_program", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "learning_edition", referencedColumnName = "edition", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private LearningResult learningResult;
    @JoinColumns({
        @JoinColumn(name = "tri_work_initials", referencedColumnName = "initials", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "trimester_number", referencedColumnName = "number", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "levelt_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Trimester trimester;

    public TrimesterHasLearningResult() {
    }

    public TrimesterHasLearningResult(TrimesterHasLearningResultPK trimesterHasLearningResultPK) {
        this.trimesterHasLearningResultPK = trimesterHasLearningResultPK;
    }

    public TrimesterHasLearningResult(int trimesterNumber, String triWorkInitials, String learningrCode, String leveltCode, String learningEdition, int programCode, int competenceCode) {
        this.trimesterHasLearningResultPK = new TrimesterHasLearningResultPK(trimesterNumber, triWorkInitials, learningrCode, leveltCode, learningEdition, programCode, competenceCode);
    }

    public TrimesterHasLearningResultPK getTrimesterHasLearningResultPK() {
        return trimesterHasLearningResultPK;
    }

    public void setTrimesterHasLearningResultPK(TrimesterHasLearningResultPK trimesterHasLearningResultPK) {
        this.trimesterHasLearningResultPK = trimesterHasLearningResultPK;
    }

    @XmlTransient
    public Collection<NumberGroup> getNumberGroupCollection() {
        return numberGroupCollection;
    }

    public void setNumberGroupCollection(Collection<NumberGroup> numberGroupCollection) {
        this.numberGroupCollection = numberGroupCollection;
    }

    public LearningResult getLearningResult() {
        return learningResult;
    }

    public void setLearningResult(LearningResult learningResult) {
        this.learningResult = learningResult;
    }

    public Trimester getTrimester() {
        return trimester;
    }

    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trimesterHasLearningResultPK != null ? trimesterHasLearningResultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimesterHasLearningResult)) {
            return false;
        }
        TrimesterHasLearningResult other = (TrimesterHasLearningResult) object;
        if ((this.trimesterHasLearningResultPK == null && other.trimesterHasLearningResultPK != null) || (this.trimesterHasLearningResultPK != null && !this.trimesterHasLearningResultPK.equals(other.trimesterHasLearningResultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.TrimesterHasLearningResult[ trimesterHasLearningResultPK=" + trimesterHasLearningResultPK + " ]";
    }
    
}
