/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class Day {
    private String nameDay;
    private String State;
    private List<Availability>Availity;
    private List<Schedule>schedule;

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public List<Availability> getAvaility() {
        return Availity;
    }

    public void setAvaility(List<Availability> Availity) {
        this.Availity = Availity;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Day other = (Day) obj;
        if (!Objects.equals(this.nameDay, other.nameDay)) {
            return false;
        }
        return true;
    }
    
    
}
