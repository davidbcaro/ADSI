/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOPORTE
 */
public class Role {
    private String idRole;
    private String description;
    private String status;
    private List<Clienthasrole>persona; 

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public List<Clienthasrole> getPersona() {
        return persona;
    }

    public void setPersona(List<Clienthasrole> persona) {
        this.persona = persona;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role(String idRole) {
        this.idRole = idRole;
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
        final Role other = (Role) obj;
        if (!Objects.equals(this.idRole, other.idRole)) {
            return false;
        }
        return true;
    }

  
 
    
}
