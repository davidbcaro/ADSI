/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class EnvironmentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "number_environment", nullable = false, length = 45)
    private String numberEnvironment;
    @Basic(optional = false)
    @Column(name = "headquarters_name", nullable = false, length = 100)
    private String headquartersName;

    public EnvironmentPK() {
    }

    public EnvironmentPK(String numberEnvironment, String headquartersName) {
        this.numberEnvironment = numberEnvironment;
        this.headquartersName = headquartersName;
    }

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getHeadquartersName() {
        return headquartersName;
    }

    public void setHeadquartersName(String headquartersName) {
        this.headquartersName = headquartersName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberEnvironment != null ? numberEnvironment.hashCode() : 0);
        hash += (headquartersName != null ? headquartersName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnvironmentPK)) {
            return false;
        }
        EnvironmentPK other = (EnvironmentPK) object;
        if ((this.numberEnvironment == null && other.numberEnvironment != null) || (this.numberEnvironment != null && !this.numberEnvironment.equals(other.numberEnvironment))) {
            return false;
        }
        if ((this.headquartersName == null && other.headquartersName != null) || (this.headquartersName != null && !this.headquartersName.equals(other.headquartersName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.model.jpa.entities.EnvironmentPK[ numberEnvironment=" + numberEnvironment + ", headquartersName=" + headquartersName + " ]";
    }
    
}
