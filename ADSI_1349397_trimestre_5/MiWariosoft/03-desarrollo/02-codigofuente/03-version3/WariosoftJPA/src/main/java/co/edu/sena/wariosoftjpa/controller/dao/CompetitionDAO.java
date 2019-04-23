/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao;

import co.edu.sena.wariosoftjpa.controller.dao.InterfaceDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Competition;
import co.edu.sena.wariosoftjpa.model.jpa.entities.CompetitionPK;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface CompetitionDAO <T extends Competition> extends InterfaceDAO<T>{
    public List<T> findByCode(String code);
    public List<T> findByDescription(String description);
    public List<T> findByLikeCode(String code);
    public List<T> findByProgramCode(String programCode);
    public List<T> findByProgramVersion(String programVersion);
    public List<T> findByLikeProgramCode(String programCode);
    public List<T> findByLikeProgramVersion(String programVersion);
    public int updatePk(CompetitionPK llaveNueva, CompetitionPK llaveVieja); 
    
}
