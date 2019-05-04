/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;

/**
 *
 * @author 1349397
 */
public class Version {
    private int idVersion;
    private boolean status;
    private List<Schedule> schedules;
    private TrimesterCurrent trimesterCurrent;

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
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

    public TrimesterCurrent getTrimesterCurrent() {
        return trimesterCurrent;
    }

    public void setTrimesterCurrent(TrimesterCurrent trimesterCurrent) {
        this.trimesterCurrent = trimesterCurrent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idVersion;
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
