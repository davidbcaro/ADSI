/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.SpecialityDAO;
import co.edu.sena.controller.dao.mysql.SpecialityDAOImpl;

/**
 *
 * @author 1349397
 */
public class SpecialityFactory {
    public static SpecialityDAO create(Class entityClass){
        return new SpecialityDAOImpl(entityClass);
    }
}
