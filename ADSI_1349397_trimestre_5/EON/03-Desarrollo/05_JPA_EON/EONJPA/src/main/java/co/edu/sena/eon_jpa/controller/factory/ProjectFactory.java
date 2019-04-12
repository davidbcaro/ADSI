/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.ProjectDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.ProjectDaoImpl;

/**
 *
 * @author 1349397
 */
public class ProjectFactory {
    public static ProjectDao create(Class entityClass){
        return new ProjectDaoImpl(entityClass);
    }
}
