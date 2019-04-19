/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author SENA
 */
public class PhaseProjectDTO implements java.io.Serializable {
        private static long serialVersionUID = 43L;
        private String namephase;
        private String statusphase;
        private String projectcode;

    public PhaseProjectDTO() {
    }
        
        

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public String getNamephase() {
        return namephase;
    }

    public void setNamephase(String namephase) {
        this.namephase = namephase;
    }

    public String getStatusphase() {
        return statusphase;
    }

    public void setStatusphase(String statusphase) {
        this.statusphase = statusphase;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.namephase);
        hash = 79 * hash + Objects.hashCode(this.projectcode);
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
        final PhaseProjectDTO other = (PhaseProjectDTO) obj;
        if (!Objects.equals(this.namephase, other.namephase)) {
            return false;
        }
        if (!Objects.equals(this.projectcode, other.projectcode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhaseProjectDTO{" + "namephase=" + namephase + ", statusphase=" + statusphase + ", projectcode=" + projectcode + '}';
    }
        
}
