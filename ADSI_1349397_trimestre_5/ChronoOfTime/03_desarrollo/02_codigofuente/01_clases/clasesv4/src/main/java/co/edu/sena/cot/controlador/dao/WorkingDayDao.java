/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.WorkingDay;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface WorkingDayDao<T extends WorkingDay> extends InterfaceDao<T> {
    
    public List<T> findByInitials(String initials);
    public List<T> findByName (String  name);
    public List<T> findByDescription (String description);
    public List<T> findByLikeInitials (String initials);
    public List<T> findByLikeName (String name);
    public List<T> findByLikeDescription (String description);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
    
}
