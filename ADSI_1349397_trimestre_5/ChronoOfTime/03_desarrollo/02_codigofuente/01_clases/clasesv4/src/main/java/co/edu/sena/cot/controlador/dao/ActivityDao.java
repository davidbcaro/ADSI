/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Activity;
import co.edu.sena.cot.modelo.dto.ActivityPK;
import java.util.List;

/**
 *
 * @author 1349397
 * @param <T>
 */
public interface ActivityDao  <T extends Activity> extends InterfaceDao<T> {
    
    public List<T> findByName (String name);
    public List<T> findByIdActivity (String activity);
    public List<T> findByNamePhase (String namePhase);
    public List<T> findByCodeProject ( int codeProject);
    public List<T> findByLikeName (String name);
    public List<T> findByLikeIdActivity (String activity);
    public List<T> findByLikeNamePhase (String namePhase);
    public List<T> findByLikeCodeProject (String codeProject);
    public int updatePK(ActivityPK llaveNueva, ActivityPK llaveVieja);
    
}
