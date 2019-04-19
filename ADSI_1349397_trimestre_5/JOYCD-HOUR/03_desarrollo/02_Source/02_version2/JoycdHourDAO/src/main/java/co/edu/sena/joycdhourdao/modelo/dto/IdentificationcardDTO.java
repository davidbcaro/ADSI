/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author Usser
 */
public class IdentificationcardDTO implements java.io.Serializable {
    private static long serialVersionUID = 43L;
    
    private String idindentificationcardnumber;
    private String name;
    private boolean status;
    
    public IdentificationcardDTO() {
    }

    public String getIdindentificationcardnumber() {
        return idindentificationcardnumber;
    }

    public void setIdindentificationcardnumber(String idindentificationcardnumber) {
        this.idindentificationcardnumber = idindentificationcardnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idindentificationcardnumber);
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
        final IdentificationcardDTO other = (IdentificationcardDTO) obj;
        if (!Objects.equals(this.idindentificationcardnumber, other.idindentificationcardnumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdentificationcardDTO{" + "idindentificationcardnumber=" + idindentificationcardnumber + ", name=" + name + ", status=" + status + '}';
    }
    
    
    
}
