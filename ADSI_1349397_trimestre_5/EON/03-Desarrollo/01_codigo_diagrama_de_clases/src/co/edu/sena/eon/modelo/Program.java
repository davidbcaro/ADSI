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
public class Program {
    private String code;

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
        final Program other = (Program) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public TraningLevel getTraningLevel() {
        return traningLevel;
    }

    public void setTraningLevel(TraningLevel traningLevel) {
        this.traningLevel = traningLevel;
    }

    public List<ProgrmHasCompetition> getProgramHasCompetition() {
        return programHasCompetition;
    }

    public void setProgramHasCompetition(List<ProgrmHasCompetition> programHasCompetition) {
        this.programHasCompetition = programHasCompetition;
    }

    public List<Ficha> getFicha() {
        return ficha;
    }

    public void setFicha(List<Ficha> ficha) {
        this.ficha = ficha;
    }
    private String name;
    private String initials;
    private boolean state;
    private TraningLevel traningLevel;
    private List <ProgrmHasCompetition> programHasCompetition;
    private List<Ficha>ficha;
    
   
   
    
}
