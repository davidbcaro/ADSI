/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.MailServerDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.MailServerDaoImpl;

/**
 *
 * @author 1349397
 */
public class MailServerFactory {
    public static MailServerDao create(Class entityClass) {
        return new MailServerDaoImpl(entityClass);
    }
}
