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
public class TrainingProgramHasCompetition {
    private Competition competition;
    private TrainingProgram program;
    private List<LearningResult>  learningResults;

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public TrainingProgram getProgram() {
        return program;
    }

    public void setProgram(TrainingProgram program) {
        this.program = program;
    }

    public List<LearningResult> getLearningResults() {
        return learningResults;
    }

    public void setLearningResults(List<LearningResult> learningResults) {
        this.learningResults = learningResults;
    }
    
}
