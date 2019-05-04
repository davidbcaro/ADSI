/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;

/**
 *
 * @author 1349397
 */
public class FormationLevel {
    private int formationlevel;
    private boolean status;
    private List<TrainingProgram> program;

    public List<TrainingProgram> getProgram() {
        return program;
    }

    public void setProgram(List<TrainingProgram> program) {
        this.program = program;
    }
    
    public int getFormationlevel() {
        return formationlevel;
    }

    public void setFormationlevel(int formationlevel) {
        this.formationlevel = formationlevel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormationLevel other = (FormationLevel) obj;
        if (this.formationlevel != other.formationlevel) {
            return false;
        }
        return true;
    }
   
}
