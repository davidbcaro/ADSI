/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.EnvironmentDAO;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlEnvironmentDAO;
import co.edu.sena.joycdhourdao.controlador.factory.EnvironmentDAOFactory;

/**
 *
 * @author liosalfar
 */
public class MysqlEnvironmentDAOFactory implements EnvironmentDAOFactory{

    @Override
    public EnvironmentDAO create() {
        return new MysqlEnvironmentDAO();
    }
    
}
