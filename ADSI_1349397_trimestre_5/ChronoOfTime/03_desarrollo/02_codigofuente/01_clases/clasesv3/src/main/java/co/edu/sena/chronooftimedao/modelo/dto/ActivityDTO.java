/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author Jorge
 */
public class ActivityDTO {
    private int id_activity;
    private String phase_name_phase;
    private int phase_project_code;
    private String name;
    
    public void ActivityDTO(){
    
}

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    public String getPhase_name_phase() {
        return phase_name_phase;
    }

    public void setPhase_name_phase(String phase_name_phase) {
        this.phase_name_phase = phase_name_phase;
    }

    public int getPhase_project_code() {
        return phase_project_code;
    }

    public void setPhase_project_code(int phase_project_code) {
        this.phase_project_code = phase_project_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id_activity;
        hash = 17 * hash + Objects.hashCode(this.phase_name_phase);
        hash = 17 * hash + this.phase_project_code;
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
        final ActivityDTO other = (ActivityDTO) obj;
        if (this.id_activity != other.id_activity) {
            return false;
        }
        if (this.phase_project_code != other.phase_project_code) {
            return false;
        }
        if (!Objects.equals(this.phase_name_phase, other.phase_name_phase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" + "id_activity=" + id_activity + ", phase_name_phase=" + phase_name_phase + ", phase_project_code=" + phase_project_code + ", name=" + name + '}';
    }
    
    
}
