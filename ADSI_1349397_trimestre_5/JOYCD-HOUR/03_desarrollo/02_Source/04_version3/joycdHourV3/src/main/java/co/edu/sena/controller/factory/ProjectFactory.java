/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.ProjectDAO;
import co.edu.sena.controller.dao.mysql.ProjectDaoImpl;

/**
 *
 * @author 1349397
 */
public class ProjectFactory {
      public static ProjectDAO create(Class entityClass){
        return new ProjectDaoImpl(entityClass);
    }
}
