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
public class HeadquartersDTO {
    
    
    private static long serialVersionUID= 21L;
    
    private String nameHeadquarters;
    private String direction;
    private boolean status;

    public HeadquartersDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        HeadquartersDTO.serialVersionUID = serialVersionUID;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nameHeadquarters);
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
        final HeadquartersDTO other = (HeadquartersDTO) obj;
        if (!Objects.equals(this.nameHeadquarters, other.nameHeadquarters)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HeadquartersDTO{" + "nameHeadquarters=" + nameHeadquarters + ", direction=" + direction + ", status=" + status + '}';
    }
    
    
    
}
