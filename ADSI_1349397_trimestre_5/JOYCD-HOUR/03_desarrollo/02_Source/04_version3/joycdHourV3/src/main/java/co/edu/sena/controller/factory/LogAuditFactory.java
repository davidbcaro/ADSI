/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.LogAuditDAO;
import co.edu.sena.controller.dao.mysql.LogAuditDAOImpl;

/**
 *
 * @author liosalfar
 */
public class LogAuditFactory {
    
    public static LogAuditDAO create(Class entityClass) {
        return new LogAuditDAOImpl(entityClass);
    }
}
