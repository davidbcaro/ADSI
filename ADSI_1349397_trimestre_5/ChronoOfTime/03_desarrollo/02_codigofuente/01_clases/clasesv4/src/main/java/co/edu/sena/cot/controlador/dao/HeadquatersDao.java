/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Headquaters;
import java.util.List;

/**
 *
 * @author Natsumi
 */
public interface HeadquatersDao <T extends Headquaters> extends InterfaceDao<T>  {
    
    public List <T> findByNameHead (String name);
    public List <T> findByDirection (String direction);
    public List <T> findByState (boolean state);
    public List <T> findByNumberEnviroment (int numberEnviroment);
    public List <T> findByLikeNameHead (String name);
    public List <T> findByLikeDirection (String direction);
    public List <T> findByLikeNumberEnviroment (int numberEnviroment);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
}
