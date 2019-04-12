/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.DayDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.DayImpl;

/**
 *
 * @author Telegrafia01
 */
public class DayFactory {
    
    
    public static DayDao create(Class entityClass) {
        return new DayImpl(entityClass);
    }
}
