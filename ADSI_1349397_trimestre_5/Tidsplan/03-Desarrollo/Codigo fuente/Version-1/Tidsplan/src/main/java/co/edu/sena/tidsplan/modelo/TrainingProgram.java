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
public class TrainingProgram {
    private int code;
    private String name;
    private String version;
    private String initials;
    private boolean status;
    private FormationLevel formationlevel;
    private List<TrainingProgramHasCompetition> programHasCompetition;

    public List<TrainingProgramHasCompetition> getProgramHasCompetition() {
        return programHasCompetition;
    }

    public void setProgramHasCompetition(List<TrainingProgramHasCompetition> programHasCompetition) {
        this.programHasCompetition = programHasCompetition;
    }
        
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public FormationLevel getFormationlevel() {
        return formationlevel;
    }

    public void setFormationlevel(FormationLevel formationlevel) {
        this.formationlevel = formationlevel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.code;
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
        final TrainingProgram other = (TrainingProgram) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }
    
    
}
