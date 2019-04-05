/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.EmailServerDao;
import co.edu.sena.cot.controlador.dao.mysql.EmailServerImpl;

/**
 *
 * @author Jorge
 */
public class EmailServerFactory {
    public static EmailServerDao create( Class entityClass){
        return new EmailServerImpl (entityClass);
    }
}
