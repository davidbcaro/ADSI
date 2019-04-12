/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class Ficha {
    private String numberFicha;
    private Date StartDate;
    private Date endDate;
    private Character Roule;
    private String traningLevel;

    private Program program;
    private List<FichaHasTrimestre>fichaHasTrimestre;

    public String getNumberFicha() {
        return numberFicha;
    }

    public void setNumberFicha(String numberFicha) {
        this.numberFicha = numberFicha;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Character getRoule() {
        return Roule;
    }

    public void setRoule(Character Roule) {
        this.Roule = Roule;
    }

    public String getTraningLevel() {
        return traningLevel;
    }

    public void setTraningLevel(String traningLevel) {
        this.traningLevel = traningLevel;
    }

   

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<FichaHasTrimestre> getFichaHasTrimestre() {
        return fichaHasTrimestre;
    }

    public void setFichaHasTrimestre(List<FichaHasTrimestre> fichaHasTrimestre) {
        this.fichaHasTrimestre = fichaHasTrimestre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Ficha other = (Ficha) obj;
        if (!Objects.equals(this.numberFicha, other.numberFicha)) {
            return false;
        }
        return true;
    }
    
    
    
}
