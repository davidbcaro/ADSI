/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Trimester;
import co.edu.sena.model.jpa.entities.TrimesterPK;
import java.util.List;
/**
 *
 * @author 1349397
 */
public interface TrimesterDAO<T extends Trimester> extends InterfaceDao<T> {

    public List<Trimester> findByTrimesterName(String trimesterName);
    public List<Trimester> findByWorkingDayInitials(String workingDayInitials);
    public List<Trimester> findByLevelFormation(String levelFormation);

    public List<Trimester> findByLikeTrimesterName(String trimesterName);
    public List<Trimester> findByLikeWorkingDayInitials(String workingDayInitials);
    public List<Trimester> findByLikeLevelFormation(String levelFormation);
    public int updatePrimaryKey(TrimesterPK llaveNueva, TrimesterPK llaveVieja);
}
