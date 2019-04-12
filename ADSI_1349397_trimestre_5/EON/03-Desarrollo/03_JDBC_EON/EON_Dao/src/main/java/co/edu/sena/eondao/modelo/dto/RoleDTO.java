/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.modelo.dto;

import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class RoleDTO implements java.io.Serializable{
    private String id_Role;
    private String Description;
    private boolean Status;

    public RoleDTO() {
    }

    public String getId_Role() {
        return id_Role;
    }

    public void setId_Role(String id_Role) {
        this.id_Role = id_Role;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id_Role);
        hash = 71 * hash + Objects.hashCode(this.Description);
        hash = 71 * hash + (this.Status ? 1 : 0);
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
        final RoleDTO other = (RoleDTO) obj;
        if (this.Status != other.Status) {
            return false;
        }
        if (!Objects.equals(this.id_Role, other.id_Role)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RoleDTO{" + "id_Role=" + id_Role + ", Description=" + Description + ", Status=" + Status + '}';
    }

    
}
