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
public class FichaHasTrimestre {
    private Ficha ficha;
    private Trimester trimestre;
    private List <FichaHasTrimesterHasLeningResult> fichaHasTrimesterHasLeningResult;

    public Ficha getFicha() {
        return ficha;
    }

    public List<FichaHasTrimesterHasLeningResult> getFichaHasTrimesterHasLeningResult() {
        return fichaHasTrimesterHasLeningResult;
    }

    public void setFichaHasTrimesterHasLeningResult(List<FichaHasTrimesterHasLeningResult> fichaHasTrimesterHasLeningResult) {
        this.fichaHasTrimesterHasLeningResult = fichaHasTrimesterHasLeningResult;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Trimester getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimester trimestre) {
        this.trimestre = trimestre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.ficha);
        hash = 37 * hash + Objects.hashCode(this.trimestre);
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
        final FichaHasTrimestre other = (FichaHasTrimestre) obj;
        if (!Objects.equals(this.ficha, other.ficha)) {
            return false;
        }
        if (!Objects.equals(this.trimestre, other.trimestre)) {
            return false;
        }
        return true;
    }
    
}
