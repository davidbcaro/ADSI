/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.TrimesterTerm;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface TrimesterTermDao <T extends TrimesterTerm> extends InterfaceDao<T> {
   
    public List <T> findByIdTrimester (int trimester);
    public List <T> findByStartDate (Date   startDate);
    public List <T> findByEndDate (Date endDate);
    
    public List <T> findByLikeIdTrimester (int trimester);
    public List <T> findByLikeStartDate (Date   startDate);
    public List <T> findByLikeEndDate (Date endDate);
    
    
}
