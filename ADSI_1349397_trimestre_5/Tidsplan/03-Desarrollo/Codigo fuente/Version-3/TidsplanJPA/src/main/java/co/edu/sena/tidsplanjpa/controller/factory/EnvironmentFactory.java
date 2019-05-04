/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.EnvironmentDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.EnvironmentDaoImpl;

/**
 *
 * @author JulianC
 */
public class EnvironmentFactory {
    public static EnvironmentDao create(Class entityClass) {
        return new EnvironmentDaoImpl(entityClass);
    }
}
