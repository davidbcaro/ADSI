/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.LearningResult;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResultPK;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 * @param <l>
 */
public interface LearningResultDao <l extends LearningResult> extends InterfaceDao<l>{
    public List<l> findByCode(String Code);
    public List<l> findByDescription(String Description);
    public List<l> findByCompetitionCode(String Competition_Code);
    public List<l> findByProgramCode(String Program_Code);
    public List<l> findByVersion(String Version);
    public List<l> findByLikeCode(String Code);
    public List<l> findByLikeDescription(String Description);
    public List<l> findByLikeCompetitionCode(String Competition_Code);
    public List<l> findByLikeProgramCode(String Program_Code);
    public List<l> findByLikeVersion(String Version);
    public int updatePrimaryKey(LearningResultPK llaveNueva, LearningResultPK llaveVieja);   
    
}
