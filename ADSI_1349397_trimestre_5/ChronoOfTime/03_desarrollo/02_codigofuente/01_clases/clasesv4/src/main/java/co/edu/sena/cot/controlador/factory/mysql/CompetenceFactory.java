/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.CompetenceDao;
import co.edu.sena.cot.controlador.dao.mysql.CompetenceDaoImpl;

/**
 *
 * @author 1349397
 */
public class CompetenceFactory {
    
        public static CompetenceDao create(Class entityClass){
        return new CompetenceDaoImpl(entityClass);
    }
    
}
