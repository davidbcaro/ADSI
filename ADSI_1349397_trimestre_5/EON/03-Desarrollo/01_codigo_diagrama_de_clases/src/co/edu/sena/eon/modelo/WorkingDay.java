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
public class WorkingDay {
    private String acronymsWorking;
    private String Name;
    private String Description;
    private boolean image;
    private int State;
    private List<Trimester>trimestre; 
    private List<Schedule>schule;
    private List <Availability>aAvailability;

    public String getAcronymsWorking() {
        return acronymsWorking;
    }

    public void setAcronymsWorking(String acronymsWorking) {
        this.acronymsWorking = acronymsWorking;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public List<Trimester> getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(List<Trimester> trimestre) {
        this.trimestre = trimestre;
    }

    public List<Schedule> getSchule() {
        return schule;
    }

    public void setSchule(List<Schedule> schule) {
        this.schule = schule;
    }

    public List<Availability> getaAvailability() {
        return aAvailability;
    }

    public void setaAvailability(List<Availability> aAvailability) {
        this.aAvailability = aAvailability;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (!Objects.equals(this.acronymsWorking, other.acronymsWorking)) {
            return false;
        }
        return true;
    }
    
    
    
}
