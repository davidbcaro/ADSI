/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public class TrimesterCurrent {
    private int idTrimester;
    private Date startDate;
    private Date endDate;
    private List<Version> versions;

    public int getIdTrimester() {
        return idTrimester;
    }

    public void setIdTrimester(int idTrimester) {
        this.idTrimester = idTrimester;
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

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idTrimester;
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
        final TrimesterCurrent other = (TrimesterCurrent) obj;
        if (this.idTrimester != other.idTrimester) {
            return false;
        }
        return true;
    }
    
    
}
