/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author LUISBERNARDO
 */
public class ProgramPkDTO {
    public String Code;
    public String Version;
    public String training_Level;

    public ProgramPkDTO() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public String getTraining_Level() {
        return training_Level;
    }

    public void setTraining_Level(String training_Level) {
        this.training_Level = training_Level;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.Code);
        hash = 13 * hash + Objects.hashCode(this.Version);
        hash = 13 * hash + Objects.hashCode(this.training_Level);
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
        final ProgramPkDTO other = (ProgramPkDTO) obj;
        if (!Objects.equals(this.Code, other.Code)) {
            return false;
        }
        if (!Objects.equals(this.Version, other.Version)) {
            return false;
        }
        if (!Objects.equals(this.training_Level, other.training_Level)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProgramPkDTO{" + "Code=" + Code + ", Version=" + Version + ", training_Level=" + training_Level + '}';
    }
    
    
}
