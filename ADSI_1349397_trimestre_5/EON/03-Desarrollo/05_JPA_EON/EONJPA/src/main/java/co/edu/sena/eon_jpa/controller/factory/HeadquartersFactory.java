/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.HeadquartersDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.HeadquartersImpl;

/**
 *
 * @author Telegrafia01
 */
public class HeadquartersFactory {
    public static HeadquartersDao create(Class entityClass) {
        return new HeadquartersImpl(entityClass);
    }
    
}
