/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.ProjectDAO;
import co.edu.sena.joycdhourdao.controlador.factory.ProjectDAOFactory;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlProjectDAO;

/**
 *
 * @author 1349397
 */
public class MysqlProjectDAOFactory implements ProjectDAOFactory {

    @Override
    public ProjectDAO create() {
        return new  MysqlProjectDAO();
    }
    
}
