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
public class TrimesterDTO {

    
    private int number;
    private String initials;
    private String code;

    public TrimesterDTO() {
    }

    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.number;
        hash = 13 * hash + Objects.hashCode(this.initials);
        hash = 13 * hash + Objects.hashCode(this.code);
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
        final TrimesterDTO other = (TrimesterDTO) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.initials, other.initials)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrimesterDTO{" + "number=" + number + ", initials=" + initials + ", code=" + code + '}';
    }
    
    
}
