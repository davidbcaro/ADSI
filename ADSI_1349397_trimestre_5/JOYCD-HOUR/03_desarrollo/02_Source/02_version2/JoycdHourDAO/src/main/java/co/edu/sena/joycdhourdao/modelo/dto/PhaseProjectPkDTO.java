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
public class PhaseProjectPkDTO {

    private static long serialVersionUID = 43L;
    private String namephase;
    private String projectcode;

    public String getNamephase() {
        return namephase;
    }

    public void setNamephase(String namephase) {
        this.namephase = namephase;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.namephase);
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
        final PhaseProjectPkDTO other = (PhaseProjectPkDTO) obj;
        if (!Objects.equals(this.namephase, other.namephase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhaseProjectPkDTO{" + "namephase=" + namephase + ", projectcode=" + projectcode + '}';
    }

}
