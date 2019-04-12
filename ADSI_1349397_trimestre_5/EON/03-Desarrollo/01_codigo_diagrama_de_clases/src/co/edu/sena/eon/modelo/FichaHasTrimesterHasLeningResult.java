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
public class FichaHasTrimesterHasLeningResult {
    private FichaHasTrimestre fichahastrimester;
    private LearningResult learningresult;

    public FichaHasTrimestre getFichahastrimester() {
        return fichahastrimester;
    }

    public void setFichahastrimester(FichaHasTrimestre fichahastrimester) {
        this.fichahastrimester = fichahastrimester;
    }

    public LearningResult getLearningresult() {
        return learningresult;
    }

    public void setLearningresult(LearningResult learningresult) {
        this.learningresult = learningresult;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.fichahastrimester);
        hash = 53 * hash + Objects.hashCode(this.learningresult);
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
        final FichaHasTrimesterHasLeningResult other = (FichaHasTrimesterHasLeningResult) obj;
        if (!Objects.equals(this.fichahastrimester, other.fichahastrimester)) {
            return false;
        }
        if (!Objects.equals(this.learningresult, other.learningresult)) {
            return false;
        }
        return true;
    }
    
}
