/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.NumberGroupDao;
import co.edu.sena.cot.controlador.dao.mysql.NumberGroupImpl;

/**
 *
 * @author 1349397
 */
public class NumberGroupFactory {
    
    public static NumberGroupDao create(Class entityClass){
        return (NumberGroupDao) new NumberGroupImpl(entityClass);
    }
    
}
