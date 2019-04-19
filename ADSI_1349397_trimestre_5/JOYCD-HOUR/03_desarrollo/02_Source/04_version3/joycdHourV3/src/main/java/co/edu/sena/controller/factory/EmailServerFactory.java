/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.EmailServerDAO;
import co.edu.sena.controller.dao.mysql.EmailServerDAOImpl;

/**
 *
 * @author liosalfar
 */
public class EmailServerFactory {

    public static EmailServerDAO create(Class entityClass) {
        return new EmailServerDAOImpl(entityClass);
    }
}
