/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Ficha;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface FichaDao <T extends Ficha> extends  InterfaceDao<T>{
    public List<T> findByLikeNumberGroup(String numberGroup);
    public List<T> findByNumberGroup(String numberGroup);
    public List<T> findByStartDate(Date startDate);
    public List<T> findByEndDate(Date endDate);
    public List<T> findByLikeRoute(String route);
    public List<T> findByRoute(String route);
    public List<T> findByNameState(String nameState);
    public List<T> findByLikeNameState(String nameState);
    public List<T> findByVersion(String version);
    public List<T> findByLikeVersion(String version);
    public List<T> findByProgramCode(String programCode);
    public List<T> findByLikeProgramCode(String programCode);
    public int updatePrimaryKey(String newKey, String oldKey);
    
}
