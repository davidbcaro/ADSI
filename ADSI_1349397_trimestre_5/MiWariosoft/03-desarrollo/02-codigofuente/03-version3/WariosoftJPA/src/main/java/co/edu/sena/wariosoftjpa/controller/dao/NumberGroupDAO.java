/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroup;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface NumberGroupDAO <T extends NumberGroup> extends InterfaceDAO<T>{
    public List<T> findByNumberGroup(String numberGroup);
    public List<T> findByStartDate(Date startDate);
    public List<T> findByEndDate(Date endDate);
    public List<T> findByRoute(String route);
    public List<T> findByNameState(String nameState);
    public List<T> findByProgramCode(String programCode);
    public List<T> findByVersion(String version);
    public List<T> findByLikeNameState(String nameState);
    public List<T> findByLikeProgramCode(String programCode);
    public List<T> findByLikeVersion(String version);

    public int updatePk(String llaveNueva, String llaveVieja);
    
}
