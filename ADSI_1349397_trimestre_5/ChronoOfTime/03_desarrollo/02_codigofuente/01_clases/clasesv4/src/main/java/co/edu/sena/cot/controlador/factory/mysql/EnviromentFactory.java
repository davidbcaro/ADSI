/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.EnviromentDao;
import co.edu.sena.cot.controlador.dao.mysql.EnviromentDaoImpl;

/**
 *
 * @author Natsumi
 */
public class EnviromentFactory {
    public static EnviromentDao create(Class EntityClass){
    return new EnviromentDaoImpl(EntityClass);
    }
}
