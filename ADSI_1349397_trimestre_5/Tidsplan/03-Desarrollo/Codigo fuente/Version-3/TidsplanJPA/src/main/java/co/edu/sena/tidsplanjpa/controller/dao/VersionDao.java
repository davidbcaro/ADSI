/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao;

import co.edu.sena.tidsplanjpa.model.jpa.entities.Version;
import co.edu.sena.tidsplanjpa.model.jpa.entities.VersionPK;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface VersionDao  <T extends Version> extends InterfaceDao<T>{
    public List<T> findByIdVersion(int idVersion);
    public List<T> findByLikeIdVersion(int idVersion);
    public List<T> findByIdTrimesterCurrent(String idTrimesterCurrent);
    public List<T> findByLikeIdTrimesterCurrent(String idTrimesterCurrent);
    public List<T> findByStatus(Boolean status);
    public int updatePrimaryKey(VersionPK newKey, VersionPK oldKey);
    
}
