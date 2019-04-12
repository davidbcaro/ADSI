/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Activity;
import co.edu.sena.eon_jpa.model.jpa.entities.ActivityPK;
import java.util.List;

/**
 *
 * @author LUISBERNARDO
 * @param <a>
 */
public interface ActivityDao <a extends Activity> extends InterfaceDao<a>{
    public List<a> findByIdActivity(int id_Activity);
    public List<a> findByName(String Name);
    public List<a> findByNamePhase(String name_phase);
    public List<a> findByCode(String Code);
    public List<a> findByLikeName(String Name);
    public List<a> findByLikeNamePhase(String name_phase);
    public List<a> findByLikeCode(String Code);
    public int updatePrimaryKey(ActivityPK llaveNueva, ActivityPK llaveVieja);
}
