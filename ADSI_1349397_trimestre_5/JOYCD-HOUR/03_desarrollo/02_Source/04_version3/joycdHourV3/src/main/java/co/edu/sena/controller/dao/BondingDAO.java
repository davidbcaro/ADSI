/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Bonding;
import java.util.List;

/**
 *
 * @author 1349397
 */
public interface BondingDAO <T extends Bonding> extends InterfaceDao<T>{
    // campos de la tabla
    public List<Bonding> findByTypeBonding(String typebonding);
    public List<Bonding> findByHours(int hours);
    public List<Bonding> findByStatus(boolean status);
    
    //campos de la tabla que no son boolean
    public List<Bonding> findByLikeTypeBonding(String typebonding);
    public List<Bonding> findByLikeHours(String hours);
    //campos que son llaves primarias
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
    
}
