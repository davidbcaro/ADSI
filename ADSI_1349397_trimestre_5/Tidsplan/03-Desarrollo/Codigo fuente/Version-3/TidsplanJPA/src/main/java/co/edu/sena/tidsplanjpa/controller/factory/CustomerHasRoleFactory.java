/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.CustomerHasRoleDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.CustomerHasRoleDaoImpl;

/**
 *
 * @author MIHOGAR
 */
public class CustomerHasRoleFactory {
        public static CustomerHasRoleDao create(Class entityClass){
        return new CustomerHasRoleDaoImpl(entityClass);
    }
}
