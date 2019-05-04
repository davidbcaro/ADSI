/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;

import co.edu.sena.tidsplanjpa.controller.dao.EmploymentRelationshipDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.EmploymentRelationshipDaoImpl;

/**
 *
 * @author MIHOGAR
 */
public class EmploymentRelationshipFactory {
     public static EmploymentRelationshipDao create(Class entityClass){
        return  new EmploymentRelationshipDaoImpl(entityClass);
    }
}
