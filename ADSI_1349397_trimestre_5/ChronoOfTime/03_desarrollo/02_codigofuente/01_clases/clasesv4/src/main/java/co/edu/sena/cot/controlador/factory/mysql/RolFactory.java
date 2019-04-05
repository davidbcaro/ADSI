/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.RolDao;
import co.edu.sena.cot.controlador.dao.mysql.RolDaoImpl;

/**
 *
 * @author Natsumi
 */
public class RolFactory {
     public static RolDao create(Class entityClass){
     return new RolDaoImpl(entityClass);
     }
}
