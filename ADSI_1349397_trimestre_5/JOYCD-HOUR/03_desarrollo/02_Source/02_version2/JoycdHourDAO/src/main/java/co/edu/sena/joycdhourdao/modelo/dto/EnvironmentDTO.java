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
public class EnvironmentDTO implements java.io.Serializable{
    
    private static long serialVersionUID = 23L;
     
    private  int numberEnvironment;
    private String description;
    private boolean status;
    private String headquartersName;

    public EnvironmentDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        EnvironmentDTO.serialVersionUID = serialVersionUID;
    }

    public int getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(int numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getHeadquartersName() {
        return headquartersName;
    }

    public void setHeadquartersName(String headquartersName) {
        this.headquartersName = headquartersName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numberEnvironment;
        hash = 37 * hash + Objects.hashCode(this.headquartersName);
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
        return "EnvironmentDTO{" + "numberEnvironment=" + numberEnvironment + ", description=" + description + ", status=" + status + ", headquartersName=" + headquartersName + '}';
    }
    
    
    
    
    
}
