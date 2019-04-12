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
public class TrimesterHasLearningResult {
    private LearningResult learningResult;
    private Trimester trimestres;

    public LearningResult getLearningResult() {
        return learningResult;
    }

    public void setLearningResult(LearningResult learningResult) {
        this.learningResult = learningResult;
    }

    public Trimester getTrimestres() {
        return trimestres;
    }

    public void setTrimestres(Trimester trimestres) {
        this.trimestres = trimestres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.learningResult);
        hash = 97 * hash + Objects.hashCode(this.trimestres);
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
        final TrimesterHasLearningResult other = (TrimesterHasLearningResult) obj;
        if (!Objects.equals(this.learningResult, other.learningResult)) {
            return false;
        }
        if (!Objects.equals(this.trimestres, other.trimestres)) {
            return false;
        }
        return true;
    }
    
    
}
