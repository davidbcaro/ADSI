/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.PhaseDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.PhaseDaoImpl;

/**
 *
 * @author 1349397
 */
public class PhaseFactory {
    public static PhaseDao create(Class entityClass){
        return new PhaseDaoImpl(entityClass);
    }
}
