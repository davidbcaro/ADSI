/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.model.jpa.entities;

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
    @Column(name = "number_environment", nullable = false, length = 50)
    private String numberEnvironment;
    @Basic(optional = false)
    @Column(name = "name_headquartes", nullable = false, length = 100)
    private String nameHeadquartes;

    public EnvironmentPK() {
    }

    public EnvironmentPK(String numberEnvironment, String nameHeadquartes) {
        this.numberEnvironment = numberEnvironment;
        this.nameHeadquartes = nameHeadquartes;
    }

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getNameHeadquartes() {
        return nameHeadquartes;
    }

    public void setNameHeadquartes(String nameHeadquartes) {
        this.nameHeadquartes = nameHeadquartes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberEnvironment != null ? numberEnvironment.hashCode() : 0);
        hash += (nameHeadquartes != null ? nameHeadquartes.hashCode() : 0);
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
        if ((this.nameHeadquartes == null && other.nameHeadquartes != null) || (this.nameHeadquartes != null && !this.nameHeadquartes.equals(other.nameHeadquartes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.tidsplanjpa.model.jpa.entities.EnvironmentPK[ numberEnvironment=" + numberEnvironment + ", nameHeadquartes=" + nameHeadquartes + " ]";
    }
    
}
