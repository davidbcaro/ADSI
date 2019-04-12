/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.CurrentQuarterDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.CurrentQuarterImpl;

/**
 *
 * @author Telegrafia01
 */
public class CurrentQuarterFactory {
    public static CurrentQuarterDao create(Class entityClass) {
        return new CurrentQuarterImpl(entityClass);
    }
}
