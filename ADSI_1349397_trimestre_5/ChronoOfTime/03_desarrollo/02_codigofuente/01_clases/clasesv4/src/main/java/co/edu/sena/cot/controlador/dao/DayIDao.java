/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Dayi;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface DayIDao<T extends Dayi> extends InterfaceDao<T> {
  
     public List<T> findByNameDayi(String name);

    public List<T> findByState(boolean state);

    public List<T> findByLikeName(String name);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
