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
public class LearningResult {
    private String code;
    private String description;
    private ProgrmHasCompetition ProgramHasCompetition;
private List <TrimesterHasLearningResult>trimestreHasLearningresult;

    public List<TrimesterHasLearningResult> getTrimestreHasLearningresult() {
        return trimestreHasLearningresult;
    }

    public void setTrimestreHasLearningresult(List<TrimesterHasLearningResult> trimestreHasLearningresult) {
        this.trimestreHasLearningresult = trimestreHasLearningresult;
    }
 private List<LearningResultHasActivity>LearningResultHasActivity;
 private List <FichaHasTrimesterHasLeningResult> fichaHasTrimesterHasLeningResult;

    public List<FichaHasTrimesterHasLeningResult> getFichaHasTrimesterHasLeningResult() {
        return fichaHasTrimesterHasLeningResult;
    }

    public void setFichaHasTrimesterHasLeningResult(List<FichaHasTrimesterHasLeningResult> fichaHasTrimesterHasLeningResult) {
        this.fichaHasTrimesterHasLeningResult = fichaHasTrimesterHasLeningResult;
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
        final LearningResult other = (LearningResult) obj;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgrmHasCompetition getProgramHasCompetition() {
        return ProgramHasCompetition;
    }

    public void setProgramHasCompetition(ProgrmHasCompetition ProgramHasCompetition) {
        this.ProgramHasCompetition = ProgramHasCompetition;
    }


  
    public List<LearningResultHasActivity> getLearningResultHasActivity() {
        return LearningResultHasActivity;
    }

    public void setLearningResultHasActivity(List<LearningResultHasActivity> LearningResultHasActivity) {
        this.LearningResultHasActivity = LearningResultHasActivity;
    }
    
    
    
}
