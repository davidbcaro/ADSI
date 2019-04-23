/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.WorkingDayDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.WorkingDayImpl;
import co.edu.sena.wariosoftjpa.model.jpa.entities.WorkingDay;

/**
 *
 * @author 1349397
 */
public class WorkingDayFactory {

    public static WorkingDayDAO create(Class entityClass) {
        return new WorkingDayImpl(entityClass);
    }

}
