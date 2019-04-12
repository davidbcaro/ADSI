/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.controller.dao.InterfaceDao;
import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import co.edu.sena.eon_jpa.model.jpa.entities.InstructorPK;
import java.util.List;

/**
 *
 * @author Equipo
 */
public interface InstructorDao  <T extends Instructor> extends InterfaceDao<T> {
    
     
     public List<T> findByDocumentNumber(String documentNumber);
     
     public List<T> findByIdDocument(String idDocument);
     
     public List<T> findBySpecialityName(String specialityName);
     
     public List<T> findByTypeLinkage(String typeLinkage);
     
     public List<T> findByLikeDocumentNumber(String documentNumber);
     
     public List<T> findByLikeIdDocument(String idDocument);
     
     public List<T> findByLikeSpecialityName(String specialityName);
     
     public List<T> findByLikeTypeLinkage(String typeLinkage);

    public int UpdatePrimaryKey( InstructorPK newKey, InstructorPK oldKey);

}
