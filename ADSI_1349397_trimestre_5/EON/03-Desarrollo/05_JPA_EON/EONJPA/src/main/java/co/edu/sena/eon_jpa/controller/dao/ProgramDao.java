/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Program;
import co.edu.sena.eon_jpa.model.jpa.entities.ProgramPK;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 * @param <p>
 */
public interface ProgramDao <p extends Program> extends InterfaceDao<p>{
   public List<p> findByCode(String Code);
   public List<p> findByVersion(String Version);
   public List<p> findByName(String Name);
   public List<p> findByInitials(String Initials);
   public List<p> findByState(boolean State);
   public List<p> findByTrainingLevel(String training_Level);
   public List<p> findByLikeCode(String Code);
   public List<p> findByLikeVersion(String Version);
   public List<p> findByLikeName(String Name);
   public List<p> findByLikeInitials(String Initials);
   public List<p> findByLikeTrainingLevel(String training_Level);
   public int updatePrimaryKey(ProgramPK llaveNueva, ProgramPK llaveVieja);   
}
