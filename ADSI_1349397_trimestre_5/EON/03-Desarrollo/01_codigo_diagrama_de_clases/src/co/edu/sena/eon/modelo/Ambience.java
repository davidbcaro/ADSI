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
public class Ambience {
    private String numberAmbience;
    private String description;
    private boolean Status;
    private Headquarters headquarter;
    private List <Schedule>schedule;

    public String getNumberAmbience() {
        return numberAmbience;
    }

    public void setNumberAmbience(String numberAmbience) {
        this.numberAmbience = numberAmbience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Headquarters getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(Headquarters headquarter) {
        this.headquarter = headquarter;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Ambience other = (Ambience) obj;
        if (!Objects.equals(this.numberAmbience, other.numberAmbience)) {
            return false;
        }
        return true;
    }
    
}
