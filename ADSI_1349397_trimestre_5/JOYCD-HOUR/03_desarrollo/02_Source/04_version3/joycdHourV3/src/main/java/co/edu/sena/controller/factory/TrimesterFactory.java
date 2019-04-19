/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.TrimesterDAO;
import co.edu.sena.controller.dao.mysql.TrimesterDAOImpl;

/**
 *
 * @author 1349397
 */
public class TrimesterFactory {
      public static TrimesterDAO create(Class entityClass){
        return new TrimesterDAOImpl(entityClass);
    }
    
    
}
