/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Schedule;
import co.edu.sena.model.jpa.entities.SchedulePK;
import java.util.Date;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface ScheduleDAO <T extends Schedule> extends InterfaceDao <T>{
    // campos no null 
    public List <Schedule> findByHourStart   (String hourStart);
    public List <Schedule> findByHourEnd   (String hourEnd);
    public List <Schedule> findByScheduleFinish (Date scheduleFinish);
    // campos foraneos
    public List <Schedule> findByNameModality (String nameModality);
    
    // llaves foraneas
    
    public List <Schedule> findByVersion (int version);
    public List <Schedule> findByVersionActualityTrimester (String versionActualityTrimester);
    public List <Schedule> findByNumberEnvironment (String numberEnvironment);
    public List <Schedule> findByHeadquartersName (String headquartersName);
    public List <Schedule> findByNameDay (String nameDay);
    public List <Schedule> findByDocumentType (String documentType);
    public List <Schedule> findByIdentificationCardNumber (String identificationCardNumber);
    public List <Schedule> findByGroupsNumber (String groupsNumber);
    public List <Schedule> findByTrimesterName (String trimesterName);
    public List <Schedule> findByWorkingDayInitials (String workingDayInitials);
    public List <Schedule> findByLevelFormation (String levelFormation);
    
    // consulta like
    public List <Schedule> findByLikeHourStart   (String hourStart);
    public List <Schedule> findByLikeHourEnd   (String hourEnd);
    public List <Schedule> findByLikeScheduleFinish (Date scheduleFinish); // entero 
    // campos foraneos like
    public List <Schedule> findByLikeNameModality (String nameModality);
    
    // llaves foraneas like
    
    public List <Schedule> findByLikeVersion (String version); // entero
    public List <Schedule> findByLikeVersionActualityTrimester (String actualityTrimester);
    public List <Schedule> findByLikeNumberEnvironment (String numberEnvironment); //entero
    public List <Schedule> findByLikeHeadquartersName (String headquartersName);
    public List <Schedule> findByLikeNameDay (String nameDay);
    public List <Schedule> findByLikeDocumentType (String documentType);
    public List <Schedule> findByLikeIdentificationCardNumber (String identificationCardNumber);
    public List <Schedule> findByLikeGroupsNumber (String groupsNumber);
    public List <Schedule> findByLikeTrimesterName (String trimesterName); //entero
    public List <Schedule> findByLikeWorkingDayInitials (String workingDayInitials);
    public List <Schedule> findByLikeLevelFormation (String levelFormation);
    
    
    
    // update
    public int updatePrimaryKey (SchedulePK llaveNueva, SchedulePK llaveVieja);
    
    
    
    
}
