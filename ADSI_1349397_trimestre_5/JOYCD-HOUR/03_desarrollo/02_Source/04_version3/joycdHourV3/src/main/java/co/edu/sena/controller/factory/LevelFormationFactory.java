/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.LevelFormationDAO;
import co.edu.sena.controller.dao.mysql.LevelFormationDAOImpl;

/**
 *
 * @author Chritian
 */
public class LevelFormationFactory {
     public static LevelFormationDAO create(Class entityClass){
        return new LevelFormationDAOImpl(entityClass);
    }
}
