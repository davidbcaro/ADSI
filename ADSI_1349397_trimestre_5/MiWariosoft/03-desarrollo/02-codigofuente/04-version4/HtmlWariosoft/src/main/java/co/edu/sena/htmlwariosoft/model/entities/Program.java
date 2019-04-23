/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.htmlwariosoft.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1349397
 */
@Entity
@Table(name = "program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p")
    , @NamedQuery(name = "Program.findByProgramCode", query = "SELECT p FROM Program p WHERE p.programPK.programCode = :programCode")
    , @NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :name")
    , @NamedQuery(name = "Program.findByVersion", query = "SELECT p FROM Program p WHERE p.programPK.version = :version")
    , @NamedQuery(name = "Program.findByInitials", query = "SELECT p FROM Program p WHERE p.initials = :initials")
    , @NamedQuery(name = "Program.findByState", query = "SELECT p FROM Program p WHERE p.state = :state")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "initials", nullable = false, length = 20)
    private String initials;
    @Column(name = "state")
    private Boolean state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program", fetch = FetchType.LAZY)
    private Collection<Competition> competitionCollection;
    @JoinColumn(name = "training_Level", referencedColumnName = "training_Level", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TrainingLevel trainingLevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program", fetch = FetchType.LAZY)
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

    @XmlTransient
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

    @XmlTransient
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
        return "co.edu.sena.htmlwariosoft.model.entities.Program[ programPK=" + programPK + " ]";
    }
    
}
