/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.EnviromentDao;
import co.edu.sena.cot.controlador.dao.InstructorDao;
import co.edu.sena.cot.controlador.dao.mysql.EnviromentDaoImpl;
import co.edu.sena.cot.controlador.dao.mysql.InstructorDaoImpl;

/**
 *
 * @author 1349397
 */
public class InstructorFactory {
    public static InstructorDao create(Class EntityClass){
    return new InstructorDaoImpl(EntityClass);
    }
}
