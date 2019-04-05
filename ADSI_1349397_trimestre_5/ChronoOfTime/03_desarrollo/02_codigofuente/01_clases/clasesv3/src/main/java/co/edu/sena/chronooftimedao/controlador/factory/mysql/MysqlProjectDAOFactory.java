/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.factory.mysql;

import co.edu.sena.chronooftimedao.controlador.dao.ProjectDAO;
import co.edu.sena.chronooftimedao.controlador.dao.mysql.MysqlProjectDAO;
import co.edu.sena.chronooftimedao.controlador.factory.ProjectDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlProjectDAOFactory implements ProjectDAOFactory {

    @Override
    public ProjectDAO create() {
        return new MysqlProjectDAO();
    }

}
