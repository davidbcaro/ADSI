/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory.mysql;

import co.edu.sena.daowariosoft.controller.dao.HeadquartersDAO;


import co.edu.sena.daowariosoft.controller.dao.mysql.MysqlHeadquartersDAO;
import co.edu.sena.daowariosoft.controller.factory.HeadquartersDAOFactory;

/**
 *
 * @author WINDOWS 8
 */
public class MysqlHeadquartersDAOFactory implements HeadquartersDAOFactory {

    @Override
    public HeadquartersDAO create() {
        return new MysqlHeadquartersDAO();
    }

   
    }

   

   
    
    

