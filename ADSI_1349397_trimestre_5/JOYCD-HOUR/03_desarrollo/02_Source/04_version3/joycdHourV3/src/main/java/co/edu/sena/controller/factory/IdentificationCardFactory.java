/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.IdentificationCardDAO;
import co.edu.sena.controller.dao.mysql.IdentificationCardDAOImpl;

/**
 *
 * @author 1349397
 */
public class IdentificationCardFactory {
    public static IdentificationCardDAO create(Class entityClass){
        return new IdentificationCardDAOImpl(entityClass);
    }
    
}
