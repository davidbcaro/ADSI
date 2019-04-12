/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.ProgramDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.ProgramDaoImpl;

/**
 *
 * @author LUISBERNARDO
 */
public class ProgramFactory {

    public static ProgramDao create(Class entityClass) {
        return new ProgramDaoImpl(entityClass);
    }
}
