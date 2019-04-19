/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.ActivityDAO;
import co.edu.sena.controller.dao.mysql.ActivityDAOImpl;

/**
 *
 * @author Chritian
 */
public class ActivityFactory {
    public static  ActivityDAO create(Class entityClass) {
        return new ActivityDAOImpl(entityClass);
    }
}
