/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.NumberGroupDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.NumberGroupImpl;

/**
 *
 * @author 1349397
 */
public class NumberGroupFactory {
      public static NumberGroupDAO create(Class entityClass){
        return new NumberGroupImpl (entityClass);
    }
    
}
