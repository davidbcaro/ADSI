/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

/**
 *
 * @author 1349397
 */
public class GroupHasTrimesterHasLearningResult {
    private LearningResult learningResult;
    private GroupHasTrimester groupHasTrimester;

    public LearningResult getLearningResult() {
        return learningResult;
    }

    public void setLearningResult(LearningResult learningResult) {
        this.learningResult = learningResult;
    }

    public GroupHasTrimester getGroupHasTrimester() {
        return groupHasTrimester;
    }

    public void setGroupHasTrimester(GroupHasTrimester groupHasTrimester) {
        this.groupHasTrimester = groupHasTrimester;
    }    
}
