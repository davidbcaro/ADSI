/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Version;
import co.edu.sena.eon_jpa.model.jpa.entities.VersionPK;
import java.util.List;

/**
 *
 * @author SOPORTE
 * @param 
 */
public interface VersionDao<V extends Version> extends InterfaceDao<V>  {
    
    public List<V> findByIdCurrentQuarter(String idCurrentQuarter);

    public List<V> findByIdVersion(int idVersion);

    public List<V> findByActive(Boolean active);

    public List<V> findByLikeIdCurrentQuarter(String idCurrentQuarter);

    public List<V> findByLikeIdVersion(int idVersion);

    public int updatePrimaryKey(VersionPK llavevieja, VersionPK llavenueva);
    
}
