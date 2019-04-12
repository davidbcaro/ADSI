/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.ModalityDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.ModalityImpl;

/**
 *
 * @author Telegrafia01
 */
public class ModalityFactory {
    public static ModalityDao create(Class entityClass) {
        return new ModalityImpl(entityClass);
    }
    
}
