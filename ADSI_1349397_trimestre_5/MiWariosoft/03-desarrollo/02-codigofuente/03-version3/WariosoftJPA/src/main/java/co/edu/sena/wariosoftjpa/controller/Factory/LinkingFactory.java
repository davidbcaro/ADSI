/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.LinkingDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.LinkingImpl;

/**
 *
 * @author 1349397
 */
public class LinkingFactory {
    public static LinkingDAO create(Class entityClass){
        return new LinkingImpl (entityClass);
    }
}
