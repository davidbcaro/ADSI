/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.util.List;

/**
 *
 * @author 1349397
 */
public class Instructor {
    private String nameSpeaciality;
    private String typeEmploymentRelationship;
    private Speciality speciality;
    private EmploymentRelationship employmentRelationship;
    private Customer customer;
    private List<Disponibility> disponibilitys;
    private List<Schedule> schedule;

    public String getNameSpeaciality() {
        return nameSpeaciality;
    }

    public void setNameSpeaciality(String nameSpeaciality) {
        this.nameSpeaciality = nameSpeaciality;
    }

    public String getTypeEmploymentRelationship() {
        return typeEmploymentRelationship;
    }

    public void setTypeEmploymentRelationship(String typeEmploymentRelationship) {
        this.typeEmploymentRelationship = typeEmploymentRelationship;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public EmploymentRelationship getEmploymentRelationship() {
        return employmentRelationship;
    }

    public void setEmploymentRelationship(EmploymentRelationship employmentRelationship) {
        this.employmentRelationship = employmentRelationship;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Disponibility> getDisponibilitys() {
        return disponibilitys;
    }

    public void setDisponibilitys(List<Disponibility> disponibilitys) {
        this.disponibilitys = disponibilitys;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
    
    
}
