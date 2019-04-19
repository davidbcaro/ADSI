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
public class DayDTO implements java.io.Serializable  {
   
    private static long serialVersionUID= 20L;
    
    private String nameDay;
    private boolean status;
    

    public DayDTO() {
    }

    
    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
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
        final DayDTO other = (DayDTO) obj;
        if (!Objects.equals(this.nameDay, other.nameDay)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DayDTO{" + "nameDay=" + nameDay + ", status=" + status + '}';
    }
     
    
    
    
}
