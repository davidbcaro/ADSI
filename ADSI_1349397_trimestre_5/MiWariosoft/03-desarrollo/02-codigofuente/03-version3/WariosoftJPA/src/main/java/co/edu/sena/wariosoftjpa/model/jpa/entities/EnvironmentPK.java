/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.model.jpa.entities;

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
    @Column(name = "number_Environment", nullable = false, length = 100)
    private String numberEnvironment;
    @Basic(optional = false)
    @Column(name = "name_Headquarters", nullable = false, length = 100)
    private String nameHeadquarters;

    public EnvironmentPK() {
    }

    public EnvironmentPK(String numberEnvironment, String nameHeadquarters) {
        this.numberEnvironment = numberEnvironment;
        this.nameHeadquarters = nameHeadquarters;
    }

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getNameHeadquarters() {
        return nameHeadquarters;
    }

    public void setNameHeadquarters(String nameHeadquarters) {
        this.nameHeadquarters = nameHeadquarters;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberEnvironment != null ? numberEnvironment.hashCode() : 0);
        hash += (nameHeadquarters != null ? nameHeadquarters.hashCode() : 0);
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
        if ((this.nameHeadquarters == null && other.nameHeadquarters != null) || (this.nameHeadquarters != null && !this.nameHeadquarters.equals(other.nameHeadquarters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.wariosoftjpa.model.jpa.entities.EnvironmentPK[ numberEnvironment=" + numberEnvironment + ", nameHeadquarters=" + nameHeadquarters + " ]";
    }
    
}
