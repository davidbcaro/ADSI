/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.model.dto;

import java.util.Objects;

/**
 *
 * @author SENA
 */
public class PhaseDTO implements java.io.Serializable {
    
    private static long serialVersionUID = 43L;
    
    private String namePhase;
    private boolean state;
    private String projectCode;
    
    
    public PhaseDTO() {
    } 

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        PhaseDTO.serialVersionUID = serialVersionUID;
    }

    public String getNamePhase() {
        return namePhase;
    }

    public void setNamePhase(String namePhase) {
        this.namePhase = namePhase;
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
        hash = 41 * hash + Objects.hashCode(this.projectCode);
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
        if (!Objects.equals(this.projectCode, other.projectCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhaseDTO{" + "namePhase=" + namePhase + ", state=" + state + ", projectCode=" + projectCode + '}';
    }
    
    
    
    
    
}
