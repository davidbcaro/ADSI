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
public class TraningLevel {
    private String traningLevel;
    private int State;
    private List<Program>program;

    public String getTraningLevel() {
        return traningLevel;
    }

    public void setTraningLevel(String traningLevel) {
        this.traningLevel = traningLevel;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public List<Program> getProgram() {
        return program;
    }

    public void setProgram(List<Program> program) {
        this.program = program;
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
        final TraningLevel other = (TraningLevel) obj;
        if (!Objects.equals(this.traningLevel, other.traningLevel)) {
            return false;
        }
        return true;
    }
    
    
}
