/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Rol;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface RolDao<T extends Rol> extends InterfaceDao<T> {

    public List<T> findByIdRol(String idRol);

    public List<T> findByDescription(String description);

    public List<T> findByState(boolean state);

    public List<T> findByLikeIdRol(String idRol);

    public List<T> findByLikeDescription(String description);
    
    public int updatePK(String llaveNueva, String llaveVieja);

}
