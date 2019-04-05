/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.LinkUp;
import java.util.List;

/**
 *
 * @author Natsumi
 * @param <T>
 */
public interface LinkUpDao<T extends LinkUp> extends InterfaceDao<T> {
    
  public List<T> findByTypeLink(String type);
    public List<T> findByHours(int hours);
    public List<T> findByState (boolean state);
    public List<T> findByLikeTypeLink (String name);
    public List<T> findByLikeHours (String hours);
    public int updatePK(String llaveNueva, String llaveVieja);  
}
