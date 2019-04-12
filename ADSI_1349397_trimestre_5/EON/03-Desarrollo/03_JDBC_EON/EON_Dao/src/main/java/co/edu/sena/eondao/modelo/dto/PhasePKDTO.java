
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;


public class PhasePKDTO {
    
    private String phaseName;
    private String projectCode;

    public PhasePKDTO() {
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.phaseName);
        hash = 47 * hash + Objects.hashCode(this.projectCode);
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
        final PhasePKDTO other = (PhasePKDTO) obj;
        if (!Objects.equals(this.phaseName, other.phaseName)) {
            return false;
        }
        if (!Objects.equals(this.projectCode, other.projectCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhasePKDTO{" + "phaseName=" + phaseName + ", projectCode=" + projectCode + '}';
    }
   
}
