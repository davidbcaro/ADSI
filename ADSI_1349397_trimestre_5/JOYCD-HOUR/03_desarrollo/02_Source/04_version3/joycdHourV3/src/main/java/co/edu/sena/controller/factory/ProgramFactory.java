/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.ProgramDAO;
import co.edu.sena.controller.dao.mysql.ProgramDAOImpl;

/**
 *
 * @author liosalfar
 */
public class ProgramFactory {
        public static  ProgramDAO create(Class entityClass) {
        return new ProgramDAOImpl(entityClass);
    }
}
