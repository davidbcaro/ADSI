/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.StatusGroupNumberDAO;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlStatusGroupNumber;
import co.edu.sena.joycdhourdao.controlador.factory.StatusGroupNumberDAOFactory;

/**
 *
 * @author 1349397
 */
public class MysqlStatusGroupNumberDAOFactory implements StatusGroupNumberDAOFactory{
     @Override
       public StatusGroupNumberDAO create(){
        return new MysqlStatusGroupNumber();
}
    
}
