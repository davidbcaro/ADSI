/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.ModalityDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.ModalityImpl;

/**
 *
 * @author Brayan
 */
public class ModalityFactory {
    public static ModalityDAO create(Class entityClass){
        return new ModalityImpl (entityClass);
    }
}
