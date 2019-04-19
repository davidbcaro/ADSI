/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.StatusGroupNumberDAO;
import co.edu.sena.controller.dao.mysql.StatusGroupNumberDAOImpl;


/**
 *
 * @author 1349397
 */
public class StatusGroupNumberFactory {
    public static StatusGroupNumberDAO create (Class entityClass){
     return new StatusGroupNumberDAOImpl(entityClass);
    }
    
}
