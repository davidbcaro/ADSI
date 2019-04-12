/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.factory.mysql;

import co.edu.sena.eondao.controller.dao.ProgramDAO;
import co.edu.sena.eondao.controller.dao.mysql.MysqlProgramDAO;
import co.edu.sena.eondao.controller.factory.ProgramDAOFactory;

/**
 *
 * @author LUISBERNARDO
 */
public class MysqlProgramDAOFactory implements ProgramDAOFactory{
    
    public ProgramDAO create(){
        return new MysqlProgramDAO();
    }
}
