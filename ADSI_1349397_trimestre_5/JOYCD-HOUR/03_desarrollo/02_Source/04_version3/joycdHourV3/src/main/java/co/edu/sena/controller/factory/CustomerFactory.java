/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.CustomerDAO;
import co.edu.sena.controller.dao.mysql.CustomerDAOImpl;


/**
 *
 * @author Usser
 */
public class CustomerFactory {
        public static CustomerDAO create (Class entityClass){        
        return new CustomerDAOImpl (entityClass);
    }
    
}
