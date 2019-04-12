/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.factory.mysql;

import co.edu.sena.eondao.controller.dao.ProjectDAO;
import co.edu.sena.eondao.controller.dao.mysql.MysqlProjectDAO;
import co.edu.sena.eondao.controller.factory.ProjectDAOFactory;



public class MysqlProjectDAOFactory implements ProjectDAOFactory {  
   public ProjectDAO create(){
        return new  MysqlProjectDAO();
    }
}

