/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.TrimesterDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.TrimesterDaoImpl;

/**
 *
 * @author 1349397
 */
public class TrimesterFactory {
    public static TrimesterDao create(Class entityClass){
        return new TrimesterDaoImpl(entityClass);
    }
    
}
