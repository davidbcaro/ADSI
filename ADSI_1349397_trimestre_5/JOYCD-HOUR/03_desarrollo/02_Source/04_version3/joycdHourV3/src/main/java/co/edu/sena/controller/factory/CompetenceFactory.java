/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.CompetenceDAO;
import co.edu.sena.controller.dao.mysql.CompetenceDAOImpl;

/**
 *
 * @author 1349397
 */
public class CompetenceFactory {
         public static CompetenceDAO create(Class entityClass){
        return new CompetenceDAOImpl(entityClass);
    }
}
