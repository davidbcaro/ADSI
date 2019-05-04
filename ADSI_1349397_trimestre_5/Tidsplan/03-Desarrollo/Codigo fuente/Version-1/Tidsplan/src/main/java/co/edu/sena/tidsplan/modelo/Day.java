/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Day {
    private String nameDay;
    private boolean status;
    private List<Schedule> schedules;
    private List<Disponibility> disponibilitys;

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Disponibility> getDisponibilitys() {
        return disponibilitys;
    }

    public void setDisponibilitys(List<Disponibility> disponibilitys) {
        this.disponibilitys = disponibilitys;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nameDay);
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
