/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao;

import co.edu.sena.eon_jpa.model.jpa.entities.Headquarters;
import java.util.List;

/**
 *
 * @author Telegrafia01
 * @param <H>
 */
public interface HeadquartersDao <H extends Headquarters> extends InterfaceDao<H>{
    List <H>findByNameHeadquarters(String name);
    List <H>findByLikeNameHeadquarters(String name);
    List <H>findByAddres(String addres);
    List <H>findByLikeAddres(String addres);
    List <H>findByState(Boolean state);
    public int updatePrimaryKey(String nuevoHeadquadters ,String viejoHeadquarters);
}
