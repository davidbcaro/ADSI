/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.factory;



import co.edu.sena.tidsplanjpa.controller.dao.CompetitionDao;
import co.edu.sena.tidsplanjpa.controller.dao.mysql.CompetitionDaoImpl;


/**
 *
 * @author 1349397
 */
public class CompetitionFactory {
    public static CompetitionDao create(Class entityClass){
        return new CompetitionDaoImpl(entityClass);
    }
    
}
