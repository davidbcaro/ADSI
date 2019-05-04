/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.DisponibilityDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.DisponibilityDaoImpl;

/**
 *
 * @author JulianC
 */
public class DisponibilityFactory {
    
    public static DisponibilityDao create(Class entityClass){
        return new DisponibilityDaoImpl(entityClass);
    }
    
}
