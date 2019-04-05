/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p")
    , @NamedQuery(name = "Program.findByCodeProgram", query = "SELECT p FROM Program p WHERE p.programPK.codeProgram = :codeProgram")
    , @NamedQuery(name = "Program.findByNameProgram", query = "SELECT p FROM Program p WHERE p.nameProgram = :nameProgram")
    , @NamedQuery(name = "Program.findByEdition", query = "SELECT p FROM Program p WHERE p.programPK.edition = :edition")
    , @NamedQuery(name = "Program.findByInitials", query = "SELECT p FROM Program p WHERE p.initials = :initials")
    , @NamedQuery(name = "Program.findByState", query = "SELECT p FROM Program p WHERE p.state = :state")
    , @NamedQuery(name = "Program.findByLevelTraCode", query = "SELECT p FROM Program p WHERE p.levelTraCode.code = :levelTraCode")
    , @NamedQuery(name = "Program.findByLikeNameProgram", query = "SELECT p FROM Program p WHERE p.nameProgram LIKE :nameProgram")
    , @NamedQuery(name = "Program.finfByLikeEdition", query = "SELECT p FROM Program p WHERE p.programPK.edition LIKE :edition")
    , @NamedQuery(name = "Program.findByLikeInitials", query = "SELECT p FROM Program p WHERE p.initials LIKE :initials")
    , @NamedQuery(name = "Program.updatePK", query = "UPDATE Program p set p.programPK.codeProgram = :ProgramNew,  p.programPK.edition = :ProgramNew2 WHERE p.programPK.codeProgram = :ProgramOld and  p.programPK.edition = :ProgramOld2")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Basic(optional = false)
    @Column(name = "name_program", nullable = false, length = 150)
    private String nameProgram;
    @Basic(optional = false)
    @Column(name = "initials", nullable = false, length = 10)
    private String initials;
    @Basic(optional = false)
    @Column(name = "state", nullable = false, length = 100)
    private String state;
    @JoinColumn(name = "level_tra_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private LevelTrainig levelTraCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<Competence> competenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<NumberGroup> numberGroupCollection;

    public Program() {
    }

    public Program(ProgramPK programPK) {
        this.programPK = programPK;
    }

    public Program(ProgramPK programPK, String nameProgram, String initials, String state) {
        this.programPK = programPK;
        this.nameProgram = nameProgram;
        this.initials = initials;
        this.state = state;
    }

    public Program(int codeProgram, String edition) {
        this.programPK = new ProgramPK(codeProgram, edition);
    }

    public ProgramPK getProgramPK() {
        return programPK;
    }

    public void setProgramPK(ProgramPK programPK) {
        this.programPK = programPK;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LevelTrainig getLevelTraCode() {
        return levelTraCode;
    }

    public void setLevelTraCode(LevelTrainig levelTraCode) {
        this.levelTraCode = levelTraCode;
    }

    @XmlTransient
    public Collection<Competence> getCompetenceCollection() {
        return competenceCollection;
    }

    public void setCompetenceCollection(Collection<Competence> competenceCollection) {
        this.competenceCollection = competenceCollection;
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
        return "co.edu.sena.cot.modelo.dto.Program[ programPK=" + programPK + " ]";
    }
    
}
