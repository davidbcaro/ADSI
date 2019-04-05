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
public class HeadquatersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "name_head", nullable = false, length = 45)
    private String nameHead;
    @Basic(optional = false)
    @Column(name = "num_environment", nullable = false, length = 45)
    private String numEnvironment;

    public HeadquatersPK() {
    }

    public HeadquatersPK(String nameHead, String numEnvironment) {
        this.nameHead = nameHead;
        this.numEnvironment = numEnvironment;
    }

    public String getNameHead() {
        return nameHead;
    }

    public void setNameHead(String nameHead) {
        this.nameHead = nameHead;
    }

    public String getNumEnvironment() {
        return numEnvironment;
    }

    public void setNumEnvironment(String numEnvironment) {
        this.numEnvironment = numEnvironment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameHead != null ? nameHead.hashCode() : 0);
        hash += (numEnvironment != null ? numEnvironment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeadquatersPK)) {
            return false;
        }
        HeadquatersPK other = (HeadquatersPK) object;
        if ((this.nameHead == null && other.nameHead != null) || (this.nameHead != null && !this.nameHead.equals(other.nameHead))) {
            return false;
        }
        if ((this.numEnvironment == null && other.numEnvironment != null) || (this.numEnvironment != null && !this.numEnvironment.equals(other.numEnvironment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.cot.modelo.dto.HeadquatersPK[ nameHead=" + nameHead + ", numEnvironment=" + numEnvironment + " ]";
    }
    
}
