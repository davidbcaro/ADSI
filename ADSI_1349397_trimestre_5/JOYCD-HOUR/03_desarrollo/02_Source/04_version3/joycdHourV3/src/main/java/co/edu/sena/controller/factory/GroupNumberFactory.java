/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.GroupNumberDAO;
import co.edu.sena.controller.dao.mysql.GroupNumberDAOImpl;

/**
 *
 * @author 1349397
 */
public class GroupNumberFactory {
     public static GroupNumberDAO create(Class entityClass) {
        return new GroupNumberDAOImpl(entityClass);
    }
}
