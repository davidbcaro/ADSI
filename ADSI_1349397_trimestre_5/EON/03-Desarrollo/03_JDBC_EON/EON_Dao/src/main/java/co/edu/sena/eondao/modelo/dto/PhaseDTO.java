/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;


public class PhaseDTO {
    private String NamePhase;
    private boolean state;
    private String projectCode;

    public PhaseDTO() {
    }

    public String getNamePhase() {
        return NamePhase;
    }

    public void setNamePhase(String NamePhase) {
        this.NamePhase = NamePhase;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.NamePhase);
        hash = 11 * hash + (this.state ? 1 : 0);
        hash = 11 * hash + Objects.hashCode(this.projectCode);
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
        final PhaseDTO other = (PhaseDTO) obj;
        if (this.state != other.state) {
            return false;
        }
        if (!Objects.equals(this.NamePhase, other.NamePhase)) {
            return false;
        }
        if (!Objects.equals(this.projectCode, other.projectCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhaseDTO{" + "NamePhase=" + NamePhase + ", state=" + state + ", projectCode=" + projectCode + '}';
    }

   

   
}
