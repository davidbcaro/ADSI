/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorge
 */
@Embeddable
public class ProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "code_program", nullable = false)
    private int codeProgram;
    @Basic(optional = false)
    @Column(name = "edition", nullable = false, length = 10)
    private String edition;

    public ProgramPK() {
    }

    public ProgramPK(int codeProgram, String edition) {
        this.codeProgram = codeProgram;
        this.edition = edition;
    }

    public int getCodeProgram() {
        return codeProgram;
    }

    public void setCodeProgram(int codeProgram) {
        this.codeProgram = codeProgram;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeProgram;
        hash += (edition != null ? edition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramPK)) {
            return false;
        }
        ProgramPK other = (ProgramPK) object;
        if (this.codeProgram != other.codeProgram) {
            return false;
        }
        if ((this.edition == null && other.edition != null) || (this.edition != null && !this.edition.equals(other.edition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.ProgramPK[ codeProgram=" + codeProgram + ", edition=" + edition + " ]";
    }
    
}
