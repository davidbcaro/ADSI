/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.PhaseDAO;
import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlPhaseDAO;

import co.edu.sena.daowariosoft.controller.factory.PhaseDAOFactory;


/**
 *
 * @author SENA
 */
public class MysqlPhaseDAOFactory implements PhaseDAOFactory {

    @Override
    public PhaseDAO create() {
        return new MysqlPhaseDAO();
    }
    
}
