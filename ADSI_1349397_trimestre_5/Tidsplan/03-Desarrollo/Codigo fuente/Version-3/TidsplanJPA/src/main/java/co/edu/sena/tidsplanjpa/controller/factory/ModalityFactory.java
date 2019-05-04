/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.ModalityDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.ModalityDaoImpl;

/**
 *
 * @author JulianC
 */
public class ModalityFactory {
    
    public static ModalityDao create(Class entityClass){
        return new ModalityDaoImpl(entityClass);
    }
    
}
