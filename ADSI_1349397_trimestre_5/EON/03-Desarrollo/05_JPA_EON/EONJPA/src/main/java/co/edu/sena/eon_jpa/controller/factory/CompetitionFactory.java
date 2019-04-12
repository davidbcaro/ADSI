/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.CompetitionDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.CompetitionDaoImpl;

/**
 *
 * @author LUISBERNARDO
 */
public class CompetitionFactory {
    public static CompetitionDao create(Class entityClass){
        return new CompetitionDaoImpl(entityClass);
    }
}
