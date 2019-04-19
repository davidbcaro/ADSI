/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.factory;

import co.edu.sena.joycdhourdao.controlador.dao.EnvironmentDAO;


/**
 *
 * @author liosalfar
 */
public interface EnvironmentDAOFactory {
   
    public EnvironmentDAO create();
}
