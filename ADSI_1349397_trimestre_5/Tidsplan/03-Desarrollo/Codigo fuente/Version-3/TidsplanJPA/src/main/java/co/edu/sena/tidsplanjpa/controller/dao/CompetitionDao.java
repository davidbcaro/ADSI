/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;


import co.edu.sena.tidsplanjpa.model.jpa.entities.ActivityPK;
import co.edu.sena.tidsplanjpa.model.jpa.entities.Competition;
import co.edu.sena.tidsplanjpa.model.jpa.entities.CompetitionPK;

import java.util.List;

/**
 *
 * @author 1349397
 */
public interface CompetitionDao <T extends Competition> extends InterfaceDao<T>{
    public List<T> findByLikeCode(String code);
    public List<T> findByLikeDescription(String description);
    public List<T> findByLikeProgramCode(String programCode);
    public List<T> findByLikeProgramVersion(String programVersion);
    public List<T> findByCode(String code);
    public List<T> findByDescription(String description);
    public List<T> findByProgramCode(String programCode);
    public List<T> findByProgramVersion(String programVersion);
    public int updatePrimaryKey(CompetitionPK newKey, CompetitionPK oldKey);
    
}
