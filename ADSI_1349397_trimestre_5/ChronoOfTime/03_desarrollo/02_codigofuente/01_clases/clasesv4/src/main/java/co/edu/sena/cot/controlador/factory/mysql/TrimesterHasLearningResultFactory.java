/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.TrimesterHasLearningResultDao;
import co.edu.sena.cot.controlador.dao.mysql.TrimesterHasLearningResultImpl;

/**
 *
 * @author Jorge
 */
public class TrimesterHasLearningResultFactory {
    public static TrimesterHasLearningResultDao create(Class entityClass){
        return new TrimesterHasLearningResultImpl(entityClass);
    }
}
