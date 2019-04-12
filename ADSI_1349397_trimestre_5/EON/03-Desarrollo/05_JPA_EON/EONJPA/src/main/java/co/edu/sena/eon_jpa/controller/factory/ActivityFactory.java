/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.ActivityDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.ActivityDaoImpl;

/**
 *
 * @author LUISBERNARDO
 */
public class ActivityFactory {
    public static ActivityDao create(Class entityClass){
        return new ActivityDaoImpl(entityClass);
    }
}
