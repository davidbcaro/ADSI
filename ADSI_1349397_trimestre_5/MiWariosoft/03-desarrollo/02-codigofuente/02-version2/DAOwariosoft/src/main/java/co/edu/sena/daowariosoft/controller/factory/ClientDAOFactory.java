/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.factory;

import co.edu.sena.daowariosoft.controller.dao.ClientDAO;

/**
 *
 * @author Brayan
 */
public interface ClientDAOFactory {
    public ClientDAO create();
}
