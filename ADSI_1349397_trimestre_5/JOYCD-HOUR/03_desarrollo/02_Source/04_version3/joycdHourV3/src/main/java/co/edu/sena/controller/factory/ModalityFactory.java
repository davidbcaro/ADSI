/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.factory;

import co.edu.sena.controller.dao.ModalityDAO;
import co.edu.sena.controller.dao.mysql.ModalityDAOImpl;

/**
 *
 * @author liosalfar
 */
public class ModalityFactory {

    public static ModalityDAO create(Class entityClass) {
        return new ModalityDAOImpl(entityClass);
    }

}