/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.model.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 1349397
 */
@Embeddable
public class AmbiencePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "number_Ambience", nullable = false, length = 30)
    private String numberAmbience;
    @Basic(optional = false)
    @Column(name = "name_Headquarters", nullable = false, length = 100)
    private String nameHeadquarters;

    public AmbiencePK() {
    }

    public AmbiencePK(String numberAmbience, String nameHeadquarters) {
        this.numberAmbience = numberAmbience;
        this.nameHeadquarters = nameHeadquarters;
    }

    public String getNumberAmbience() {
        return numberAmbience;
    }

    public void setNumberAmbience(String numberAmbience) {
        this.numberAmbience = numberAmbience;
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
        hash += (numberAmbience != null ? numberAmbience.hashCode() : 0);
        hash += (nameHeadquarters != null ? nameHeadquarters.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbiencePK)) {
            return false;
        }
        AmbiencePK other = (AmbiencePK) object;
        if ((this.numberAmbience == null && other.numberAmbience != null) || (this.numberAmbience != null && !this.numberAmbience.equals(other.numberAmbience))) {
            return false;
        }
        if ((this.nameHeadquarters == null && other.nameHeadquarters != null) || (this.nameHeadquarters != null && !this.nameHeadquarters.equals(other.nameHeadquarters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.eon_jpa.model.jpa.entities.AmbiencePK[ numberAmbience=" + numberAmbience + ", nameHeadquarters=" + nameHeadquarters + " ]";
    }
    
}
