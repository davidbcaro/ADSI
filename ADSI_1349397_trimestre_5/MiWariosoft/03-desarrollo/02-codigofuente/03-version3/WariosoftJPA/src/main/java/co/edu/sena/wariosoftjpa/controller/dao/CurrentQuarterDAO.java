/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.CurrentQuarter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface CurrentQuarterDAO <T extends CurrentQuarter> extends InterfaceDAO<T>{
    public List<T> findByIdCurrentQuarter(String idCurrentQuarter);
    public List<T> findByStartDate(Date StartDate);
    public List<T> findByEndDate(Date endDate);
    public List<T> findByLikeIdCurrentQuarter(String idCurrentQuarter);
    public int updatePk(String llaveNueva, String llaveVieja);
    
}
