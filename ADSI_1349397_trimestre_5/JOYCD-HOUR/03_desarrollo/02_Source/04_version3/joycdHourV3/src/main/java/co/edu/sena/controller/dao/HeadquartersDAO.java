/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao;

import co.edu.sena.model.jpa.entities.Headquarters;
import java.util.List;

/**
 *
 * @author liosalfar
 */
public interface HeadquartersDAO <T extends Headquarters> extends InterfaceDao<T>{

    public List<Headquarters> findByNameHeadquarters(String nameHeadquarters);
    public List<Headquarters> findByDirection(String direction);
    public List<Headquarters> findByStatus(boolean status);
    public List<Headquarters> findByLikeHeadquarters(String nameHeadquarters);
    public List<Headquarters> findByLikeDirection(String direction); 
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
  
}

