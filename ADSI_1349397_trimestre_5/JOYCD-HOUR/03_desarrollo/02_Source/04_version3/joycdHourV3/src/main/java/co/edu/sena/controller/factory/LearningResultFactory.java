/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.LearningResultDAO;
import co.edu.sena.controller.dao.mysql.LearningResultDAOImpl;

/**
 *
 * @author 1349397
 */
public class LearningResultFactory {
    public static LearningResultDAO create (Class EnitityClass){
    return new LearningResultDAOImpl(EnitityClass);
    
}
}