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
public class WorkingDay {
    private String initials;
    private String name;
    private String description;
    private byte image;
    private boolean status;
    private List<Trimester> trimesters;
    private List<Disponibility> disponibilitys;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public byte getImage() {
        return image;
    }

    public void setImage(byte image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Trimester> getTrimesters() {
        return trimesters;
    }

    public void setTrimesters(List<Trimester> trimesters) {
        this.trimesters = trimesters;
    }

    public List<Disponibility> getDisponibilitys() {
        return disponibilitys;
    }

    public void setDisponibilitys(List<Disponibility> disponibilitys) {
        this.disponibilitys = disponibilitys;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.initials);
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
        final WorkingDay other = (WorkingDay) obj;
        if (!Objects.equals(this.initials, other.initials)) {
            return false;
        }
        return true;
    }
    
}
