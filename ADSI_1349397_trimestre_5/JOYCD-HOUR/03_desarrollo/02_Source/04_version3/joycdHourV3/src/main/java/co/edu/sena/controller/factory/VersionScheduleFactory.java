/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.VersionScheduleDAO;
import co.edu.sena.controller.dao.mysql.VersionScheduleDAOImpl;

/**
 *
 * @author PCK
 */
public class VersionScheduleFactory {
     public static VersionScheduleDAO create(Class entityClass){
        return new VersionScheduleDAOImpl(entityClass);
}
}
