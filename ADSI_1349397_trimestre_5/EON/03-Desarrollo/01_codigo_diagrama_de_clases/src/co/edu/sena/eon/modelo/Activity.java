/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;


import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class Activity {
    private int idActivity;
    private String name;
    private List<LearningResultHasActivity>LearninResultHasActivity;

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LearningResultHasActivity> getLearninResultHasActivity() {
        return LearninResultHasActivity;
    }

    public void setLearninResultHasActivity(List<LearningResultHasActivity> LearninResultHasActivity) {
        this.LearninResultHasActivity = LearninResultHasActivity;
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
        final Activity other = (Activity) obj;
        if (this.idActivity != other.idActivity) {
            return false;
        }
        return true;
    }
    
    
}
