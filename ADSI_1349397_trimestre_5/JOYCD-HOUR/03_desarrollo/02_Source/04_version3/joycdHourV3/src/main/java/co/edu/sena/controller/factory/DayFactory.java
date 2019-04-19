/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.DayDAO;
import co.edu.sena.controller.dao.mysql.DayDAOImpl;

/**
 *
 * @author liosalfar
 */
public class DayFactory {
        public static DayDAO create(Class entityClass){
        return new DayDAOImpl(entityClass);
    }
}
