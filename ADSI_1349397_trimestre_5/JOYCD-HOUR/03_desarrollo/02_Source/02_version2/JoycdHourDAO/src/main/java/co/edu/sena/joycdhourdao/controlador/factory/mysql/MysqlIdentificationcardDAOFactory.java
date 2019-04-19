/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.IdentificationcardDAO;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlIdentificationcardDAO;
import co.edu.sena.joycdhourdao.controlador.factory.IdentificationcardDAOFactory;

/**
 *
 * @author Usser
 */
public class MysqlIdentificationcardDAOFactory implements IdentificationcardDAOFactory {
    
    @Override
       public IdentificationcardDAO create(){
        return new MysqlIdentificationcardDAO();
       }
    
}
