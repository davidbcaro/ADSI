/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.UserDAO;
import co.edu.sena.controller.dao.mysql.UserDAOImpl;

/**
 *
 * @author liosalfar
 */
public class UserFactory {
    
        public static UserDAO create (Class entityClass){        
        return new UserDAOImpl (entityClass);
    }
}
