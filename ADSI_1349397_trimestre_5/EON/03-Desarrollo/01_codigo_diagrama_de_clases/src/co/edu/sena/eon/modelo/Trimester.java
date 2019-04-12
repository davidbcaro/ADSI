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
public class Trimester {
    private String quarterName;
    private WorkingDay workingDay;
    private List<FichaHasTrimestre>fichaHasTrimestre;
    private List<TrimesterHasLearningResult>trimestreHasLearningresult;

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    public List<FichaHasTrimestre> getFichaHasTrimestre() {
        return fichaHasTrimestre;
    }

    public List<TrimesterHasLearningResult> getTrimestreHasLearningresult() {
        return trimestreHasLearningresult;
    }

    public void setTrimestreHasLearningresult(List<TrimesterHasLearningResult> trimestreHasLearningresult) {
        this.trimestreHasLearningresult = trimestreHasLearningresult;
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
        final Trimester other = (Trimester) obj;
        if (!Objects.equals(this.quarterName, other.quarterName)) {
            return false;
        }
        return true;
    }
   
    
}
