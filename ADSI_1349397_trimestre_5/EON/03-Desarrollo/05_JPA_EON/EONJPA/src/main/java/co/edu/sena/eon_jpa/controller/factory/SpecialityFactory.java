/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.SpecialityDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.SpecialityDaoImpl;

/**
 *
 * @author Liliana Narvaez
 */
public class SpecialityFactory {
    public static SpecialityDao create(Class entityClass){
        return new SpecialityDaoImpl(entityClass);
    }
}
