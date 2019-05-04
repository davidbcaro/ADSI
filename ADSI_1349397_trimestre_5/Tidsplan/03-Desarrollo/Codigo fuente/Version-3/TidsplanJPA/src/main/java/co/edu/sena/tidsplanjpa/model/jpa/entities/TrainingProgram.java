/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "training_program")
@NamedQueries({
    @NamedQuery(name = "TrainingProgram.findAll", query = "SELECT t FROM TrainingProgram t")
    , @NamedQuery(name = "TrainingProgram.findByIdCode", query = "SELECT t FROM TrainingProgram t WHERE t.trainingProgramPK.idCode = :idCode")
    , @NamedQuery(name = "TrainingProgram.findByLikeIdCode", query = "SELECT t FROM TrainingProgram t WHERE t.trainingProgramPK.idCode like :idCode")
    , @NamedQuery(name = "TrainingProgram.findByName", query = "SELECT t FROM TrainingProgram t WHERE t.name = :name")
    , @NamedQuery(name = "TrainingProgram.findByLikeName", query = "SELECT t FROM TrainingProgram t WHERE t.name like :name")
    , @NamedQuery(name = "TrainingProgram.findByVersion", query = "SELECT t FROM TrainingProgram t WHERE t.trainingProgramPK.version = :version")
    , @NamedQuery(name = "TrainingProgram.findByLikeVersion", query = "SELECT t FROM TrainingProgram t WHERE t.trainingProgramPK.version like :version")
    , @NamedQuery(name = "TrainingProgram.findByInitials", query = "SELECT t FROM TrainingProgram t WHERE t.initials = :initials")
    , @NamedQuery(name = "TrainingProgram.findByLikeInitials", query = "SELECT t FROM TrainingProgram t WHERE t.initials like :initials")
    , @NamedQuery(name = "TrainingProgram.findByLevelFormation", query = "SELECT t FROM TrainingProgram t WHERE t.levelFormation.levelFormation = :levelFormation")
    , @NamedQuery(name = "TrainingProgram.findByLikeLevelFormation", query = "SELECT t FROM TrainingProgram t WHERE t.levelFormation.levelFormation like :levelFormation")
    , @NamedQuery(name = "TrainingProgram.findByStatus", query = "SELECT t FROM TrainingProgram t WHERE t.status = :status")
    , @NamedQuery(name = "TrainingProgram.updatePrimaryKey", query = "UPDATE TrainingProgram t set t.trainingProgramPK.idCode= :newIdCode, t.trainingProgramPK.version =  :newVersion WHERE t.trainingProgramPK.idCode = :oldIdCode and t.trainingProgramPK.version = :oldVersion")})
public class TrainingProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrainingProgramPK trainingProgramPK;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 70)
    private String name;
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 20)
    private String initials;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
    private Collection<Competition> competitionCollection;
    @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false)
    @ManyToOne(optional = false)
    private FormationLevel levelFormation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingProgram")
    private Collection<Ficha> fichaCollection;

    public TrainingProgram() {
    }

    public TrainingProgram(TrainingProgramPK trainingProgramPK) {
        this.trainingProgramPK = trainingProgramPK;
    }

    public TrainingProgram(TrainingProgramPK trainingProgramPK, String name, String initials, boolean status) {
        this.trainingProgramPK = trainingProgramPK;
        this.name = name;
        this.initials = initials;
        this.status = status;
    }

    public TrainingProgram(String idCode, String version) {
        this.trainingProgramPK = new TrainingProgramPK(idCode, version);
    }

    public TrainingProgramPK getTrainingProgramPK() {
        return trainingProgramPK;
    }

    public void setTrainingProgramPK(TrainingProgramPK trainingProgramPK) {
        this.trainingProgramPK = trainingProgramPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Competition> getCompetitionCollection() {
        return competitionCollection;
    }

    public void setCompetitionCollection(Collection<Competition> competitionCollection) {
        this.competitionCollection = competitionCollection;
    }

    public FormationLevel getLevelFormation() {
        return levelFormation;
    }

    public void setLevelFormation(FormationLevel levelFormation) {
        this.levelFormation = levelFormation;
    }

    public Collection<Ficha> getFichaCollection() {
        return fichaCollection;
    }

    public void setFichaCollection(Collection<Ficha> fichaCollection) {
        this.fichaCollection = fichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingProgramPK != null ? trainingProgramPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingProgram)) {
            return false;
        }
        TrainingProgram other = (TrainingProgram) object;
        if ((this.trainingProgramPK == null && other.trainingProgramPK != null) || (this.trainingProgramPK != null && !this.trainingProgramPK.equals(other.trainingProgramPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.TrainingProgram[ trainingProgramPK=" + trainingProgramPK + " ]";
    }
    
}
