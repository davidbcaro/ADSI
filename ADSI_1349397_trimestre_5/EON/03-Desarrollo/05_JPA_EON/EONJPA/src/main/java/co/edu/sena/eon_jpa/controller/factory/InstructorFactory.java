/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.InstructorDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.InstructorDaoImpl;

/**
 *
 * @author Equipo
 */
public class InstructorFactory {
    public static InstructorDao create(Class entityClass){
        return new InstructorDaoImpl(entityClass);
    }
}
