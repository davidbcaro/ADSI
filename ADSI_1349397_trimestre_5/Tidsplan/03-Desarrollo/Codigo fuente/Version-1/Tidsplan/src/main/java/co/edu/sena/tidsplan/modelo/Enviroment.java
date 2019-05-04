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
public class Enviroment {
    private String numberEnvironment;
    private String description;
    private boolean status;
    private List<Schedule> schedules;
    private Headquartes headquartes;

    public String getNumberEnvironment() {
        return numberEnvironment;
    }

    public void setNumberEnvironment(String numberEnvironment) {
        this.numberEnvironment = numberEnvironment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Headquartes getHeadquartes() {
        return headquartes;
    }

    public void setHeadquartes(Headquartes headquartes) {
        this.headquartes = headquartes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.numberEnvironment);
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
        final Enviroment other = (Enviroment) obj;
        if (!Objects.equals(this.numberEnvironment, other.numberEnvironment)) {
            return false;
        }
        return true;
    }
    
    
}
