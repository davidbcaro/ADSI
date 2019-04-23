/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
@Table(name = "program")
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p")
    ,@NamedQuery(name = "Program.findByCode", query = "SELECT p FROM Program p WHERE p.programPK.programCode = :Code")
    ,@NamedQuery(name = "Program.findByVersion", query = "SELECT p FROM Program p WHERE p.programPK.version = :Version")
    ,@NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :Name")
    ,@NamedQuery(name = "Program.findByInitials", query = "SELECT p FROM Program p WHERE p.initials = :Initials")
    ,@NamedQuery(name = "Program.findByState", query = "SELECT p FROM Program p WHERE p.state = :State")
    ,@NamedQuery(name = "Program.findByTrainingLevel", query = "SELECT p FROM Program p WHERE p.trainingLevel.trainingLevel = :TrainingLevel")
    ,@NamedQuery(name = "Program.findByLikeCode", query = "SELECT p FROM Program p WHERE p.programPK.programCode LIKE :Code")
    ,@NamedQuery(name = "Program.findByLikeVersion", query = "SELECT p FROM Program p WHERE p.programPK.version LIKE :Version")
    ,@NamedQuery(name = "Program.findByLikeTrainingLevel", query = "SELECT p FROM Program p WHERE p.trainingLevel LIKE :trainingLevel") 
    ,@NamedQuery(name = "Program.updatePk", query = "UPDATE Program p SET p.programPK.programCode = :codeNuevo, p.programPK.version = :versionNueva WHERE p.programPK.programCode = :codeViejo AND p.programPK.version = :versionVieja")    
})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 20)
    private String initials;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<Competition> competitionCollection;
    @JoinColumn(name = "training_Level", referencedColumnName = "training_Level")
    @ManyToOne
    private TrainingLevel trainingLevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<NumberGroup> numberGroupCollection;

    public Program() {
    }

    public Program(ProgramPK programPK) {
        this.programPK = programPK;
    }

    public Program(ProgramPK programPK, String name, String initials) {
        this.programPK = programPK;
        this.name = name;
        this.initials = initials;
    }

    public Program(String programCode, String version) {
        this.programPK = new ProgramPK(programCode, version);
    }

    public ProgramPK getProgramPK() {
        return programPK;
    }

    public void setProgramPK(ProgramPK programPK) {
        this.programPK = programPK;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Collection<Competition> getCompetitionCollection() {
        return competitionCollection;
    }

    public void setCompetitionCollection(Collection<Competition> competitionCollection) {
        this.competitionCollection = competitionCollection;
    }

    public TrainingLevel getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(TrainingLevel trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public Collection<NumberGroup> getNumberGroupCollection() {
        return numberGroupCollection;
    }

    public void setNumberGroupCollection(Collection<NumberGroup> numberGroupCollection) {
        this.numberGroupCollection = numberGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programPK != null ? programPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.programPK == null && other.programPK != null) || (this.programPK != null && !this.programPK.equals(other.programPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.Program[ programPK=" + programPK + " ]";
    }
    
}