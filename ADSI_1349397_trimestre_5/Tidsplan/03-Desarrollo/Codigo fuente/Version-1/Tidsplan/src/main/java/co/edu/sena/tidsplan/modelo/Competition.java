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
public class Competition {
    private int code;
    private String description;
    private List<TrainingProgramHasCompetition> programHasCompetition;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TrainingProgramHasCompetition> getProgramHasCompetition() {
        return programHasCompetition;
    }

    public void setProgramHasCompetition(List<TrainingProgramHasCompetition> programHasCompetition) {
        this.programHasCompetition = programHasCompetition;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.code;
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
        final Competition other = (Competition) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }
    
    

}
