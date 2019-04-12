/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class Modality {

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
        final Modality other = (Modality) obj;
        if (!Objects.equals(this.modaliTyname, other.modaliTyname)) {
            return false;
        }
        return true;
    }
    private String modaliTyname;
    private boolean state;
    private List <Schedule>sgedule;
    

    public String getModaliTyname() {
        return modaliTyname;
    }

    public void setModaliTyname(String modaliTyname) {
        this.modaliTyname = modaliTyname;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<Schedule> getSgedule() {
        return sgedule;
    }

    public void setSgedule(List<Schedule> sgedule) {
        this.sgedule = sgedule;
    }
    
    
    
}
