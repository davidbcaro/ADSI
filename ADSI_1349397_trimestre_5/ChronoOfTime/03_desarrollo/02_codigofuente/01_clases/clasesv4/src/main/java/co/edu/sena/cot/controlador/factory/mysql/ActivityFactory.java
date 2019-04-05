/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.ActivityDao;
import co.edu.sena.cot.controlador.dao.mysql.ActivityDaoImpl;

/**
 *
 * @author 1349397
 */
public class ActivityFactory {
    
    public static ActivityDao create(Class entityClass){
        return new ActivityDaoImpl(entityClass);
    }
    
}
