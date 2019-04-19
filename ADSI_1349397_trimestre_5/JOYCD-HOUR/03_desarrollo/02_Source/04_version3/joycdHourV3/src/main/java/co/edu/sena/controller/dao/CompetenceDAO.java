/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Competence;
import co.edu.sena.model.jpa.entities.CompetencePK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface CompetenceDAO<T extends Competence> extends InterfaceDao<T> {

    public List<Competence> findByCompetenceCode(String competenceCode);

    public List<Competence> findByDescription(String description);

    public List<Competence> findByProgramCode(String programCode);

    public List<Competence> findByVersion(String version);

    ////////////////// like
    
    public List<Competence> findByLikeCompetenceCode(String competenceCode);

    public List<Competence> findByLikeDescription(String description);

    public List<Competence> findByLikeProgramCode(String programCode);

    public List<Competence> findByLikeVersion(String version);
    
    public int updatePrimaryKey(CompetencePK llaveNueva, CompetencePK llaveVieja);
}
