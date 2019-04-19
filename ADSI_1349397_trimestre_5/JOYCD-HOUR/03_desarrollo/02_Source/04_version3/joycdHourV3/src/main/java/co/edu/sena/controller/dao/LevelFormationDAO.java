/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.LevelFormation;
import java.util.List;

/**
 *
 * @author Chritian
 */
public interface LevelFormationDAO  <T extends LevelFormation> extends InterfaceDao<T>{

    public List<LevelFormation> findByLevelFormation(String levelFormation);

    public List<LevelFormation> findByStatus(boolean status);

    public List<LevelFormation> findByLikeLevelFormation(String levelFormation);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);

}
