/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;


import co.edu.sena.cot.modelo.dto.Instructor;
import co.edu.sena.cot.modelo.dto.InstructorPK;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface InstructorDao <T extends Instructor> extends InterfaceDao<T> {
  
    public List <T> findBySpecialityName (String specialityName);
    public List <T> findByTypeLink (String typeLink);
    public List <T> findByNumberDocument (int number);
    public List <T> findByDocument (String document);
    public List <T> findByLikeSpecialityName (String specialityName);
    public List <T> findByLikeTypeLink (String typeLink);
    public List <T> findByLikeNumberDocument (String number);
    public List <T> findByLikeDocument (String document);
    public int updatePrimaryKey(InstructorPK llaveNueva, InstructorPK llaveVieja);
   
}
