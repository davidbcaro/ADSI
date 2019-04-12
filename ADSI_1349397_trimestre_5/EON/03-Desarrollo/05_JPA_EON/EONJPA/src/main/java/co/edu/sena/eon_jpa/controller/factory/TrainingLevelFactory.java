/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.TrainingLevelDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.TrainingLevelDaoImpl;

/**
 *
 * @author LUISBERNARDO
 */
public class TrainingLevelFactory {
    public static TrainingLevelDao create(Class entityClass){
        return new TrainingLevelDaoImpl(entityClass);
    }
    
}
