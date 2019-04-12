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
public class ProgramDTO implements java.io.Serializable{
    public String Code;
    public String Version;
    public String Name;
    public String Initials;
    public boolean State;
    public String training_Level;

    public ProgramDTO() {
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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getInitials() {
        return Initials;
    }

    public void setInitials(String Initials) {
        this.Initials = Initials;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    public String getTraining_Level() {
        return training_Level;
    }

    public void setTraining_Level(String training_Level) {
        this.training_Level = training_Level;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Code);
        hash = 67 * hash + Objects.hashCode(this.Version);
        hash = 67 * hash + Objects.hashCode(this.Name);
        hash = 67 * hash + Objects.hashCode(this.Initials);
        hash = 67 * hash + (this.State ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.training_Level);
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
        final ProgramDTO other = (ProgramDTO) obj;
        if (this.State != other.State) {
            return false;
        }
        if (!Objects.equals(this.Code, other.Code)) {
            return false;
        }
        if (!Objects.equals(this.Version, other.Version)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Initials, other.Initials)) {
            return false;
        }
        if (!Objects.equals(this.training_Level, other.training_Level)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProgramDTO{" + "Code=" + Code + ", Version=" + Version + ", Name=" + Name + ", Initials=" + Initials + ", State=" + State + ", training_Level=" + training_Level + '}';
    }
}
