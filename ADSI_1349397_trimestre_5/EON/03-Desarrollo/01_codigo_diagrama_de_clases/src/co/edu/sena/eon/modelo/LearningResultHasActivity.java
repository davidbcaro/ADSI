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
class LearningResultHasActivity {
    private LearningResult learninresult;
    private Activity activity;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.learninresult);
        hash = 83 * hash + Objects.hashCode(this.activity);
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
        final LearningResultHasActivity other = (LearningResultHasActivity) obj;
        if (!Objects.equals(this.learninresult, other.learninresult)) {
            return false;
        }
        if (!Objects.equals(this.activity, other.activity)) {
            return false;
        }
        return true;
    }

    public LearningResult getLearninresult() {
        return learninresult;
    }

    public void setLearninresult(LearningResult learninresult) {
        this.learninresult = learninresult;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    
}
