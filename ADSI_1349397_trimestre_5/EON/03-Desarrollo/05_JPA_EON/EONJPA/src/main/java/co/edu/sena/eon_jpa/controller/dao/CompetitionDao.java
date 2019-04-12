/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Competition;
import co.edu.sena.eon_jpa.model.jpa.entities.CompetitionPK;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 * @param <c>
 */
public interface CompetitionDao <c extends Competition> extends InterfaceDao<c>{
    public List<c> findByCode(String Competition_code);
    public List<c> findByDescription(String description);
    public List<c> findByProgramCode(String Program_Code);
    public List<c> findByProgramVersion(String Version);
    public List<c> findByLikeCode(String Competition_code);
    public List<c> findByLikeDescription(String description);
    public List<c> findByLikeProgramCode(String Program_Code);
    public List<c> findByLikeProgramVersion(String Version);
    public int updatePrimaryKey(CompetitionPK llaveNueva, CompetitionPK llaveVieja);
}
