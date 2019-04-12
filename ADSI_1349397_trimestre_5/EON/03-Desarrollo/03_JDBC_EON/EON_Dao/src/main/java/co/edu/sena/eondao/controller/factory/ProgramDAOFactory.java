/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.factory;

import co.edu.sena.eondao.controller.dao.ProgramDAO;

/**
 *
 * @author LUISBERNARDO
 */
public interface ProgramDAOFactory {
    public ProgramDAO create();
}
