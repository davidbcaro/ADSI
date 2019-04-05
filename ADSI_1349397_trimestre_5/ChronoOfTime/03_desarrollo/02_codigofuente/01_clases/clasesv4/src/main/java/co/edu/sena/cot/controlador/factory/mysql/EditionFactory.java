/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.EditionDao;
import co.edu.sena.cot.controlador.dao.mysql.EditionDaoImpl;

/**
 *
 * @author Jorge
 */
public class EditionFactory {
    public static EditionDao create( Class entityClass){
        return new EditionDaoImpl (entityClass);
    }
}
