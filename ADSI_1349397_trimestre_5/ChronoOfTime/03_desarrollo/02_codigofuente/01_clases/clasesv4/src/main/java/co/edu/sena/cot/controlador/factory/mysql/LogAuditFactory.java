/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.LogAuditDao;
import co.edu.sena.cot.controlador.dao.mysql.LogAuditDaoImpl;

/**
 *
 * @author 1349397
 */
public class LogAuditFactory {
    
    public static LogAuditDao create( Class entityClass){
        return new LogAuditDaoImpl(entityClass);
    }
}
