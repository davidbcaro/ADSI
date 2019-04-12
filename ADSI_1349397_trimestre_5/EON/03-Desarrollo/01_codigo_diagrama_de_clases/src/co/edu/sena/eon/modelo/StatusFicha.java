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
public class StatusFicha{
    private String nameState;
    private String State;
    private List<Ficha>ficha;

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public List<Ficha> getFicha() {
        return ficha;
    }

    public void setFicha(List<Ficha> ficha) {
        this.ficha = ficha;
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
        final StatusFicha other = (StatusFicha) obj;
        if (!Objects.equals(this.nameState, other.nameState)) {
            return false;
        }
        return true;
    }
    
    

}
