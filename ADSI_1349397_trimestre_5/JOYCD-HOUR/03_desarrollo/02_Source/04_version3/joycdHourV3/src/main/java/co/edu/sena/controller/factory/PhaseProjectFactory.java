/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.PhaseProjectDAO;
import co.edu.sena.controller.dao.mysql.PhaseProjectDAOImpl;

/**
 *
 * @author 1349397
 */
public class PhaseProjectFactory {
    public static PhaseProjectDAO create (Class entityClass){        
        return new PhaseProjectDAOImpl (entityClass);
    }
}
