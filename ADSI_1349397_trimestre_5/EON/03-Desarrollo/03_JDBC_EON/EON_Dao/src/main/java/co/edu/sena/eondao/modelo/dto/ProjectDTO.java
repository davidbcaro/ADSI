
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;

public class ProjectDTO implements java.io.Serializable {
 private String Code;
 private String Name;
 private boolean State;

    public ProjectDTO() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Code);
        hash = 67 * hash + Objects.hashCode(this.Name);
        hash = 67 * hash + (this.State ? 1 : 0);
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
        final ProjectDTO other = (ProjectDTO) obj;
        if (this.State != other.State) {
            return false;
        }
        if (!Objects.equals(this.Code, other.Code)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" + "Code=" + Code + ", Name=" + Name + ", State=" + State + '}';
    }
    
    
    

}