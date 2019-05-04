/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

import java.sql.Time;

/**
 *
 * @author 1349397
 */
public class Schedule {

    private Time startHour;
    private Time endHour;
    private int finalSchedule;
    private String nameModality;
    private GroupHasTrimester groupHasTrimester;
    private Version version;
    private Instructor instructor;
    private Enviroment enviroment;
    private Modality modality;
    private Day day;

    public String getNameModality() {
        return nameModality;
    }

    public void setNameModality(String nameModality) {
        this.nameModality = nameModality;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() {
        return endHour;
    }

    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }
    
    public int getFinalSchedule() {
        return finalSchedule;
    }

    public void setFinalSchedule(int finalSchedule) {
        this.finalSchedule = finalSchedule;
    }

    public GroupHasTrimester getGroupHasTrimester() {
        return groupHasTrimester;
    }

    public void setGroupHasTrimester(GroupHasTrimester groupHasTrimester) {
        this.groupHasTrimester = groupHasTrimester;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Enviroment getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(Enviroment enviroment) {
        this.enviroment = enviroment;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
    
    
}
