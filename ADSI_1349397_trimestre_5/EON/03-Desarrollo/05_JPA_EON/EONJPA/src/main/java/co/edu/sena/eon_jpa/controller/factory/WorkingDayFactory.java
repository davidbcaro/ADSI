/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.WorkingDayDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.WorkingDayImpl;

/**
 *
 * @author Telegrafia01
 */
public class WorkingDayFactory {

    public static WorkingDayDao create(Class entityClass) {
        return new WorkingDayImpl(entityClass);

    }

}
