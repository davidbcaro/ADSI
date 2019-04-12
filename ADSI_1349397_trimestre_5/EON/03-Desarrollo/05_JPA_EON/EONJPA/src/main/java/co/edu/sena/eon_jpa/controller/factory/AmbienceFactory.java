/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.AmbienceDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.AmbienceImpl;

/**
 *
 * @author SOPORTE
 */
public class AmbienceFactory {

    public static AmbienceDao create(Class entityClass) {
        return new AmbienceImpl(entityClass);
    }
}
