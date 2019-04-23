/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.UserDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.UserImpl;

/**
 *
 * @author WINDOWS 8
 */
public class UserFactory {
    public static UserDAO create(Class entityClass) {
        return new UserImpl(entityClass);
    }
    
}
