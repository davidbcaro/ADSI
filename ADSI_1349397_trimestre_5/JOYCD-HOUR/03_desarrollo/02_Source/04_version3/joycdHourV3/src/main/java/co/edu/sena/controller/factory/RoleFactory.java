/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.RoleDAO;
import co.edu.sena.controller.dao.mysql.RoleDAOImpl;

/**
 *
 * @author Usser
 */
public class RoleFactory {
     public static RoleDAO create(Class entityClass){
        return new RoleDAOImpl(entityClass);
    }
}
