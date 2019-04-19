/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.WorkingDayDAO;
import co.edu.sena.controller.dao.mysql.WorkingDayDAOImpl;

/**
 *
 * @author 1349397
 */
public class WorkingDayFactory {

    public static WorkingDayDAO create(Class entityClass) {
        return new WorkingDayDAOImpl(entityClass);
    }
}
