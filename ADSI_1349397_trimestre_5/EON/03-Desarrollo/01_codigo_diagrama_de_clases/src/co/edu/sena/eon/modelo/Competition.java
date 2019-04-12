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
public class Competition {
    private String descrption;
    private String code;
    private List <ProgrmHasCompetition> programHasCompetition;

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getCode() {
        return code;
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
        final Competition other = (Competition) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ProgrmHasCompetition> getProgramHasCompetition() {
        return programHasCompetition;
    }

    public void setProgramHasCompetition(List<ProgrmHasCompetition> programHasCompetition) {
        this.programHasCompetition = programHasCompetition;
    }
    
    
}
