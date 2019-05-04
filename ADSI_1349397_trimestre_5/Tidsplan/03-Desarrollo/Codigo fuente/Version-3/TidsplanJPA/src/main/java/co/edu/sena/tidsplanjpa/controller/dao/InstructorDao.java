/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Instructor;
import co.edu.sena.tidsplanjpa.model.jpa.entities.InstructorPK;
import java.util.List;



/**
 *
 * @author MIHOGAR
 */
public interface InstructorDao <T extends Instructor> extends InterfaceDao<T> {
  public List<T> findByTypeEmploymentRelationship(String typeEmploymentRelationship);
    public List<T> findByLikeTypeEmploymentRelationship(String typeEmploymentRelationship);
    public List<T> findByNameSpeciality(String nameSpeciality);
    public List<T> findByLikeNameSpeciality(String nameSpeciality);
    public List<T> findByDocumentNumber(String documentNumber);
    public List<T> findByLikeDocumentNumber(String documentNumber);
    public List<T> findByDocument(String document);
    public List<T> findByLikeDocument(String document);
    public int updatePrimaryKey(InstructorPK newKey, InstructorPK oldKey);
       
}
