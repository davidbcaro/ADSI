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
public class ProjectPhase {
    private String namePhase;
    private boolean Status;
    private List<Activity> activitys;
    private Project project;

    public String getNameProject() {
        return namePhase;
    }

    public void setNameProject(String nameProject) {
        this.namePhase = namePhase;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public List<Activity> getActivitys() {
        return activitys;
    }

    public void setActivitys(List<Activity> activitys) {
        this.activitys = activitys;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.namePhase);
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
        final ProjectPhase other = (ProjectPhase) obj;
        if (!Objects.equals(this.namePhase, other.namePhase)) {
            return false;
        }
        return true;
    }
    
    
}
