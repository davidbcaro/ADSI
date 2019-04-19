/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.EnvironmentDAO;
import co.edu.sena.controller.dao.mysql.EnvironmentDAOImpl;

/**
 *
 * @author 1349397
 */
public class EnvironmentFactory {
     public static  EnvironmentDAO create(Class entityClass) {
        return new EnvironmentDAOImpl(entityClass);
    }
}
