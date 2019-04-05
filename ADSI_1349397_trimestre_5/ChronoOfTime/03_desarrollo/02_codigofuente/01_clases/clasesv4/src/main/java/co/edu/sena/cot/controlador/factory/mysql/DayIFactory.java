/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.DayIDao;
import co.edu.sena.cot.controlador.dao.mysql.DayiDaoImpl;

/**
 *
 * @author Natsumi
 */
public class DayIFactory {

    public static DayIDao create(Class entityClass) {
        return new DayiDaoImpl(entityClass);

    }
}
