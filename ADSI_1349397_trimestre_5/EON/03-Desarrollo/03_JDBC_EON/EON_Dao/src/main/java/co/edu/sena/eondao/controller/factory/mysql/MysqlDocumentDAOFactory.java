/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.factory.mysql;



import co.edu.sena.eondao.controller.dao.DocumentDAO;
import co.edu.sena.eondao.controller.dao.mysql.MysqlDocumentDAO;
import co.edu.sena.eondao.controller.factory.DocumentDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlDocumentDAOFactory implements DocumentDAOFactory{

    @Override
    public DocumentDAO create() {
        return new MysqlDocumentDAO();
    }
    
}