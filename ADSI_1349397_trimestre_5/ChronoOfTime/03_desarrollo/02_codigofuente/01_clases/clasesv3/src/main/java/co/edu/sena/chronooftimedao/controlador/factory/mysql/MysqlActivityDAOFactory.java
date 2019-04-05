/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.ActivityDAO;
import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlActivityDAO;
import co.edu.sena.chronooftimedao.controlador.factory.ActivityDAOFactory;

/**
 *
 * @author Jorge
 */
public class MysqlActivityDAOFactory implements ActivityDAOFactory {
    @Override
    public ActivityDAO create() {
        return new MysqlActivityDAO();
    }
}
