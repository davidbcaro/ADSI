/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.RoleDAO;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlRoleDAO;
import co.edu.sena.joycdhourdao.controlador.factory.RoleDAOFactory;


/**
 *
 * @author 1349397
 */
public class MysqlRoleDAOFactory implements RoleDAOFactory {

    @Override
    public RoleDAO create() {
       return new  MysqlRoleDAO();
    }
    
    
    
}
