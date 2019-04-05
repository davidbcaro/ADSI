/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.LinkUpDao;
import co.edu.sena.cot.controlador.dao.mysql.LinkUpDaoImpl;

/**
 *
 * @author Natsumi
 */
public class LinkUpFactory {
   
    public static LinkUpDao create(Class entityClass){
        return new LinkUpDaoImpl(entityClass);
    }
}
