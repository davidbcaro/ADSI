/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlCurrentQuarterDAO;
import co.edu.sena.daowariosoft.controller.dao.CurrentQuarterDAO;
import co.edu.sena.daowariosoft.controller.factory.CurrentQuarterDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlCurrentQuarterDAOFactory implements CurrentQuarterDAOFactory{

    @Override
    public CurrentQuarterDAO create() {
        return new MysqlCurrentQuarterDAO();
    }
    
}
