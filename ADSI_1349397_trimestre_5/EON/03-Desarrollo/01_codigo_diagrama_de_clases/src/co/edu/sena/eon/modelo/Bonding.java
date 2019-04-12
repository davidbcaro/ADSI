/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class Bonding {
    private String typeLinkage;
    private int horus;
    private boolean status;
    private Instructor ins; 

    public String getTypeLinkage() {
        return typeLinkage;
    }

    public void setTypeLinkage(String typeLinkage) {
        this.typeLinkage = typeLinkage;
    }



    public Instructor getIns() {
        return ins;
    }

    public void setIns(Instructor ins) {
        this.ins = ins;
    }

  

    public int getHorus() {
        return horus;
    }

    public void setHorus(int horus) {
        this.horus = horus;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Bonding other = (Bonding) obj;
        if (!Objects.equals(this.typeLinkage, other.typeLinkage)) {
            return false;
        }
        return true;
    }
    
    
    
}
