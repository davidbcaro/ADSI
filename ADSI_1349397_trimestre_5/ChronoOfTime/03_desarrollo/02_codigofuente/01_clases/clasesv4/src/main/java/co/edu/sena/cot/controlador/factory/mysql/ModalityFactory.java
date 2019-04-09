/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.factory.mysql;

import co.edu.sena.cot.controlador.dao.InterfaceDao;
import co.edu.sena.cot.controlador.dao.ModalityDao;
import co.edu.sena.cot.controlador.dao.mysql.ModalityDaoImpl;
import co.edu.sena.cot.modelo.dto.Modality;

/**
 *
 * @author Natsumi
 */
public class ModalityFactory {

    public static ModalityDao create (Class entityClass){
    return new ModalityDaoImpl(entityClass);
    }
    
}

