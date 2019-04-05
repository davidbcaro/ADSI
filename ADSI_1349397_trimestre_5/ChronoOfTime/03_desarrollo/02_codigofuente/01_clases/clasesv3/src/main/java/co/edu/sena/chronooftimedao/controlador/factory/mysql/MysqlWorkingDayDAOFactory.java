/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlWorkingDayDAO;
import co.edu.sena.chronooftimedao.controlador.dao.WorkingDayDAO;
import co.edu.sena.chronooftimedao.controlador.factory.WorkingDayDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlWorkingDayDAOFactory implements WorkingDayDAOFactory{
    
    @Override
    public WorkingDayDAO create() {
        return new MysqlWorkingDayDAO();
    }
}
