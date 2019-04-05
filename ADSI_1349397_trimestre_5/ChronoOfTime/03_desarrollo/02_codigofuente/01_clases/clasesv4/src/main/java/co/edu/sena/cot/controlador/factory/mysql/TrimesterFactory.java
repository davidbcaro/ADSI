/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.TrimesterDao;
import co.edu.sena.cot.controlador.dao.mysql.TrimesterImpl;

/**
 *
 * @author Jorge
 */
public class TrimesterFactory {
        public static TrimesterDao create(Class entityClass){
        return new TrimesterImpl(entityClass);
    }
}
