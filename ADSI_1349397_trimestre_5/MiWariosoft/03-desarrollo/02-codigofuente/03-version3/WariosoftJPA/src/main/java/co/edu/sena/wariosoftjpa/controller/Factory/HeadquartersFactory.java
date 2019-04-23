/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.mysql.HeadquartersImpl;
import co.edu.sena.wariosoftjpa.controller.dao.HeadquartersDAO;
/**
 *
 * @author Sebastian
 */
public class HeadquartersFactory {
    public static HeadquartersDAO create(Class entityClass){
        return new HeadquartersImpl(entityClass);
    }
}
