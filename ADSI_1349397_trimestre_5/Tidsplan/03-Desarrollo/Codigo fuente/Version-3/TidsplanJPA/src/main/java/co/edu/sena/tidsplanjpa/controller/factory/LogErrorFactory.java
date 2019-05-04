/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.LogErrorDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.LogErrorDaoImpl;

/**
 *
 * @author MIHOGAR
 */
public class LogErrorFactory {
      
    
    public static LogErrorDao create(Class entityClass){
        return new LogErrorDaoImpl(entityClass);
    }
    
}
