/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import co.edu.sena.eon_jpa.model.jpa.entities.TrimesterPK;
import java.util.List;

/**
 *
 * @author Telegrafia01
 */
public interface TrimesterDao <T extends Trimester>extends InterfaceDao<T>{
   public List <T>findByQuarterName(String quarterName);
   public List <T>findByAcronymsWorkingDay(String acronymsWorkingDay);
   public List <T>findBySpecialityName(String specialityName);
   public List <T>findByLikeQuarterName(String quarterName);
   public List <T>findByLikeAcronymsWorkingDay(String acronymsWorkingDay);
   public List <T>findByLikeSpecialityName(String specialityName);
   public int updatePrimaryKey(TrimesterPK llaveNueva ,TrimesterPK llaveVieja);
   
    
}
