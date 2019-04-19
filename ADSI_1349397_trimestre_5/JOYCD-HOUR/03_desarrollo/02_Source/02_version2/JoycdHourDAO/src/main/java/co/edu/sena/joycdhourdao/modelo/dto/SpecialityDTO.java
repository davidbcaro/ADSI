/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class SpecialityDTO implements java.io.Serializable  {
   
    private static long serialVersionUID= 20L;
    
    private String nameSpeciality;
    private boolean status;
    

    public SpecialityDTO() {
    }

    
    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final SpecialityDTO other = (SpecialityDTO) obj;
        if (!Objects.equals(this.nameSpeciality, other.nameSpeciality)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpecialityDTO{" + "nameSpeciality=" + nameSpeciality + ", status=" + status + '}';
    }
     
    
    
    
}
