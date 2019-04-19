/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.mysql.MysqlSpecialityDAO;
import co.edu.sena.joycdhourdao.controlador.dao.SpecialityDAO;
import co.edu.sena.joycdhourdao.controlador.factory.SpecialityFactory;

/**
 *
 * @author 1349397
 */
public class MysqlSpecialityDAOFactry implements SpecialityFactory{
    
       @Override
       public SpecialityDAO create(){
        return new MysqlSpecialityDAO();
}
    
}
