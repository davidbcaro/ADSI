/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.ActualityTrimesterDAO;
import co.edu.sena.controller.dao.mysql.ActualityTrimesterDAOImpl;

/**
 *
 * @author 1349397
 */
public class ActualityTrimesterFactory {

    public static ActualityTrimesterDAO create(Class entityClass) {
        return new ActualityTrimesterDAOImpl(entityClass);
    }
}
