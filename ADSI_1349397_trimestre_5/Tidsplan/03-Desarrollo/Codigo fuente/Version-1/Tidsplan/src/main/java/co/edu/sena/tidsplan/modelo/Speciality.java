/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Speciality {

    private String nameSpeciality;
    private boolean status;
    private Instructor instructors;

    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Instructor getInstructors() {
        return instructors;
    }

    public void setInstructors(Instructor instructors) {
        this.instructors = instructors;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nameSpeciality);
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
        final Speciality other = (Speciality) obj;
        if (!Objects.equals(this.nameSpeciality, other.nameSpeciality)) {
            return false;
        }
        return true;
    }
    
}
