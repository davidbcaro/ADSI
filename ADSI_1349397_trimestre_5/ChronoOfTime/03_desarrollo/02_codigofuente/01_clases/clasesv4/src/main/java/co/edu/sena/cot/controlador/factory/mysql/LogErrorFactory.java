/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.LogErrorDao;
import co.edu.sena.cot.controlador.dao.mysql.LogErrorImpl;

/**
 *
 * @author 1349397
 */
public class LogErrorFactory {
    
    public static LogErrorDao create(Class entityClass){
         return new LogErrorImpl(entityClass);
    }
    
}
