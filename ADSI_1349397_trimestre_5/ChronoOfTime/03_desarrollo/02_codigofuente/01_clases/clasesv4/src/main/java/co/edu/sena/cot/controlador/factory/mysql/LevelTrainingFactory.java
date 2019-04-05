/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.LevelTrainingDao;
import co.edu.sena.cot.controlador.dao.mysql.LevelTrainingImpl;

/**
 *
 * @author 1349397
 */
public class LevelTrainingFactory {
    public static LevelTrainingDao create(Class entityClass){
        return new LevelTrainingImpl(entityClass);
    }
}
