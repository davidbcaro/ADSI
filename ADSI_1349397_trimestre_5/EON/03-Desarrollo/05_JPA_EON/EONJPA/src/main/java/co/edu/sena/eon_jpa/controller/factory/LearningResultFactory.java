/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.LearningResultDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.LearningResultDaoImpl;

/**
 *
 * @author LUISBERNARDO
 */
public class LearningResultFactory {
    public static LearningResultDao create(Class entityClass) {
        return new LearningResultDaoImpl(entityClass);
    }
}
