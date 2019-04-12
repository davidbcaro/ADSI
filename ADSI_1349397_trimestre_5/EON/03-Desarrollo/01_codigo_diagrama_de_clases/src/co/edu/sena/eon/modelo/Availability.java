/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.sql.Timestamp;

import java.util.List;
import java.util.Objects;



/**
 *
 * @author SOPORTE
 */
public class Availability {
    private Timestamp start;
    private Timestamp end;
    private WorkingDay workingDay;
    private Day day;
    private List<Instructor>intructor;

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDay workingDay) {
        this.workingDay = workingDay;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Instructor> getIntructor() {
        return intructor;
    }

    public void setIntructor(List<Instructor> intructor) {
        this.intructor = intructor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Availability other = (Availability) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        return true;
    }
    
}
