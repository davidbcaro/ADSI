/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class CurrentQuarter {
    private String idCurrent;
    private Date startDate;
    private Date endDate;
    private List <Version>version;

    public String getIdCurrent() {
        return idCurrent;
    }

    public void setIdCurrent(String idCurrent) {
        this.idCurrent = idCurrent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Version> getVersion() {
        return version;
    }

    public void setVersion(List<Version> version) {
        this.version = version;
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
        final CurrentQuarter other = (CurrentQuarter) obj;
        if (!Objects.equals(this.idCurrent, other.idCurrent)) {
            return false;
        }
        return true;
    }
    
}
