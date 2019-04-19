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
public class StatusGroupNumberDTO {
    private static long serialVersionUID= 20L;
    
    private String statusname;
    private boolean status;

    public StatusGroupNumberDTO() {
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
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
        hash = 17 * hash + Objects.hashCode(this.statusname);
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
        final StatusGroupNumberDTO other = (StatusGroupNumberDTO) obj;
        if (!Objects.equals(this.statusname, other.statusname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusGroupNumberDTO{" + "statusname=" + statusname + ", status=" + status + '}';
    }

   
}
