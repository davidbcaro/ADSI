/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;


import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class ProgrmHasCompetition {
    private Program program;
    private Competition competition;
    private List<LearningResult>learningresult;

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<LearningResult> getLearningresult() {
        return learningresult;
    }

    public void setLearningresult(List<LearningResult> learningresult) {
        this.learningresult = learningresult;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.program);
        hash = 41 * hash + Objects.hashCode(this.competition);
        hash = 41 * hash + Objects.hashCode(this.learningresult);
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
        final ProgrmHasCompetition other = (ProgrmHasCompetition) obj;
        if (!Objects.equals(this.program, other.program)) {
            return false;
        }
        if (!Objects.equals(this.competition, other.competition)) {
            return false;
        }
        if (!Objects.equals(this.learningresult, other.learningresult)) {
            return false;
        }
        return true;
    }
    
    
}
