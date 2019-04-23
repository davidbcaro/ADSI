
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.ActivityDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.ActivityImpl;

/**
 *
 * @author WINDOWS 8
 */
public class ActivityFactory {
     public static ActivityDAO create(Class entityClass) {
        return new ActivityImpl(entityClass);
    }
    
}
