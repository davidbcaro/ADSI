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
public class LearningResult {
    private int code;
    private String description;
    private TrainingProgramHasCompetition programHasCompetition;
    private List<TrimesterHasLearningResult> learningResults;
    private List<LearningResultHasActivity> learningResultHasActivitys;
    private List<GroupHasTrimesterHasLearningResult> groupHasTrimesterHasLearningResults;

    public int getCodigo() {
        return code;
    }

    public void setCodigo(int codigo) {
        this.code = codigo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainingProgramHasCompetition getProgramHasCompetition() {
        return programHasCompetition;
    }

    public void setProgramHasCompetition(TrainingProgramHasCompetition programHasCompetition) {
        this.programHasCompetition = programHasCompetition;
    }

    public List<TrimesterHasLearningResult> getLearningResults() {
        return learningResults;
    }

    public void setLearningResults(List<TrimesterHasLearningResult> learningResults) {
        this.learningResults = learningResults;
    }

    public List<LearningResultHasActivity> getLearningResultHasActivitys() {
        return learningResultHasActivitys;
    }

    public void setLearningResultHasActivitys(List<LearningResultHasActivity> learningResultHasActivitys) {
        this.learningResultHasActivitys = learningResultHasActivitys;
    }

    public List<GroupHasTrimesterHasLearningResult> getGroupHasTrimesterHasLearningResults() {
        return groupHasTrimesterHasLearningResults;
    }

    public void setGroupHasTrimesterHasLearningResults(List<GroupHasTrimesterHasLearningResult> groupHasTrimesterHasLearningResults) {
        this.groupHasTrimesterHasLearningResults = groupHasTrimesterHasLearningResults;
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
        final LearningResult other = (LearningResult) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }
    
    
    
    
}
