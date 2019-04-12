/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.StatusFichaDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.StatusFichaImpl;

/**
 *
 * @author SOPORTE
 */
public class StatusFichaFactory {

    public static StatusFichaDao create(Class entityClass) {
        return new StatusFichaImpl(entityClass);
    }
}
