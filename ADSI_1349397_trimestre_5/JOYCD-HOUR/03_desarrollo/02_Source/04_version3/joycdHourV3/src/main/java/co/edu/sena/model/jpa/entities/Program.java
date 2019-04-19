/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

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
    , @NamedQuery(name = "Program.findByProgramCode", query = "SELECT p FROM Program p WHERE p.programPK.programCode = :programCode")
    , @NamedQuery(name = "Program.findByLikeProgramCode", query = "SELECT p FROM Program p WHERE p.programPK.programCode LIKE :programCode")
    , @NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :name")
    , @NamedQuery(name = "Program.findByLikeName", query = "SELECT p FROM Program p WHERE p.name LIKE :name")
    , @NamedQuery(name = "Program.findByVersion", query = "SELECT p FROM Program p WHERE p.programPK.version = :version")
    , @NamedQuery(name = "Program.findByLikeVersion", query = "SELECT p FROM Program p WHERE p.programPK.version LIKE :version")
    , @NamedQuery(name = "Program.findByInitials", query = "SELECT p FROM Program p WHERE p.initials = :initials")
    , @NamedQuery(name = "Program.findByLikeInitials", query = "SELECT p FROM Program p WHERE p.initials LIKE :initials")
    , @NamedQuery(name = "Program.findByStatus", query = "SELECT p FROM Program p WHERE p.status = :status")
    , @NamedQuery(name = "Program.findByLevelFormation", query = "SELECT p FROM Program p WHERE p.levelFormation = :levelFormation")
    , @NamedQuery(name = "Program.findByLikeLevelFormation", query = "SELECT p FROM Program p WHERE p.levelFormation LIKE :levelFormation")
    , @NamedQuery(name = "Program.updatePrimaryKey", query = "UPDATE Program p SET p.programPK.programCode = :programCodeNew, p.programPK.version = :versionNew WHERE p.programPK.programCode = :programCodeOld and p.programPK.version = :versionOld")
        
})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 45)
    private String initials;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;
    @JoinColumn(name = "level_formation", referencedColumnName = "level_formation", nullable = false)
    @ManyToOne(optional = false)
    private LevelFormation levelFormation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<Competence> competenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<GroupNumber> groupNumberCollection;

    public Program() {
    }

    public Program(ProgramPK programPK) {
        this.programPK = programPK;
    }

    public Program(ProgramPK programPK, String name, String initials, boolean status) {
        this.programPK = programPK;
        this.name = name;
        this.initials = initials;
        this.status = status;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LevelFormation getLevelFormation() {
        return levelFormation;
    }

    public void setLevelFormation(LevelFormation levelFormation) {
        this.levelFormation = levelFormation;
    }

    public Collection<Competence> getCompetenceCollection() {
        return competenceCollection;
    }

    public void setCompetenceCollection(Collection<Competence> competenceCollection) {
        this.competenceCollection = competenceCollection;
    }

    public Collection<GroupNumber> getGroupNumberCollection() {
        return groupNumberCollection;
    }

    public void setGroupNumberCollection(Collection<GroupNumber> groupNumberCollection) {
        this.groupNumberCollection = groupNumberCollection;
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
        return "co.edu.sena.model.jpa.entities.Program[ programPK=" + programPK + " ]";
    }
    
}
