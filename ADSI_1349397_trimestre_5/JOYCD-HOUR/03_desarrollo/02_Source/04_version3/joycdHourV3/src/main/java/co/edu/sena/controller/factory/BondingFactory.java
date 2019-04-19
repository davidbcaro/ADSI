/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.BondingDAO;
import co.edu.sena.controller.dao.mysql.BondingDAOImpl;

/**
 *
 * @author 1349397
 */
public  class BondingFactory{
        public static BondingDAO create(Class entityClass){
        return new BondingDAOImpl(entityClass);
    }
}
