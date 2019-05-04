/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Trimester {
    private String nameTrimester;
    private List<GroupHasTrimester> groupHasTrimesters;
    private WorkingDay workingDay;
    private List<TrimesterHasLearningResult> learningResults;

    public List<GroupHasTrimester> getGroupHasTrimesters() {
        return groupHasTrimesters;
    }

    public void setGroupHasTrimesters(List<GroupHasTrimester> groupHasTrimesters) {
        this.groupHasTrimesters = groupHasTrimesters;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    public List<TrimesterHasLearningResult> getLearningResults() {
        return learningResults;
    }

    public void setLearningResults(List<TrimesterHasLearningResult> learningResults) {
        this.learningResults = learningResults;
    }

    public String getNameTrimester() {
        return nameTrimester;
    }

    public void setNameTrimester(String nameTrimester) {
        this.nameTrimester = nameTrimester;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nameTrimester);
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
        final Trimester other = (Trimester) obj;
        if (!Objects.equals(this.nameTrimester, other.nameTrimester)) {
            return false;
        }
        return true;
    }
    
}
