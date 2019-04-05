/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.StateNumberGroupDao;
import co.edu.sena.cot.controlador.dao.mysql.StateNumberGroupImpl;

/**
 *
 * @author 1349397
 */
public class StateNumberGroupFactory {
    
    public static StateNumberGroupDao create(Class entityClass){
        return (StateNumberGroupDao) new StateNumberGroupImpl(entityClass);
    }
    
}
