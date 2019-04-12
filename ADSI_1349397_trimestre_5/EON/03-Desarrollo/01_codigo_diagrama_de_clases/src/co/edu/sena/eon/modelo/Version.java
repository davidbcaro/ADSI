/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.List;

/**
 *
 * @author SOPORTE
 */
public class Version {
    private int idVersion;
    private boolean active;
    private CurrentQuarter curentQuarter;
    private List <Schedule>schedule;

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CurrentQuarter getCurentQuarter() {
        return curentQuarter;
    }

    public void setCurentQuarter(CurrentQuarter curentQuarter) {
        this.curentQuarter = curentQuarter;
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
        final Version other = (Version) obj;
        if (this.idVersion != other.idVersion) {
            return false;
        }
        return true;
    }
    
    
}
