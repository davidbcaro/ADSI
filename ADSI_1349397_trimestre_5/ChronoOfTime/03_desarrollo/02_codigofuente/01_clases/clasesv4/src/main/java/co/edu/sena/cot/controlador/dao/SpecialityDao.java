/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Speciality;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface SpecialityDao<T extends Speciality> extends InterfaceDao<T> {

    public List<T> findByName(String name);

    public List<T> findByState(boolean state);

    public List<T> findByLikeName(String name);

    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
