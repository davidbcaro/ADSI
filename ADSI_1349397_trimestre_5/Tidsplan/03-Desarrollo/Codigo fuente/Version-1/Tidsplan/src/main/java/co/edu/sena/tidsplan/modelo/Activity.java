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
public class Activity {

    private int idActivity;
    private String name;
    private List<LearningResultHasActivity> learningResultHasActivitys;
    private ProjectPhase projectPhase;

    public List<LearningResultHasActivity> getLearningResultHasActivitys() {
        return learningResultHasActivitys;
    }

    public void setLearningResultHasActivitys(List<LearningResultHasActivity> learningResultHasActivitys) {
        this.learningResultHasActivitys = learningResultHasActivitys;
    }
    

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectPhase getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        this.projectPhase = projectPhase;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idActivity;
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
        final Activity other = (Activity) obj;
        if (this.idActivity != other.idActivity) {
            return false;
        }
        return true;
    }
    
    
    
}