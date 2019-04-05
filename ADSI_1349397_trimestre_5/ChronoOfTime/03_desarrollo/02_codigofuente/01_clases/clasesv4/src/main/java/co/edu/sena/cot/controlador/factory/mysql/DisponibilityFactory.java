/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.DisponibilityDao;
import co.edu.sena.cot.controlador.dao.mysql.DisponiblityDaoImpl;
import co.edu.sena.cot.controlador.dao.mysql.EmailServerImpl;

/**
 *
 * @author 1349397
 */
public class DisponibilityFactory {
    public static DisponibilityDao create( Class entityClass){
        return new DisponiblityDaoImpl (entityClass);
    } 
}
