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
public class EmploymentRelationship {
    private String typeEmploymentRelationship;
    private int hours;
    private boolean status;
    private Instructor instructor;

    public String getTypeEmploymentRelationship() {
        return typeEmploymentRelationship;
    }

    public void setTypeEmploymentRelationship(String typeEmploymentRelationship) {
        this.typeEmploymentRelationship = typeEmploymentRelationship;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.typeEmploymentRelationship);
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
        final EmploymentRelationship other = (EmploymentRelationship) obj;
        if (!Objects.equals(this.typeEmploymentRelationship, other.typeEmploymentRelationship)) {
            return false;
        }
        return true;
    }
    
    
}
