/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Disponibility {
    private Time startHour;
    private Time endHour;
    private Instructor instructor;
    private Day day;
    private WorkingDay workingDay;

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() {
        return endHour;
    }

    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.startHour);
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
        final Disponibility other = (Disponibility) obj;
        if (!Objects.equals(this.startHour, other.startHour)) {
            return false;
        }
        return true;
    }
    
    
}
