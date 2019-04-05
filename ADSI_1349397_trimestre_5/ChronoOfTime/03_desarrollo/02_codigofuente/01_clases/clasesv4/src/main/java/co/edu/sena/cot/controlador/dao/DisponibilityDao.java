/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Disponibility;
import co.edu.sena.cot.modelo.dto.DisponibilityPK;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface DisponibilityDao<T extends Disponibility> extends InterfaceDao<T> {

    public List<T> findByStartDate(Date start);

    public List<T> findByEndDate(Date end);

    public List<T> findByNumberDocument(int number);

    public List<T> findByDocument(String document);

    public List<T> findByWorkDInitiasl(String initials);

    public List<T> findByNameDayi(String name);



    public List<T> findByLikeNumberDocument(String number);

    public List<T> findByLikeDocument(String document);

    public List<T> findByLikeWorkDInitiasl(String Initials);

    public List<T> findByLikeNameDayi(String name);
    
    public int updatePK(DisponibilityPK llaveNueva, DisponibilityPK llaveVieja);

   

    

}
