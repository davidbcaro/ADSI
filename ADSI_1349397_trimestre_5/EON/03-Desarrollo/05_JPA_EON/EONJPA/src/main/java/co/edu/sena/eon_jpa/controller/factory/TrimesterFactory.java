/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.TrimesterDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.TrimesterImpl;

/**
 *
 * @author Telegrafia01
 */
public class TrimesterFactory {
     public static TrimesterDao create(Class entityClass) {
        return new TrimesterImpl(entityClass);
    }
    
}
