/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao;

import co.edu.sena.cot.modelo.dto.Environment;
import java.util.List;


/**
 *
 * @author Natsumi
 */
public interface EnviromentDao <T extends Environment> extends InterfaceDao<T>{
    public List <T> findbyNumberEnviroment (int number);
    public List <T> findByState (boolean state);
    public List <T> findByDescription (String description);
    public List <T> findbyLikeNumberEnviroment (int number);
    public List <T> findByLikeState (boolean state);
    public List <T> findByLikeDescription (String description); 
    public int updatePrimaryKey(Integer llaveNueva, Integer llaveVieja);
    
}
