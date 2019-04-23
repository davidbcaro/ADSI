/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;

import co.edu.sena.wariosoftjpa.controller.dao.DocumentDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.DocumentImpl;

/**
 *
 * @author WINDOWS 8
 */
public class DocumentFactory {
    
    public static DocumentDAO create(Class entityClass){
        return new DocumentImpl (entityClass);
    }
}
