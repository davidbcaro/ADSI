/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class PhasePkDTO {
    
    private String namePhase;
    private int projectCode;
    
    public PhasePkDTO(){
        
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.namePhase);
        hash = 71 * hash + this.projectCode;
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
        final PhasePkDTO other = (PhasePkDTO) obj;
        if (this.projectCode != other.projectCode) {
            return false;
        }
        if (!Objects.equals(this.namePhase, other.namePhase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhasePkDTO{" + "namePhase=" + namePhase + ", ProjectCode=" + projectCode + '}';
    }
    
    
    
}
