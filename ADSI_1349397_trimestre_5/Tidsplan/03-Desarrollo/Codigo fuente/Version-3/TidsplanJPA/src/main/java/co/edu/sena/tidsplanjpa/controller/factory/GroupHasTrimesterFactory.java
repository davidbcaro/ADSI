/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.GroupHasTrimesterDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.GroupHasTrimesterDaoImpl;



/**
 *
 * @author MIHOGAR
 */
public class GroupHasTrimesterFactory {
     public static GroupHasTrimesterDao create(Class entityClass){
        return  new GroupHasTrimesterDaoImpl(entityClass);
    }
}
