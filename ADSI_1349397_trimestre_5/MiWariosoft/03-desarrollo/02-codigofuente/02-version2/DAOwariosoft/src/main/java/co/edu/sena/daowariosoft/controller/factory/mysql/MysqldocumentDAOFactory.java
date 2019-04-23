/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.mysql.MysqldocumentDAO;
import co.edu.sena.daowariosoft.controller.dao.DocumentDAO;
import co.edu.sena.daowariosoft.controller.factory.DocumentDAOFactory;


/**
 *
 * @author 1349397
 */
public class MysqldocumentDAOFactory implements DocumentDAOFactory {

    public DocumentDAO create() {
        return new MysqldocumentDAO();
    }
}
