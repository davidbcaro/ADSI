/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.FichaDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.FichaImpl;

/**
 *
 * @author SOPORTE
 */
public class FichaFactory {
    
        public static FichaDao create(Class entityClass) {
        return new FichaImpl(entityClass);
    }
    
}
