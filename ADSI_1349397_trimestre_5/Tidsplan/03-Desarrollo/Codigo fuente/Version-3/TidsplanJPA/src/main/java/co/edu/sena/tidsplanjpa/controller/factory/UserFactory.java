/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.UserDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.UserDaoImpl;

/**
 *
 * @author MIHOGAR
 */
public class UserFactory {
    public static UserDao create(Class entityClass){
        return new UserDaoImpl(entityClass);
    }
    
}
