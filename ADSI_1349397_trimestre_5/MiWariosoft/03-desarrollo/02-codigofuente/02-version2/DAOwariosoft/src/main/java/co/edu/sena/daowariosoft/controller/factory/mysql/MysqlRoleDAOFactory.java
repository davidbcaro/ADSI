/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.RoleDAO;
import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlRoleDAO;
import co.edu.sena.daowariosoft.controller.factory.RoleDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlRoleDAOFactory implements RoleDAOFactory {

    
    @Override
    public RoleDAO create() {
        return new MysqlRoleDAO();
    }
    
}
