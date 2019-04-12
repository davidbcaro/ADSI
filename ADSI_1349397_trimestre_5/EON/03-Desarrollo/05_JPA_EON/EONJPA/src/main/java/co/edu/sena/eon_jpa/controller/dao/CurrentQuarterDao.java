/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.CurrentQuarter;
import java.util.List;

/**
 *
 * @author Telegrafia01
 * @param <C>
 */
public interface CurrentQuarterDao <C extends CurrentQuarter>extends InterfaceDao<C>{
    List <C>findByIdCurrentQuarter(String idCurrentQuarter);
    List <C>findByLikeIdCurrentQuarter(String idCurrentQuarter);
    List <C>findByStartDate(String start);
    List <C>findByLikeStarDate(String start);
    List <C>findByEndDate(String end);
    List <C>findByLikeEndDate(String end);
    public int updatePrimaryKey(String nuevoidCurrentQuarter , String viejoidCurrentQuarter);
}
