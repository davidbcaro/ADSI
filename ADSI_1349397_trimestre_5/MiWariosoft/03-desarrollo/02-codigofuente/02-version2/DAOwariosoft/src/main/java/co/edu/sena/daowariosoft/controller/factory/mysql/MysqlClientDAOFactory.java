/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.ClientDAO;
import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlClientDAO;
import co.edu.sena.daowariosoft.controller.factory.ClientDAOFactory;


/**
 *
 * @author Brayan
 */
public class MysqlClientDAOFactory implements ClientDAOFactory{

    @Override
    public ClientDAO create() {
        return new MysqlClientDAO();
    }
    
}
