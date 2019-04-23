/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.EnvironmentDAO;
import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlEnvironmentDAO;
import co.edu.sena.daowariosoft.controller.factory.EnvironmentDAOFactory;

/**
 *
 * @author WINDOWS 8
 */
public class MysqlEnvironmentDAOFactory implements EnvironmentDAOFactory {

    @Override
    public EnvironmentDAO create() {
        return new MysqlEnvironmentDAO();
    }
    
}
