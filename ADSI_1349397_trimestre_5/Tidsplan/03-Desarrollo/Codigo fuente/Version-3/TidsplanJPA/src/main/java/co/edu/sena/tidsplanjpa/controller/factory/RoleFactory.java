/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.RoleDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.RoleDaoImpl;

/**
 *
 * @author 1349397
 */
public class RoleFactory {
    public static RoleDao create(Class entityClass){
        return new RoleDaoImpl(entityClass);
    }
}
    

