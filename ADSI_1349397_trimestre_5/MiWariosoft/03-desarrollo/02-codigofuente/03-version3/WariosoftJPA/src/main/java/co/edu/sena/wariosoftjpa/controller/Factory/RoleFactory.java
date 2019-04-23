/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.RoleDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.RoleImpl;

/**
 *
 * @author Brayan
 */
public class RoleFactory {
    public static RoleDAO create(Class entityClass){
        return new RoleImpl (entityClass);
    }
}
