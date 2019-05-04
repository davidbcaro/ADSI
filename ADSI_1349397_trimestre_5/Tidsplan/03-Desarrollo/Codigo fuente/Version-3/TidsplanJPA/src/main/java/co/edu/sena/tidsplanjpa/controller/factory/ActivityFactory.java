/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.ActivityDao;
import co.edu.sena.tidsplanjpa.controller.dao.TrimesterDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.ActivityDaoImpl;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.TrimesterDaoImpl;

/**
 *
 * @author 1349397
 */
public class ActivityFactory {
    public static ActivityDao create(Class entityClass){
        return new ActivityDaoImpl(entityClass);
    }
    
}
