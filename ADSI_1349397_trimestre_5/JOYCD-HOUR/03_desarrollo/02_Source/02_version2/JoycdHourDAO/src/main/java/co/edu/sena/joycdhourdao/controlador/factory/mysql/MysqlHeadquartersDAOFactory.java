/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.HeadquartersDAO;
import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlHeadquartersDAO;
import co.edu.sena.joycdhourdao.controlador.factory.HeadquartersDAOFactory;

/**
 *
 * @author liosalfar
 */
public class MysqlHeadquartersDAOFactory implements HeadquartersDAOFactory{

    @Override
    public HeadquartersDAO create() {
        return new MysqlHeadquartersDAO ();
    }
    
}
