/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.factory.mysql;

import co.edu.sena.eondao.controller.dao.mysql.MysqlTrainingLevelDAO;
import co.edu.sena.eondao.controller.dao.TrainingLevelDAO;
import co.edu.sena.eondao.controller.factory.TrainingLevelDAOFactory;

/**
 *
 * @author LUISBERNARDO
 */
public class MysqlTrainingLevelDAOFactory implements TrainingLevelDAOFactory{
    
    public TrainingLevelDAO create(){
        return new MysqlTrainingLevelDAO();
    }
    
}
