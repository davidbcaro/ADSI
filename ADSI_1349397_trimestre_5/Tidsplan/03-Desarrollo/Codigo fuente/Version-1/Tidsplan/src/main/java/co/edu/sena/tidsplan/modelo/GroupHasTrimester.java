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
public class GroupHasTrimester {
    private Group group;
    private List<GroupHasTrimesterHasLearningResult> groupHasTrimesterHasLearningResults;
    private Trimester trimester;
    private List<Schedule> schedules;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<GroupHasTrimesterHasLearningResult> getGroupHasTrimesterHasLearningResults() {
        return groupHasTrimesterHasLearningResults;
    }

    public void setGroupHasTrimesterHasLearningResults(List<GroupHasTrimesterHasLearningResult> groupHasTrimesterHasLearningResults) {
        this.groupHasTrimesterHasLearningResults = groupHasTrimesterHasLearningResults;
    }

    public Trimester getTrimester() {
        return trimester;
    }

    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    
    
}
