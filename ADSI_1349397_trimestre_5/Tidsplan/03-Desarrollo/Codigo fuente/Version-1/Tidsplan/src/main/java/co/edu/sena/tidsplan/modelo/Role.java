/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author 1349397
 */
public class Role {
    private String idRol;
    private String description;
    private boolean status;
    private List<CustomerHasRole> customerHasRoles;

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean Status) {
        this.status = Status;
    }

    public List<CustomerHasRole> getCustomerHasRoles() {
        return customerHasRoles;
    }

    public void setCustomerHasRoles(List<CustomerHasRole> customerHasRoles) {
        this.customerHasRoles = customerHasRoles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idRol);
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
        if (!Objects.equals(this.idRol, other.idRol)) {
            return false;
        }
        return true;
    }

}
