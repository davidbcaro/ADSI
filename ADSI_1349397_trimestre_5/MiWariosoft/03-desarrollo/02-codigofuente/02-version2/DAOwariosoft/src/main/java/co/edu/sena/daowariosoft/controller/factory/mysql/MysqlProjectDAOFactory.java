/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;
import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlProjectDAO;
import co.edu.sena.daowariosoft.controller.dao.ProjectDAO;
import co.edu.sena.daowariosoft.controller.factory.ProjectDAOFactory;

/**
 *
 * @author SENA
 */
public class MysqlProjectDAOFactory  implements ProjectDAOFactory{

    @Override
    public ProjectDAO create() {
         return new MysqlProjectDAO();
    }
    
}
