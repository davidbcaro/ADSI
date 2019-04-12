/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.UserDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.UserDaoImpl;

/**
 *
 * @author Equipo
 */
public class UserFactory {
   
    public static UserDao create(Class entityClass) {
        return new UserDaoImpl(entityClass);
    }
}
