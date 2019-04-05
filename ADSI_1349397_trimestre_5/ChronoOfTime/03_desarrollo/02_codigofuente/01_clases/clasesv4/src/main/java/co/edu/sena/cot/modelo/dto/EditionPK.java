/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorge
 */
@Embeddable
public class EditionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ide_edition", nullable = false)
    private int ideEdition;
    @Basic(optional = false)
    @Column(name = "id_trimester", nullable = false, length = 25)
    private String idTrimester;

    public EditionPK() {
    }

    public EditionPK(int ideEdition, String idTrimester) {
        this.ideEdition = ideEdition;
        this.idTrimester = idTrimester;
    }

    public int getIdeEdition() {
        return ideEdition;
    }

    public void setIdeEdition(int ideEdition) {
        this.ideEdition = ideEdition;
    }

    public String getIdTrimester() {
        return idTrimester;
    }

    public void setIdTrimester(String idTrimester) {
        this.idTrimester = idTrimester;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ideEdition;
        hash += (idTrimester != null ? idTrimester.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EditionPK)) {
            return false;
        }
        EditionPK other = (EditionPK) object;
        if (this.ideEdition != other.ideEdition) {
            return false;
        }
        if ((this.idTrimester == null && other.idTrimester != null) || (this.idTrimester != null && !this.idTrimester.equals(other.idTrimester))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.EditionPK[ ideEdition=" + ideEdition + ", idTrimester=" + idTrimester + " ]";
    }
    
}
