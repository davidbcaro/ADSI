/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.model.dto;

import java.util.Objects;

/**
 *
 * @author WINDOWS 8
 */
public class EnvironmentDTO implements java.io.Serializable {
    
   private String numberEnvironment;
   private String description;
   private boolean state;
   private String nameHeadquarters;

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.numberEnvironment);
        hash = 31 * hash + Objects.hashCode(this.nameHeadquarters);
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
        final EnvironmentDTO other = (EnvironmentDTO) obj;
        if (!Objects.equals(this.numberEnvironment, other.numberEnvironment)) {
            return false;
        }
        if (!Objects.equals(this.nameHeadquarters, other.nameHeadquarters)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnvironmentDTO{" + "numberEnvironment=" + numberEnvironment + ", description=" + description + ", state=" + state + ", nameHeadquarters=" + nameHeadquarters + '}';
    }
   
   
    
}
