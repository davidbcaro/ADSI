/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author liosalfar
 */
public class EnvironmentPKDTO {
    
    private static long serialVersionUID = 23L;
    
      private  int numberEnvironment;
     private String headquartersName;

    public EnvironmentPKDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        EnvironmentPKDTO.serialVersionUID = serialVersionUID;
    }

    public int getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(int numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getHeadquartersName() {
        return headquartersName;
    }

    public void setHeadquartersName(String headquartersName) {
        this.headquartersName = headquartersName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.numberEnvironment;
        hash = 47 * hash + Objects.hashCode(this.headquartersName);
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
        final EnvironmentPKDTO other = (EnvironmentPKDTO) obj;
        if (this.numberEnvironment != other.numberEnvironment) {
            return false;
        }
        if (!Objects.equals(this.headquartersName, other.headquartersName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnvironmentPKDTO{" + "numberEnvironment=" + numberEnvironment + ", headquartersName=" + headquartersName + '}';
    }
     
     
     
    
}
