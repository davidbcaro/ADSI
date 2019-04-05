/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlTrimesterDAO;
import co.edu.sena.chronooftimedao.controlador.dao.TrimesterDAO;
import co.edu.sena.chronooftimedao.controlador.factory.TrimesterDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlTrimesterDaoFactory implements TrimesterDAOFactory {

    @Override
    public TrimesterDAO create() {
        return new MysqlTrimesterDAO();
    }
    
}
