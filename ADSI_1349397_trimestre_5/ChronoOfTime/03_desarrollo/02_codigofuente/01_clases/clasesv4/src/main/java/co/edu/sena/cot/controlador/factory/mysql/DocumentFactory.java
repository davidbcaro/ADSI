/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.DocumentDao;
import co.edu.sena.cot.controlador.dao.mysql.DocumentDaoImpl;

/**
 *
 * @author Natsumi
 */
public class DocumentFactory {
    public static DocumentDao create(Class entityClass){
    return new DocumentDaoImpl (entityClass);
    }
}
