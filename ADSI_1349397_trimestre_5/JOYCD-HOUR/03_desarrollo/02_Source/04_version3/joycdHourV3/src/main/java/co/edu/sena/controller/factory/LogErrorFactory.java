/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.LogErrorDAO;
import co.edu.sena.controller.dao.mysql.LogErrorDAOImpl;

/**
 *
 * @author liosalfar
 */
public class LogErrorFactory {
        public static LogErrorDAO create(Class entityClass) {
        return new LogErrorDAOImpl(entityClass);
    }
}
