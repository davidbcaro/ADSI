/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.ScheduleDAO;
import co.edu.sena.controller.dao.mysql.ScheduleDAOImpl;

/**
 *
 * @author liosalfar
 */
public class ScheduleFactory {

    public static ScheduleDAO create(Class entityClass) {
        return new ScheduleDAOImpl(entityClass);
    }
}
